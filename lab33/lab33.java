package Lab3.lab33;

interface IPair {

    IPair add(IPair other);
    IPair subtract(IPair other);
    IPair multiply(IPair other);
}

class ComplexNum implements IPair {
    private double real;
    private double imag;

    public ComplexNum(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public IPair add(IPair other) {
        ComplexNum c = (ComplexNum) other;
        return new ComplexNum(this.real + c.real, this.imag + c.imag);
    }

    @Override
    public IPair subtract(IPair other) {
        ComplexNum c = (ComplexNum) other;
        return new ComplexNum(this.real - c.real, this.imag - c.imag);
    }

    @Override
    public IPair multiply(IPair other) {
        ComplexNum c = (ComplexNum) other;
        double r = this.real * c.real - this.imag * c.imag;
        double i = this.real * c.imag + this.imag * c.real;
        return new ComplexNum(r, i);
    }

    @Override
    public String toString() {
        return real + (imag >= 0 ? " + " : " - ") + Math.abs(imag) + "i";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ComplexNum)) return false;
        ComplexNum c = (ComplexNum) obj;
        return Double.compare(c.real, real) == 0 && Double.compare(c.imag, imag) == 0;
    }
}

class RationalNum implements IPair {
    private int num;
    private int den;

    public RationalNum(int num, int den) {
        if (den == 0) den = 1;
        this.num = num;
        this.den = den;
    }

    @Override
    public IPair add(IPair other) {
        RationalNum r = (RationalNum) other;
        return new RationalNum(this.num * r.den + r.num * this.den, this.den * r.den);
    }

    @Override
    public IPair subtract(IPair other) {
        RationalNum r = (RationalNum) other;
        return new RationalNum(this.num * r.den - r.num * this.den, this.den * r.den);
    }

    @Override
    public IPair multiply(IPair other) {
        RationalNum r = (RationalNum) other;
        return new RationalNum(this.num * r.num, this.den * r.den);
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RationalNum)) return false;
        RationalNum r = (RationalNum) obj;
        return this.num * r.den == r.num * this.den;
    }
}

public class lab33 {
    public static void main(String[] args) {
        System.out.println("Тест інтерфейсу");
        IPair c1 = new ComplexNum(5, 3);
        IPair c2 = new ComplexNum(2, 1);
        System.out.println("Комплексні: (" + c1 + ") + (" + c2 + ") = " + c1.add(c2));

        IPair r1 = new RationalNum(2, 5);
        IPair r2 = new RationalNum(3, 4);
        System.out.println("Дроби: (" + r1 + ") * (" + r2 + ") = " + r1.multiply(r2));
    }
}