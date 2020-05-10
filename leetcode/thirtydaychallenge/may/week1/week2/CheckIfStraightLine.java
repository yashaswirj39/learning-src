package leetcode.thirtydaychallenge.may.week1.week2;


/**
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 * https://www.youtube.com/watch?v=8cs0KTHq2Pc
 */
public class CheckIfStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 0) {
            return false;
        }

        double x1 = coordinates[0][0];
        double y1 = coordinates[0][1];

        Double slope = null;

        for (int i = 1; i < coordinates.length; i++) {
            double x2 = coordinates[i][0];
            double y2 = coordinates[i][1];

            if (x2 - x1 == 0) {
                return false;
            }

            if (slope == null) {
                slope = (y2 - y1) / (x2 - x1);
                continue;
            }

            double slope2 = (y2 - y1) / (x2 - x1);

            if (slope != slope2) {
                return false;
            }
        }
        return true;
    }
}

