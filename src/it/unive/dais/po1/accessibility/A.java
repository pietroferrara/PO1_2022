package it.unive.dais.po1.accessibility;

import it.unive.dais.po1.accessibility.inner.C;

public class A {
    public int public_f;
    int default_f;
    private int private_f;

    void foo(A a, B b, C c) {
        c.public_f = 10;
        b.public_f = 10;
        a.public_f = 10;
        this.public_f = 10;
        //c.default_f = 10;
        b.default_f = 10;
        a.default_f = 10;
        this.default_f = 10;
        //c.private_f = 10;
        //b.private_f = 10;
        a.private_f = 10;
        this.private_f = 10;
    }
}
