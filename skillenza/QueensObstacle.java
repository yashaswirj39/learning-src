package skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Author: prabhakar
 * Reviewed By:
 * Project: hibernate-test
 * Created On : 4/11/19
 */
public class QueensObstacle {


    static int numberofPosition(int n, int k, int x,
                                int y) {

        int a11, a12, a21, a22, r1, r2, c1, c2;

        a11 = Math.min(x - 1, y - 1);
        a12 = Math.min(n - x, n - y);
        a21 = Math.min(n - x, y - 1);
        a22 = Math.min(x - 1, n - y);

        r1 = y - 1;
        r2 = n - y;
        c1 = x - 1;
        c2 = n - x;

        return a11 + a12 + a21 + a22 + r1 + r2 + c1 + c2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String tc[] = br.readLine().split(" ");
            int sizeOfMatrix = Integer.parseInt(tc[0]);
            String qp = tc[1].replace("(", "").replace(")", "");
            String qps[] = qp.split(",");
            int Qposx = Integer.parseInt(qps[0]);
            int Qposy = Integer.parseInt(qps[1]);

            System.out.println((sizeOfMatrix * sizeOfMatrix) - (numberofPosition(sizeOfMatrix, 0, Qposx, Qposy)));

        }
    }
}