package com.yourpackagename.framework.data;

import com.yourpackagename.framework.exception.service.NotYetImplementedException;
import com.yourpackagename.framework.validation.EntityValidator;
import com.yourpackagename.framework.validation.Validity;

import java.io.Serializable;

/**
 * BaseService implementation for basic access to service
 * methods of crud operation on entity
 *
 *
 * @author: Y Kamesh Rao
 * @created: 3/25/12 10:41 PM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public abstract class BaseMongoServiceImpl<T extends Entity, ID extends Serializable> implements BaseService<T, ID> {
    protected BaseCrudRepository baseCrudRepository;
    protected Class<T> entityClass;

    @Override public T insert(T object) throws Exception {
        return (T) baseCrudRepository.save(object);
    }


    @Override public T update(T object) throws Exception {
        throw new NotYetImplementedException("Update not implemented in controller");
    }


    @Override public void delete(T object) throws Exception {
        baseCrudRepository.delete(object);
    }


    @Override public T findById(ID id) throws Exception {
        return (T) baseCrudRepository.findOne(id);
    }


    @Override public Validity validate(T object) {
        EntityValidator<T> entityValidator = new EntityValidator<T>();
        return entityValidator.validate(object, entityClass);
    }
}
