package com.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Created by xueliming on 3/16/16.
 */
public class JaxbSample {

    private String aa = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<Countries>\n" +
            "\t<Country importance=\"1\">\n" +
            "\t\t<Country_Name>Spain</Country_Name>\n" +
            "\t\t<Country_Capital>Madrid</Country_Capital>\n" +
            "\t\t<Country_Foundation_Date></Country_Foundation_Date>\n" +
            "\t\t<Country_Continent>Europe</Country_Continent>\n" +
            "\t\t<Country_Population>0</Country_Population>\n" +
            "\t</Country>\n" +
            "\t<Country importance=\"0\">\n" +
            "\t\t<Country_Name>USA</Country_Name>\n" +
            "\t\t<Country_Capital>Washington</Country_Capital>\n" +
            "\t\t<Country_Foundation_Date></Country_Foundation_Date>\n" +
            "\t\t<Country_Continent>America</Country_Continent>\n" +
            "\t\t<Country_Population>0</Country_Population>\n" +
            "\t</Country>\n" +
            "</Countries>";

    public static void main(String[] args) {
        JaxbSample jaxbSample = new JaxbSample();
        try {
            jaxbSample.test();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void test() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance( Country.class );
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setImportance(1);
        spain.setPopulation( 45000000 );

        jaxbMarshaller.marshal( spain, System.out );
    }

}
