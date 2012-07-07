package com.yourpackagename.framework.data;

import com.yourpackagename.framework.validation.Validity;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.Collection;

/**
 * Interface listing the most basic services required to be present in any
 * service built upon an domain entity object that is persisted using repository.
 *
 * @author: Y Kamesh Rao
 * @created: 3/25/12 10:40 PM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public interface BaseService<T extends Entity, ID extends Serializable> {
    /**
     * Method to setup the service with basic
     * required data. Called after Spring initialization.
     */
    public void setupService();

    /**
     * Service to insert the new object
     *
     * @param object
     *         The newly object
     */
    public T insert(T object) throws Exception;

    /**
     * Service to update an existing object
     *
     * @param object
     *         The existing object
     */
    public T update(T object) throws Exception;

    /**
     * Service to delete an existing object
     *
     * @param object
     *         The existing object
     */
    public void delete(T object) throws Exception;

    /**
     * Service to find an existing object by its given id and query name
     *
     * @param id
     *         Id of the resource
     */
    public T findById(ID id) throws Exception;


    /**
     * Service to find a collection of entities by pages
     *
     * @param pageNum
     * @param countPerPage
     * @param order
     *
     * @return
     *
     * @throws Exception
     */
    public Collection<T> findAllByPage(int pageNum, int countPerPage, Order order) throws Exception;


    /**
     * Service to validate the domain entity as per the validation
     * annotations on the entity fields.
     *
     * @param object
     *
     * @return
     */
    public Validity validate(T object);
}
