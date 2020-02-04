package codingninjas.lecture1.oops1.classesandobjects;

import java.util.Scanner;

public class StudentUse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = new Student("yash", 123);
        Student student1 = new Student("hari", 124);
        Student student2 = new Student("ram", 125);
        Student student3 = new Student("shyam", 126);

        System.out.println(Student.getNumStudents());
    }
}