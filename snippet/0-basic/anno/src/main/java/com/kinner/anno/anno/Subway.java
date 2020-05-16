package com.kinner.anno.anno;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Subway {
    String code() default "null";
    String name() default "empty";
}
