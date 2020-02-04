package Hackerrank.stringmanipulations;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonChild {
    /*private static int commonChild(String s1, String s2){
        List<String> c1 = Stream.of(s1.split("")).collect(Collectors.toList());
        List<String> c2 = Stream.of(s2.split("")).collect(Collectors.toList());

        List<StringBuilder> slb = new ArrayList<>();
        List<Integer> lsb = new ArrayList<>();

        for (int i = 0; i < c1.size(); i++) {
            int  index = 0;
            StringBuilder sb = new StringBuilder("");
            for (int j = i; j < c2.size(); j++) {
                if (c1.contains(c2.get(j)) && index == 0){
                    index = c1.indexOf(c2.get(j));
                    sb.append(c1.get(c1.indexOf(c2.get(j))));
                } else {
                    if (c1.contains(c2.get(j))){
                        if (index < c1.indexOf(c2.get(j))) {
                            index = c1.indexOf(c2.get(j));
                            sb.append(c1.get(c1.indexOf(c2.get(j))));
                        } else if (index < c1.lastIndexOf(c2.get(j))){
                            index = c1.lastIndexOf(c2.get(j));
                            sb.append(c1.get(c1.indexOf(c2.get(j))));
                        }
                    }
                }
            }
            slb.add(sb);
            lsb.add(sb.length());
        }
        System.out.println(slb);
        Collections.sort(lsb, Collections.reverseOrder());
        System.out.println(lsb.get(0));
        return 0;
    }*/

    public static int lcsDynamic(String s1,String s2){

        /**
         * abcdaf
         * acbcf
         */
        char str1[] = s1.toCharArray();
        char str2[] = s2.toCharArray();
        int temp[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for(int i=1; i < temp.length; i++){
            for(int j=1; j < temp.length; j++){
                if(str1[i-1] == str2[j-1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                }
                else
                {
                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
                }
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }
        return max;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(lcsDynamic(a, b));
    }
}
