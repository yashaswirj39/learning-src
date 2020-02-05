package codingninjas.lecture1.oops1.classesandobjects;

public class DynamicArrayUse {
    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();

        for (int i = 0; i < 100; i++) {
            da.add(i+10);
        }
        System.out.println(da.size());
        System.out.println(da.get(3));
        System.out.println(da.get(4));
        if (!da.isEmpty()){
            System.out.println(da.removeLast());
            System.out.println(da.size());
        }
    }
}