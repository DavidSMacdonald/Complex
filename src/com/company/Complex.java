package com.company;

public class Complex {

    private double a;
    private double b;

    public Complex(double x, double y) {
        a = x;
        b = y;
    }

    public Complex(double x) {
        this(x, 0.0);
    }

    public double abs() {
        return Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
    }

    public Complex add(Complex other) {
        return new Complex(a+other.a, b+other.b);
    }
    public Complex add(double num) {
        return new Complex(a+num, b);
    }

    public Complex multiply(Complex other) {
        /*
        (a + bi)*(c + di)
        ac + adi + bci + bdi^2
        (ac-bd) + (ad + bc)i
        */
        double newA = (a*other.a - b*other.b);
        double newB = (a*other.b + b*other.a);
        return new Complex(newA,newB);
    }
    public Complex multiply(double num) {
        double newA = (a*num);
        double newB = (b*num);
        return new Complex(newA,newB);
    }

    public String toString() {
        return a + " + " + b + "i";
    }

    public static void main(String[] args) {
        Complex c = new Complex(1,2);
        Complex d = new Complex(3,0);
        double f = 3;
        System.out.println(c.abs());
        System.out.println(d.abs());

        System.out.println(c.add(d));
        System.out.println(c.add(f));

        System.out.println(c.multiply(d));
        System.out.println(c.multiply(f));
    }
}

/* OUTPUT
2.23606797749979
3.0
4.0 + 2.0i
4.0 + 2.0i
3.0 + 6.0i
3.0 + 6.0i
 */
