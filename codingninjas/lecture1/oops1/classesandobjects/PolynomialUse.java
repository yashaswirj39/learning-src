package codingninjas.lecture1.oops1.classesandobjects;

import java.util.Scanner;

public class PolynomialUse {
    public static void main(String[] args) {
        /*Polynomial p1 = new Polynomial();
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

        System.out.println("=============================================");
        p1 = p1.multiply(p2);
        p1.print();
        System.out.println("=============================================");*/
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int degree1[] = new int[n];
        for(int i = 0; i < n; i++){
            degree1[i] = s.nextInt();
        }
        int coeff1[] = new int[n];
        for(int i = 0; i < n; i++){
            coeff1[i] = s.nextInt();
        }
        Polynomial first = new Polynomial();
        for(int i = 0; i < n; i++){
            first.setCoefficient(degree1[i],coeff1[i]);
        }
        first.print();
        n = s.nextInt();
        int degree2[] = new int[n];
        for(int i = 0; i < n; i++){
            degree2[i] = s.nextInt();
        }
        int coeff2[] = new int[n];
        for(int i = 0; i < n; i++){
            coeff2[i] = s.nextInt();
        }
        Polynomial second = new Polynomial();
        for(int i = 0; i < n; i++){
            second.setCoefficient(degree2[i],coeff2[i]);
        }second.print();
        int choice = s.nextInt();
        Polynomial result;
        switch(choice){
            // Add
            case 1:
                result = first.add(second);
                result.print();
                break;
            // Subtract
            case 2 :
                result = first.subtract(second);
                result.print();
                break;
            // Multiply
            case 3 :
                result = first.multiply(second);
                result.print();
                break;
        }
    }
}