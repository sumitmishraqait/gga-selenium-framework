package com.ggasoftware.uitest.control.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 12345 on 07.11.2014.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface JFindBy {
    public String using() default "";
    public String id() default "";
    public String name() default "";
    public String className() default "";
    public String css() default "";
    public String tagName() default "";
    public String linkText() default "";
    public String partialLinkText() default "";
    public String xpath() default "";

    public String group();
}
