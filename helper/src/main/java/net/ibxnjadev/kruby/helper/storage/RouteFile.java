package net.ibxnjadev.kruby.helper.storage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used for can convert a object to file
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface RouteFile {

    String route();

}
