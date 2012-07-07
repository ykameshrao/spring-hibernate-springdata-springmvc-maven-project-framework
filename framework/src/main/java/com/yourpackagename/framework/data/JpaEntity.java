package com.yourpackagename.framework.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.yourpackagename.framework.common.Key;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.Date;

/**
 * JpaEntity to declare fields to be in each entity table
 *
 * @author: Y Kamesh Rao
 */
@MappedSuperclass
public class JpaEntity<T extends Serializable> implements Entity {
    protected @XStreamAlias(value = Key.id) T id;
    protected @XStreamOmitField Date createdAt;
    protected @XStreamOmitField Date updatedAt;


    public JpaEntity() {
        createdAt = new Date();
        updatedAt = new Date();
    }


    /**
     * To make XStream deserialization assign values to
     * base class fields of createdAt and updatedAt
     *
     * @return
     */
    public Object readResolve() {
        if (this.createdAt == null) {
            this.createdAt = new Date();
            this.updatedAt = createdAt;
        }

        return this;
    }


    @XmlElement(type = Object.class) @Id @GeneratedValue
    public T getId() {
        return id;
    }


    public void setId(T id) {
        this.id = id;
    }


    @JsonIgnore @Temporal(TemporalType.DATE) @Column
    public Date getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    @JsonIgnore @Temporal(TemporalType.TIMESTAMP) @Column
    public Date getUpdatedAt() {
        return updatedAt;
    }


    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
