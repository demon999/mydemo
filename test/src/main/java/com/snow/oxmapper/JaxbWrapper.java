package com.snow.oxmapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.HashMap;

/**
 * Created by Administrator on 14-6-23.
 */
public class JaxbWrapper <T> {

    public JaxbWrapper(T t) {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(t.getClass());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
