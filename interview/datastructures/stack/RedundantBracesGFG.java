package interview.datastructures.stack;

import java.util.Stack;

public class RedundantBracesGFG {
    static int checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        for (char ch : str) {
            if (ch == ')') {
                char top = st.peek();
                st.pop();
                int flag = 1;

                while (top != '(') {
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') {
                        flag = 0;
                    }
                    top = st.peek();
                    st.pop();
                }
                if (flag == 1) {
                    return 1;
                }
            } else {
                st.push(ch);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = "((a+b))";
        /*checkRedundancy(str);*/

        str = "(a+(b+c)/c)";
        System.out.println(checkRedundancy(str));

        /*str = "(a+b*(c-d))";
        checkRedundancy(str);*/
    }
}
