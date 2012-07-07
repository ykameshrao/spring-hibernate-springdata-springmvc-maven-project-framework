package com.yourpackagename.yourwebproject.model.entity.embedded;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yourpackagename.yourwebproject.common.Key;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Address embeddable entity
 *
 * @author: Y Kamesh Rao
 * @created: 4/5/12 9:04 AM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
@Embeddable
@XStreamAlias(Key.address)
@XmlRootElement(name = Key.address)
public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String postalCode;


    @XmlElement @NotNull @NotBlank
    public String getStreetAddress() {
        return streetAddress;
    }


    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }


    @XmlElement @NotNull @NotBlank
    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    @XmlElement @NotNull @NotBlank
    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    @XmlElement @NotNull @NotBlank
    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    @XmlElement @NotNull @NotBlank
    public String getPostalCode() {
        return postalCode;
    }


    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    @Override public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
