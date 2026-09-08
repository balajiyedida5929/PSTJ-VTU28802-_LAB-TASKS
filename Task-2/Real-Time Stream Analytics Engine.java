// Program
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Reading> readings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String sensorId = sc.next();
            double temperature = sc.nextDouble();

            readings.add(new Reading(sensorId, temperature));
        }

        readings.stream()
                // 1. Filter temperatures greater than 50
                .filter(r -> r.temperature > 50)

                // 2. Group by Sensor ID
                .collect(Collectors.groupingBy(
                        r -> r.sensorId,
                        Collectors.averagingDouble(r -> r.temperature)
                ))

                // 3. Convert to stream of Map entries
                .entrySet().stream()

                // 4. Sort by average temperature descending
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))

                // Display result
                .forEach(e -> System.out.println(
                        e.getKey() + " " + e.getValue()
                ));

        sc.close();
    }

    static class Reading {
        String sensorId;
        double temperature;

        Reading(String sensorId, double temperature) {
            this.sensorId = sensorId;
            this.temperature = temperature;
        }
    }
}
