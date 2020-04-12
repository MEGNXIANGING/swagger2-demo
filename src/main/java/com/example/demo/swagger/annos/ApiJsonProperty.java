package com.example.demo.swagger.annos;
 
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiJsonProperty {

    String key();  //key

    String example() default "";

    Class type() default String.class;  //支持string 和 int

    boolean required() default true;

    String description() default "";
 
}