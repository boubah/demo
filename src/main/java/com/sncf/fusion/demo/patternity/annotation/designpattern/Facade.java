package com.sncf.fusion.demo.patternity.annotation.designpattern;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Inherited
@Documented
public @interface Facade {

    /**
     * Each class this facades shields from
     */
    Class<?>[] subFacades() default {};

    /**
     * The descriptions of each sub-system this facades shields from
     */
    Class<?>[] subSystems() default {};
}
