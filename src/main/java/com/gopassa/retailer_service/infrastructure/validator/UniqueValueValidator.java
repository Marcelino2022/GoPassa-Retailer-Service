package com.gopassa.retailer_service.infrastructure.validator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


@SuppressWarnings("unused")
public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<?> entityClass;
    private String fieldName;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.entityClass = constraintAnnotation.entity();
        this.fieldName = constraintAnnotation.fieldName();
    }

    @Override
    @Transactional
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) return true;

        if (value instanceof java.util.UUID uuid) {
            value = uuid.toString();
        }

        try {
            String jpql = String.format(
                    "SELECT COUNT(e) FROM %s e WHERE e.%s = :value",
                    entityClass.getSimpleName(), fieldName
            );

            Long count = entityManager.createQuery(jpql, Long.class)
                    .setParameter("value", value)
                    .getSingleResult();

            return count == 0;

        } catch (Exception e) {
            return false;
        }
    }


}


