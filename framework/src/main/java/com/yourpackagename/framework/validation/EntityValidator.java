package com.yourpackagename.framework.validation;

import org.apache.commons.lang.WordUtils;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * Method to commonly validate the Spring and Hibernate
 * entity constraints on an object passed
 *
 * @author: Y Kamesh Rao
 * @created: 11/3/11 10:53 AM
 * @company: &copy; 2011-12, Kaleidosoft Labs
 */
public class EntityValidator<T> {
    
    private Logger log = LoggerFactory.getLogger(EntityValidator.class);

    /**
     * Validate the T object
     *
     * @param bean
     * @return
     */
    public Validity validate(T bean, Class<T> beanClass) {
        HashSet<String> err = new HashSet<String>();
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<T>> violations = validator.validate(bean);
        for (ConstraintViolation<T> violation : violations) {
            String propertyPath = violation.getPropertyPath().toString().toLowerCase();
            String message = violation.getMessage();
            String errMsg = WordUtils.capitalize(propertyPath) + " " + message;

            log.error("Invalid Value: '" + errMsg);
            err.add(errMsg);
        }

        // Checking for hibernate validations
        err.addAll(hValidate(bean, beanClass));

        List result = new ArrayList(err);
        return new Validity(result.isEmpty(), result);
    }


    /**
     * Validate the passed bean using the hibernate application level
     * validation
     *
     * @param bean
     * @param beanClass
     * @return
     */
    public HashSet<String> hValidate(T bean, Class<T> beanClass) {
        HashSet<String> err = new HashSet<String>();
        HibernateValidatorConfiguration config = Validation.byProvider(HibernateValidator.class).configure();
        Validator validator = config.buildValidatorFactory().getValidator();

        Set<ConstraintViolation<T>> hErrs = validator.validate(bean);
        log.info("Hibernate Validity Errors: " + hErrs.size());

        for (ConstraintViolation<T> violation : hErrs) {
            String propertyPath = violation.getPropertyPath().toString().toLowerCase();
            String message = violation.getMessage();
            String errMsg = WordUtils.capitalize(propertyPath) + " " + message;

            log.info("Invalid Value: '" + errMsg);
            err.add(errMsg);
        }


        return err;
    }
}
