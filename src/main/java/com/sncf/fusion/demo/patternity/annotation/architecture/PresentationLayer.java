package com.sncf.fusion.demo.patternity.annotation.architecture;

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS)
@Documented
@Target(ElementType.PACKAGE)
public @interface PresentationLayer {
    String[] lowerLayer() default {};
}
