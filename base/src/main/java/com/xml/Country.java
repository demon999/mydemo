package com.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by xueliming on 3/16/16.
 */
@XmlType
@XmlRootElement( name = "Country" )
public class Country {

    private String name;
    private int population;
    private String capital;
    private int importance;


    @XmlElement(name = "Country_Population")
    public void setPopulation(int population) {
        this.population = population;
    }


    @XmlElement(name = "Country_Name")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "Country_Capital")
    public void setCapital(String capital) {
        this.capital = capital;
    }

    @XmlAttribute(name = "importance", required = true)
    public void setImportance(int importance) {
        this.importance = importance;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public int getImportance() {
        return importance;
    }
}