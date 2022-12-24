package me.xra1ny.application.annotations;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WindowInfo {
    /** Defines the "Title" or "Name" of the Window this Annotation is applied on */
    @NotNull
    String title();

    /** Defines the Width of the Window this Annotation is applied on */
    int width();

    /** Defines the Height of the Window this Annotation is applied on */
    int height();
}
