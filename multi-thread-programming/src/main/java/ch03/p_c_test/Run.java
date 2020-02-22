package ch03.p_c_test;

public class Run {

    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);

        new ThreadP(p).start();
        new ThreadC(c).start();
    }
}
