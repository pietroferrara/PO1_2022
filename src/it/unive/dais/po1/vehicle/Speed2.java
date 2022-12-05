package it.unive.dais.po1.vehicle;

import java.lang.annotation.Annotation;

public class Speed2 implements Annotation {
    @Override
    public Class<? extends Annotation> annotationType() {
        return this.getClass();
    }
}
