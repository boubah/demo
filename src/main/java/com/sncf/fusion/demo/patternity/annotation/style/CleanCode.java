package com.sncf.fusion.demo.patternity.annotation.style;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Documented
public @interface CleanCode {

    String value() default "";
}
