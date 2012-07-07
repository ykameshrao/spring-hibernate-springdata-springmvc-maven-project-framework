package com.yourpackagename.framework.data;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Spring Data Mongo Repository implementation to provide the
 * basic mongo based operations on a domain object
 *
 * @author: Y Kamesh Rao
 * @created: 3/25/12 11:06 PM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public abstract class BaseMongoCrudRepository<T extends MongoEntity, ID extends Serializable>
        implements BaseCrudRepository<T, ID> {
    protected MongoOperations mongoOperations;
    protected Class<T> clazz;


    @Override public T save(T entity) {
        mongoOperations.save(entity);
        return entity;
    }


    @Override public Iterable<T> save(Iterable<? extends T> entities) {
        Collection<T> savedEntities = new ArrayList<T>();
        for (T entity : entities) {
            entity = save(entity);
            savedEntities.add(entity);
        }

        return savedEntities;
    }


    @Override public T findOne(ID id) {
        return mongoOperations.findOne(new Query(Criteria.where("id").is(id)), clazz);
    }


    @Override public boolean exists(ID id) {
        T entity = findOne(id);
        return (entity != null) ? true : false;
    }


    @Override public Iterable<T> findAll() {
        return mongoOperations.findAll(clazz);
    }


    @Override public long count() {
        Collection<T> all = (Collection<T>) findAll();
        return all.size();
    }


    @Override public void delete(ID id) {
        mongoOperations.findAndRemove(new Query(Criteria.where("id").is(id)), clazz);
    }


    @Override public void delete(T entity) {
        mongoOperations.findAndRemove(new Query(Criteria.where("id").is(entity.getId())), clazz);
    }


    @Override public void delete(Iterable<? extends T> entities) {
        for (T entity : entities)
            delete(entity);
    }


    @Override public void deleteAll() {
        mongoOperations.dropCollection(clazz);
    }


    @Override public T update(ID id, Map<String, Object> keyValues) {
        T entity = null;
        for (Map.Entry<String, Object> entry : keyValues.entrySet()) {
            entity = mongoOperations.findAndModify(new Query(Criteria.where("id").is(id)),
                    Update.update(entry.getKey(), entry.getValue()), clazz);
        }
        return entity;
    }


    @Override public T update(T object, Map<String, Object> keyValues) {
        T entity = object;
        for (Map.Entry<String, Object> entry : keyValues.entrySet()) {
            entity = mongoOperations.findAndModify(new Query(Criteria.where("id").is(object.getId())),
                    Update.update(entry.getKey(), entry.getValue()), clazz);
        }
        return entity;
    }
}
