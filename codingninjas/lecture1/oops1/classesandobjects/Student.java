package codingninjas.lecture1.oops1.classesandobjects;

public class Student {

    private static int numStudents = 0;

    String name;

    // final data members can be initialized as soon as they are declared.
    private final int rollnum;

    /*public Student(String name) {
        this.name = name;
    }*/

    public Student(String name, int rollnum) {
        this.name = name;
        this.rollnum = rollnum;
        numStudents++;
    }

    public static int getNumStudents() {
        return numStudents;
    }

    public int getRollnum() {
        return rollnum;
    }

    /*public void setRollnum(int rollnum) {
        if (rollnum <= 0) {
            throw new NumberFormatException("number less than or equal to 0");
        }
        this.rollnum = rollnum;
    }*/

    public void print() {
        System.out.println(name + " : " + rollnum);
    }
}