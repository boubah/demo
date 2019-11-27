package com.sncf.fusion.demo.patternity.annotation.ddd.stereotype;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Inherited
@Documented
public @interface Aggregate {

    /**
     * The Entity class that is the root of this aggregate; a class declared
     * here is assumed to be an Entity
     */
    Class<?> root();

    /**
     * Every Entity class that is part of this aggregate; every class declared
     * here is assumed to an Entity
     */
    Class<?>[] memberEntities() default {};
}
