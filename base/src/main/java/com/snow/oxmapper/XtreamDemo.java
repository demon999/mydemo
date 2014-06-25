package com.snow.oxmapper;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 14-6-23.
 */
public class XtreamDemo {
    public static void main(String[] args) {
        Person person = new Person();
        person.setId(1);
        person.setUsername("pengpanting");
        person.setPassword("ppt");

//        XStream xStream = new XStream(new StaxDriver());//stax解析xml
        XStream xStream = new XStream(new DomDriver());//dom4j解析xml

        // Mothed 1
//        String str = xStream.toXML(person);
//        System.out.println(str);
//
//        Person per = (Person)xStream.fromXML(str);
//        System.out.println(per.toString());

        // Mothed 2
        try {
            xStream.toXML(person,new FileOutputStream("person.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Person myPerson = (Person) xStream.fromXML(new FileInputStream("person.xml"));
            System.out.println(myPerson.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
