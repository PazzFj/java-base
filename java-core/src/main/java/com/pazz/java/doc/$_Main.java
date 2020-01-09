package com.pazz.java.doc;

import lombok.Data;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author: 彭坚
 * @create: 2019/1/21 22:12
 * @description:
 */
public class $_Main {

    public static void main(String[] args) throws Exception {
        //创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //创建一个DocumentBuilder的对象
        try {
            //创建DocumentBuilder对象
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            /**
             * 添加 '/' 代表是 target\classes 目录下
             * 不添加则代表当前类所在的目录, 不包括自己!
             */
            String path = $_Main.class.getResource("/spring-mvc.xml").getPath();

            Document document = documentBuilder.parse(path);

            //获取所有book节点的集合
            NodeList bookList = document.getElementsByTagName("bean");
            System.out.println("一共有" + bookList.getLength() + "本书");

            for (int i = 0; i < bookList.getLength(); i++) {
                System.out.println("=================下面开始遍历第 " + (i + 1) + " 本书的内容=================");

                Node book = bookList.item(i);

                NamedNodeMap attrs = book.getAttributes();
                //遍历book的属性
                for (int j = 0; j < attrs.getLength(); j++) {
                    //通过item(index)方法获取book节点的某一个属性
                    Node attr = attrs.item(j);
                    //获取属性名 \ 获取属性值
                    System.out.println("属性名: " + attr.getNodeName() + "  属性值: " + attr.getNodeValue());
                }
                //解析book节点的子节点
                NodeList childNodes = book.getChildNodes();

                for (int k = 0; k < childNodes.getLength(); k++) {
                    System.out.println(childNodes.item(k).getNodeName());
//                    //区分出text类型的node以及element类型的node
//                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
//                        //获取了element类型节点的节点名
//                        System.out.print("第" + (k + 1) + "个节点的节点名："
//                                + childNodes.item(k).getNodeName());
//                        //获取了element类型节点的节点值
//                        System.out.println("--节点值是：" + childNodes.item(k).getFirstChild().getNodeValue());
//                        //System.out.println("--节点值是：" + childNodes.item(k).getTextContent());
//                    }
                }
                System.out.println("======================结束遍历第 " + (i + 1) + " 本书的内容=================\n");
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Data
    public static class CustomBean {
        private String id;
        private String name;
        private String cls;
    }

}
