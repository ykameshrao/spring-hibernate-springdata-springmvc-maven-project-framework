package com.yourpackagename.yourwebproject.model.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yourpackagename.yourwebproject.common.Key;
import com.yourpackagename.yourwebproject.common.Props;
import com.yourpackagename.yourwebproject.model.entity.User;
import com.yourpackagename.yourwebproject.model.entity.embedded.Address;
import com.yourpackagename.yourwebproject.model.entity.enums.Role;
import lombok.Data;

/**
 * User Request Object
 *
 * @author: Y Kamesh Rao
 * @created: 3/11/12 12:54 AM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
@XStreamAlias(Key.user)
public @Data class UserRO {
    public String username;
    public String password;
    public String confirm;
    public String email;
    public String mobile;
    public @XStreamAlias(Key.role) Role role;
    public String companyName;
    public String streetAddress;
    public String city;
    public String state;
    public String country;
    public String postalCode;


    public User user(Props props) {
        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);
        user.setEmail(email);
        user.setMobile(mobile);

        if(role != null)
            user.setRole(role);
        else
            user.setRole(Role.USER);

        Address address = new Address();
        address.setStreetAddress(streetAddress);
        address.setCity(city);
        address.setState(state);
        address.setPostalCode(postalCode);
        if (country == null || country.trim().equalsIgnoreCase("")) {
            address.setCountry(props.fUserCountry);
        } else {
            address.setCountry(country);
        }

        user.setAddress(address);
        return user;
    }


    @Override public String toString() {
        return "UserRO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirm='" + confirm + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", role=" + role +
                ", companyName='" + companyName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
