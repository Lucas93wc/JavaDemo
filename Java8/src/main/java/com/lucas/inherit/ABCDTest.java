package com.lucas.inherit;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-12-21 10:35
 */
public class ABCDTest {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        a.show(a);  // A.show(A)
        a.show(b);  // A.show(A)
        a.show(c);  // A.show(C)
        a.show(d);  // A.show(C)

        b.show(a);  // B.show(A)
        b.show(b);  // B.show(A)
        b.show(c);  // A.show(C)
        b.show(d);  // A.show(C)

        c.show(a);  // B.show(A)
        c.show(b);  // B.show(A)
        c.show(c);  // A.show(C)
        c.show(d);  // A.show(C)

        A ba = new B();
        ba.show(a);     // B.show(A)
        ba.show(b);     // B.show(A)
        ba.show(c);     // A.show(C)
        ba.show(d);     // A.show(C)
    }
}
