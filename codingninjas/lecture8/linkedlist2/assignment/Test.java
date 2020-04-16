package codingninjas.lecture8.linkedlist2.assignment;

public class Test {
    public static void main(String[] args) {
        String str= "291215174532";

        if (str.contains("D") && str.endsWith("/1")) {
            str = str.substring(str.indexOf("D"), str.indexOf("/1"));
            System.out.println(str);
        } else if (str.contains("S") && str.endsWith("/1")) {
            str = str.substring(str.indexOf("S"), str.indexOf("/1"));
            System.out.println(str);
        }

        System.out.println(str);
    }
}
