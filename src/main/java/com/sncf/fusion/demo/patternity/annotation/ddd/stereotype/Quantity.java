package com.sncf.fusion.demo.patternity.annotation.ddd.stereotype;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Documented
@ValueObject
public @interface Quantity {
}
