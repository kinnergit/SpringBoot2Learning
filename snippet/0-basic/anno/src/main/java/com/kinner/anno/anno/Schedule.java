package com.kinner.anno.anno;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Schedules.class)
@Retention(RetentionPolicy.SOURCE)
public @interface Schedule
{
    String value() default "";
}
