package com.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by richard.xue on 3/16/16.
 */
@XmlRootElement(name = "Countries")
public class Countries {
    List countries;

    /**
     * element that is going to be marshaled in the xml
     */
    @XmlElement(name = "Country")
    public void setCountries(List countries) {
        this.countries = countries;
    }
}
