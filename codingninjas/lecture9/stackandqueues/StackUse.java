package codingninjas.lecture9.stackandqueues;

public class StackUse {
    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(3);
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }

        System.out.println(stack);

        while (!stack.isEmpty()) {
            try {
                stack.pop();
            } catch (Exception e){
                e.getMessage();
            }
        }
    }
}
