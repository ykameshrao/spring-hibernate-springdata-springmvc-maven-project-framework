package com.yourpackagename.yourwebproject.model.entity;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.yourpackagename.framework.data.JpaEntity;
import com.yourpackagename.yourwebproject.common.Key;
import com.yourpackagename.yourwebproject.model.entity.embedded.Address;
import com.yourpackagename.yourwebproject.model.entity.enums.Role;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * User entity
 *
 * @author: Y Kamesh Rao
 * @created: 3/22/12 9:02 AM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@XmlRootElement(name = Key.user)
public class User extends JpaEntity<Long> implements Serializable {
    private String userName;
    private String email;
    private String mobile;
    private Role role;
    private Address address;
    private @XStreamOmitField String passWord;
    private @XStreamOmitField Integer loginCount;
    private @XStreamOmitField Date currentLoginAt;
    private @XStreamOmitField Date lastLoginAt;
    private @XStreamOmitField String currentLoginIp;
    private @XStreamOmitField String lastLoginIp;


    @XmlElement @NotNull @Length(min = 6, max = 15) @NotBlank @Column
    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    @XmlElement @NotNull @Email @NotBlank @Column
    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    @XmlElement @NotNull @NotBlank @Column
    public String getMobile() {
        return mobile;
    }


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    @XmlElement(name = Key.role) @NotNull @Column
    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }


    @JsonIgnore @NotNull @Column
    public String getPassWord() {
        return passWord;
    }


    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    @JsonIgnore @Column
    public Integer getLoginCount() {
        return loginCount;
    }


    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }


    @JsonIgnore @Column
    public Date getCurrentLoginAt() {
        return currentLoginAt;
    }


    public void setCurrentLoginAt(Date currentLoginAt) {
        this.currentLoginAt = currentLoginAt;
    }


    @JsonIgnore @Column
    public Date getLastLoginAt() {
        return lastLoginAt;
    }


    public void setLastLoginAt(Date lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }


    @JsonIgnore @Column
    public String getCurrentLoginIp() {
        return currentLoginIp;
    }


    public void setCurrentLoginIp(String currentLoginIp) {
        this.currentLoginIp = currentLoginIp;
    }


    @JsonIgnore @Column
    public String getLastLoginIp() {
        return lastLoginIp;
    }


    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }


    @XmlElement @Embedded @Valid
    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }



    /**
     * Method to create the SHA hash of the password before storing
     *
     * @param pass
     *
     * @return SHA hash digest of the password
     */
    public static synchronized String hashPassword(String pass) {
        return org.apache.commons.codec.digest.DigestUtils.shaHex(pass);
    }


    @Override public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", role=" + role +
                ", loginCount=" + loginCount +
                ", currentLoginAt=" + currentLoginAt +
                ", lastLoginAt=" + lastLoginAt +
                ", currentLoginIp='" + currentLoginIp + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                '}';
    }
}
