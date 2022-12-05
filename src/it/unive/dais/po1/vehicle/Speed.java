package it.unive.dais.po1.vehicle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
        ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER
}
)
@Retention(
        RetentionPolicy.RUNTIME
)
public @interface Speed {
    String type() default "km/h";
    boolean forward();
}
