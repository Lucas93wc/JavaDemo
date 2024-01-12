package com.lucas.xml;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-05-17 10:43
 */
public class Dom4j_XMLTest {
    private Element root;

    private Document doc;

    @Test
    public void test05() {
        doc = DocumentHelper.createDocument();
        Element element = doc.addElement("Root");
        element.addAttribute("aa", "bb");
        System.out.println(doc.getRootElement().getName());

    }

    // 测试删除root节点下子节点
    @Test
    public void test04() {
        doc = DocumentHelper.createDocument();
        root = doc.addElement("root");
        root.addElement("a1").addAttribute("id", "a1");
        root.addElement("a2").addAttribute("id", "a2");
        root.addElement("a3").addAttribute("id", "a3");
        root.addElement("a4").addAttribute("id", "a4");
        root.addElement("a5").addAttribute("id", "a5");

        for (Object obj : root.elements()) {
            Element node = (Element) obj;

            if (node.getName() == "a2") root.remove(node);

            if (node.getName() == "a3") node.addElement("a31").addAttribute("id", "a31");
        }
        System.out.println(doc.asXML());
    }

    @Test
    public void test03() {
        doc = DocumentHelper.createDocument();
        root = doc.addElement("root");
        Element node = root.addElement("a1");

        Element test = DocumentHelper.createElement("test");
        test.addAttribute("id", "001");
        root.add(test);
//        test.setName("a2");
        Element test1 = DocumentHelper.createElement("test");
        root.add(test1);
        System.out.println(doc.asXML());

    }
    @Test
    public void test02() {

        doc = DocumentHelper.createDocument();
        root = doc.addElement("root");
        Element node = root.addElement("a1");
        node.addAttribute("id", "aaa");
        node.addAttribute("name", "aa2");
        System.out.println(doc.asXML());

        //测试修改节点属性
        node.addAttribute("id", "aab");
        System.out.println(doc.asXML());
    }

    @Test
    public void test01() {

        doc = DocumentHelper.createDocument();
        root = doc.addElement("dsa");
        root.addElement("a1");
        root.addElement("a2");
        root.addElement("a3");
        root.addElement("a4");
        root.addElement("a5");

//        System.out.println(doc.getRootElement().getName());
        System.out.println(doc.asXML());

        for (Object obj : root.elements()) {
            Element obj1 = (Element) obj;
            if (obj1.getName() == "a3") {
                root.remove(obj1);
            }
        }

        System.out.println(doc.asXML());
    }

}
