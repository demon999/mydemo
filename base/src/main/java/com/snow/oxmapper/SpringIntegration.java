package com.snow.oxmapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.Unmarshaller;

import javax.annotation.Resource;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

/**
 * Created by Administrator on 14-6-23.
 */
public class SpringIntegration {

    @Resource
    private static Unmarshaller jaxbMarshaller;

    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("users.xml");
        try {
            Users users = (Users) jaxbMarshaller.unmarshal(new StreamSource(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
