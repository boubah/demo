package com.sncf.fusion.demo.patternity.annotation.ddd.stereotype;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Inherited
@Documented
public @interface Repository {

    /**
     * The Entity that is the root of the aggregate managed by this repository
     */
    Class<?>[] value() default {};
}
