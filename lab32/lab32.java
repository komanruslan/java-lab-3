package Lab3.lab32;

abstract class Pair {
    public abstract Pair add(Pair other);
    public abstract Pair subtract(Pair other);
    public abstract Pair multiply(Pair other);
}

class Complex extends Pair {
    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public Pair add(Pair other) {
        Complex c = (Complex) other;
        return new Complex(this.real + c.real, this.imag + c.imag);
    }

    @Override
    public Pair subtract(Pair other) {
        Complex c = (Complex) other;
        return new Complex(this.real - c.real, this.imag - c.imag);
    }

    @Override
    public Pair multiply(Pair other) {
        Complex c = (Complex) other;
        double r = this.real * c.real - this.imag * c.imag;
        double i = this.real * c.imag + this.imag * c.real;
        return new Complex(r, i);
    }

    @Override
    public String toString() {
        return real + (imag >= 0 ? " + " : " - ") + Math.abs(imag) + "i";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Complex)) return false;
        Complex c = (Complex) obj;
        return Double.compare(c.real, real) == 0 && Double.compare(c.imag, imag) == 0;
    }
}

class Rational extends Pair {
    private int num;
    private int den; 

    public Rational(int num, int den) {
        if (den == 0) den = 1;
        this.num = num;
        this.den = den;
    }

    @Override
    public Pair add(Pair other) {
        Rational r = (Rational) other;
        int resNum = this.num * r.den + r.num * this.den;
        int resDen = this.den * r.den;
        return new Rational(resNum, resDen);
    }

    @Override
    public Pair subtract(Pair other) {
        Rational r = (Rational) other;
        int resNum = this.num * r.den - r.num * this.den;
        int resDen = this.den * r.den;
        return new Rational(resNum, resDen);
    }

    @Override
    public Pair multiply(Pair other) {
        Rational r = (Rational) other;
        return new Rational(this.num * r.num, this.den * r.den);
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Rational)) return false;
        Rational r = (Rational) obj;
        return this.num * r.den == r.num * this.den;
    }
}

public class lab32 {
    public static void main(String[] args) {
        System.out.println("Комплексні числа");
        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(1, 2);
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c1 + c2 = " + c1.add(c2));
        System.out.println("c1 - c2 = " + c1.subtract(c2));
        System.out.println("c1 * c2 = " + c1.multiply(c2));
        System.out.println("c1.equals(c2): " + c1.equals(c2));

        System.out.println("\nРаціональні дроби");
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r1 + r2 = " + r1.add(r2));
        System.out.println("r1 - r2 = " + r1.subtract(r2));
        System.out.println("r1 * r2 = " + r1.multiply(r2));
        System.out.println("r1.equals(r2): " + r1.equals(r2));
    }
}