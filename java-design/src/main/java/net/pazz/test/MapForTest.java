package net.pazz.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Peng Jian
 * @create: 2018/10/22 9:56
 * @description:
 */
public class MapForTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "ab");
        map.put(4, "ab");
        map.put(4, "ab");// 和上面相同 ， 会自己筛选
        System.out.println(map.size());
        // settings->build,execution,deployment->debugger->stepping
    }

}
