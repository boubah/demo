package com.sncf.fusion.demo.patternity.annotation.ddd.stereotype;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@Inherited
public @interface Policy {

    String[] section() default {};
}
