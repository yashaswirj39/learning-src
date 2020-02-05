package codingninjas.lecture1.oops1.classesandobjects;

public class ComplexNumber {
    private int real;
    private int imaginary;

    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public void print() {
        System.out.println(this.real + " + i" + this.imaginary);
    }

    public void add(ComplexNumber c2) {
        this.real = this.real + c2.real;
        this.imaginary = this.imaginary + c2.imaginary;
    }

    public void multiply(ComplexNumber c2) {
        int newReal = (this.real * c2.real) - (this.imaginary * c2.imaginary);
        int newImg = (this.real * c2.imaginary) + (this.imaginary * c2.real);
        this.real = newReal;
        this.imaginary = newImg;
    }

    public ComplexNumber conjugate() {
        return null;
    }

    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2) {
        int newRealNum = c1.real + c2.real;
        int newImaginary = c1.imaginary + c2.imaginary;
        ComplexNumber c3 = new ComplexNumber(newRealNum, newImaginary);
        return c3;
    }
}
