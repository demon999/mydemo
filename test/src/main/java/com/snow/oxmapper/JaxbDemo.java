package com.snow.oxmapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by Administrator on 14-6-23.
 */
public class JaxbDemo {

    public static void main(String[] args)  {
        try {
            System.out.println(getXml());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象转xml
     * @return
     * @throws Exception
     */
    public static String getXml() throws Exception {
        User dto = new User();
        dto.setId(12);
        dto.setPassword("ppt");
        dto.setUsername("ppt");
        JAXBContext jaxb = JAXBContext.newInstance(User.class);
        Marshaller marshaller = jaxb.createMarshaller();
        StringWriter sw = new StringWriter();
        marshaller.marshal(dto, sw);
        marshaller.marshal(dto, new FileOutputStream("user.xml"));
        return sw.toString();
    }

    /**
     * xml转对象
     * @param xml
     * @return
     * @throws Exception
     */
    private static User getObject(String xml) throws Exception {
        JAXBContext jaxb = JAXBContext.newInstance(User.class);
        Unmarshaller unmarshaller = jaxb.createUnmarshaller();
        User user = (User)unmarshaller.unmarshal(new StringReader(xml));
        return user;
    }
}
