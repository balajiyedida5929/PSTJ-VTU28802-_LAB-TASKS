// Program
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> salaries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            salaries.add(sc.nextInt());
        }

        List<Integer> updatedSalaries = salaries.stream()
                .map(salary -> salary + salary / 10)
                .collect(Collectors.toList());

        for (int salary : updatedSalaries) {
            System.out.print(salary + " ");
        }

        sc.close();
    }
}
For input:
5
1000 2000 3000 4000 5000

Output:
1100 2200 3300 4400 5500
