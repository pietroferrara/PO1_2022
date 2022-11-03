package it.unive.dais.po1.accessibility;

import it.unive.dais.po1.accessibility.inner.C;

public class A {

    A_default a;
    public int public_f;
    int default_f;
    private int private_f;
    protected int protected_f;

    public static final int static_final_f = 10;

    final int final_f = 10;

    final static int[] array;

    static {
        array = new int[A.perform_static_computation()];
    }

    private static int perform_static_computation() {
        return (int) Math.random()*1000;
    }


    static final void foo_static_final() {}
    public void foo_public (A a, B b, C c) { }
    protected void foo_protected (A a, B b, C c) { }
    void foo_default (A a, B b, C c) { }
    private void foo_private (A a, B b, C c) { }
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
