package codingninjas.assignment_recursion1;

public class TowerOfHanoi {
    public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
        // Write your code here
        if (disks == 1)
        {
            System.out.println(source + " " + destination);
            return;
        } else {
            if (disks > 1) {
                towerOfHanoi(disks - 1, source, destination, auxiliary);
                System.out.println(source + " " + destination);
                towerOfHanoi(disks - 1, auxiliary, source, destination);
            }
        }
    }

    public static void main(String[] args) {
        int n = 0; // Number of disks
        towerOfHanoi(n, 'a', 'b', 'c');  // A, B and C are names of rods
    }
}
