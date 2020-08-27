package com.alibaba.java8.Adapter.适配器模式应用;

import org.w3c.dom.NodeList;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import java.io.*;

public class ReadXML {
    public static Object getObject() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            //doc = builder.parse(new File("src/config.xml"));
            doc = builder.parse(new File(ReadXML.class.getResource("/").getPath()+"config.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = "com.alibaba.java8.Adapter.适配器模式应用." + classNode.getNodeValue();
            Class<?> c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
