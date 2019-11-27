package com.sncf.fusion.demo.patternity.annotation.strategic;

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS)
@Documented
@Target(ElementType.PACKAGE)
public @interface AntiCorruptionLayer {

    Class<?>[] hedgesAgainstContexts() default {};

    String[] hedgedFrom() default {};
}
