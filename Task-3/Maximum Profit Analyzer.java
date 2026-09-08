// Program
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();

            currentSum = Math.max(value, currentSum + value);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);

        sc.close();
    }
}
Input : 
8 
-2 -3 4 -1 -2 1 5 -3 
  Output : 7 
