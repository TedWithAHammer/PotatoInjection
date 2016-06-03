package com.leo.potato;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Leo on 2016/5/23.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PotatoInjection {

    int id() default -1;

    String idStr() default "";

    String click() default "";

    String longClick() default "";
//    String itemClick() default "";
}
