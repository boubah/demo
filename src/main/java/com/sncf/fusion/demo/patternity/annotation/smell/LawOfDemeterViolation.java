package com.sncf.fusion.demo.patternity.annotation.smell;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LawOfDemeterViolation {

    String value() default "";
}
