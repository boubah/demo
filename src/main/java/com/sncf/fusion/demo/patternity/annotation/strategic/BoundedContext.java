package com.sncf.fusion.demo.patternity.annotation.strategic;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Documented
public @interface BoundedContext {

    String value();
}
