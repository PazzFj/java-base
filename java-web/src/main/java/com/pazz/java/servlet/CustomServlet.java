package com.pazz.java.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * @author: 彭坚
 * @create: 2019/12/26 20:58
 * @description:
 */
public class CustomServlet extends HttpServlet {

    //加载配置文件
    private Properties properties;

    // 存放包路径下所有的类名
    private List<String> classNames = new ArrayList<>();

    // 类容器
    private Map<String, Object> ioc = new HashMap<>();

    // 请求路径对应的Method 容器
    Map<String, Method> handlerMapping = new HashMap<>();

    // MyController注解类 容器
    Map<String, Object> controllerMap = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("500!! Server Exception");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    /**
     * 装载配置属性
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            // 加载配置文件
            doLoadConfig();
            // 根据路径扫描, 存储类路径到容器
            doScanner(properties.getProperty("scanPackage"));
            // 根据类路径初始化, 存储到 ioc 容器
            doInstance();
            // 遍历 ioc 容器, 处理路径方法映射
            initHandlerMapping();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 请求逻辑映射执行处理
     */
    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        uri = uri.replace(contextPath, "").replaceAll("/+", "/");
        if (!handlerMapping.containsKey(uri)) {
            resp.getWriter().write("404 NOT FOUND!");
            return;
        }
        Method method = handlerMapping.get(uri);
        Class<?>[] clazz = method.getParameterTypes();  // 请求参数类型
//        Map<String, String[]> parameterMap = req.getParameterMap(); // 获取请求的参数
        Enumeration enumeration = req.getParameterNames();
        Parameter[] parameters = method.getParameters();

        Object[] objects = new Object[clazz.length]; // 方法的参数

        for (int i = 0; i < clazz.length; i++) {
            //根据参数名称，做某些处理
            String requestParam = clazz[i].getSimpleName();
            if (requestParam.equals("HttpServletRequest")) {
                objects[i] = req;
                continue;
            }
            if (requestParam.equals("HttpServletResponse")) {
                objects[i] = resp;
                continue;
            }
//            if (requestParam.equals("String")){
//                for (Map.Entry<String, String[]> param : parameterMap.entrySet()){
//                    String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", "");
//                    objects[i] = value;
//                }
//            }

            CustomReqParam customReqParam = parameters[i].getDeclaredAnnotation(CustomReqParam.class);
            if (null != customReqParam) {
//                MyRequestParam myRequestParam = clazz[i].getAnnotation(MyRequestParam.class);
                String name = customReqParam.value();
                while(enumeration.hasMoreElements()){
                    String value = enumeration.nextElement().toString();
                    if(value.equals(name)){
                        objects[i] = req.getParameter(name);
                    }
                }
//                for (Map.Entry<String, String[]> param : parameterMap.entrySet()) {
//                    if (param.getKey().equals(name)) {
//                        String value = Arrays.toString(name.getBytes()).replaceAll("\\[|\\]", "").replaceAll(",\\s", "");
//                        objects[i] = value;
//                    }
//                }
            }
        }

        // 方法执行, 对象及参数
        Object o = method.invoke(controllerMap.get(uri), objects);
        resp.getWriter().print(o);
    }

    //1.加载配置文件
    private void doLoadConfig() throws IOException {
        properties = new Properties();
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("/application.properties");
        properties.load(inputStream);
    }

    //2.初始化所有相关联的类,扫描用户设定的包下面所有的类
    private void doScanner(String path) throws FileNotFoundException {
        File file = new File(this.getClass().getResource("/").getPath() + path.replace(".", "/"));
        for (File f : file.listFiles()) {
            if (!f.isDirectory()) {
                String className = path + "." + f.getName().replace(".class", "");
                classNames.add(className);
            } else {
                doScanner(path);
            }
        }
    }

    //3.拿到扫描到的类,通过反射机制,实例化,并且放到ioc容器中(k-v  beanName-bean) beanName默认是首字母小写
    private void doInstance() {
        if (classNames.isEmpty())
            return;

        classNames.forEach(className -> {
            try {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(CustomController.class)) {
                    ioc.put(toLowerFirstWord(clazz.getName()), clazz.newInstance());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    //4.初始化HandlerMapping(将url和method对应上)
    private void initHandlerMapping() throws IllegalAccessException, InstantiationException {
        if (ioc.isEmpty())
            return;
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class c = entry.getValue().getClass();
            if (!c.isAnnotationPresent(CustomController.class)) {
                continue;
            }
            //拼url时,是controller头的url拼上方法上的url
            String baseUrl = "";
            if (c.isAnnotationPresent(CustomReqMapping.class)) {
                CustomReqMapping customReqMapping = (CustomReqMapping) c.getAnnotation(CustomReqMapping.class);
                baseUrl = customReqMapping.value();
            }

            Method[] methods = c.getMethods();
            for (Method method : methods) {
                if (!method.isAnnotationPresent(CustomReqMapping.class)) {
                    continue;
                }
                CustomReqMapping customReqMapping = method.getAnnotation(CustomReqMapping.class);
                String url = customReqMapping.value();
                url = (baseUrl + "/" + url).replaceAll("/+", "/");
                handlerMapping.put(url, method);
                controllerMap.put(url, c.newInstance());
            }

        }
    }

    /**
     * 把字符串的首字母小写
     */
    private String toLowerFirstWord(String name) {
        char[] charArray = name.toCharArray();
        charArray[0] += 32;
        return String.valueOf(charArray);
    }

}
