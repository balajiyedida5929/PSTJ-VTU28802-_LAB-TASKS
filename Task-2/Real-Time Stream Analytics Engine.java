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
            
                .filter(r -> r.temperature > 50)


                .collect(Collectors.groupingBy(
                        r -> r.sensorId,
                        Collectors.averagingDouble(r -> r.temperature)
                ))

           
                .entrySet().stream()

        
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))

           
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
Input : 6 
    S1 60 
    S2 40
    S1 80 
    S3 70 
    S2 90
    S3 30 
Output :  S1 70.0 
          S2 90.0 
          S3 70.0 
