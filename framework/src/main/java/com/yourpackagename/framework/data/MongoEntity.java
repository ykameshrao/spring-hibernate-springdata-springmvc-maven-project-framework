package com.yourpackagename.framework.data;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

/**
 * MongoEntity to declare fields to be in each domain entity
 *
 * @author: Y Kamesh Rao
 * @created: 3/25/12 10:38 PM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public class MongoEntity<ID> implements Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected ID id;
    protected Date createdAt;
    protected Date updatedAt;


    public MongoEntity() {
        createdAt = new Date();
        updatedAt = createdAt;
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


    public Object getId() {
        if (id instanceof ObjectId)
            return id.toString();
        else if (id instanceof String)
            return id.toString();
        else
            return id;
    }


    public void setId(ID id) {
        this.id = id;
    }


    public Date getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public Date getUpdatedAt() {
        return updatedAt;
    }


    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
