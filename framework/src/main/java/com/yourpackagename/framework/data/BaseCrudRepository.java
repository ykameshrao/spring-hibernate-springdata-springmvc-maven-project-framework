package com.yourpackagename.framework.data;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.Map;

/**
 * To add framework level elements to the vanilla
 * Repository provided by spring data.
 *
 * @author: Y Kamesh Rao
 * @created: 3/25/12 10:40 PM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public interface BaseCrudRepository<T extends Entity, ID extends Serializable> extends CrudRepository<T, ID> {
    /**
     * Method to be implemented for providing the
     * repository with needed external resources
     */
    public void setupRepository();

    /**
     * Method to update the given key value pairs
     * in the object with the given ID
     *
     * @param id
     * @param keyValues
     * @return
     */
    public T update(ID id, Map<String, Object> keyValues);


    /**
     * Method to update the given key value pairs
     * in the given object
     *
     * @param object
     * @param keyValues
     * @return
     */
    public T update(T object, Map<String, Object> keyValues);
}
