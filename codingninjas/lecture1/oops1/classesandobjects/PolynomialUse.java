package codingninjas.lecture1.oops1.classesandobjects;

public class PolynomialUse {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.setCoefficient(2, 1);
        p1.setCoefficient(3, 2);
        p1.setCoefficient(6, 4);
        p1.print();

        System.out.println("==================");

        Polynomial p2 = new Polynomial();
        p2.setCoefficient(4, 3);
        p2.setCoefficient(2, 1);
        p2.print();

        System.out.println("===========================================");
        //p1 = p1.add(p2);
        p1 = p1.subtract(p2);
        p1.print();
        System.out.println("===========================================");
    }
}
