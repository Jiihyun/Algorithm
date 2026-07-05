import java.util.*;

class Solution {

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTimes = new HashMap<>();
        Map<String, Integer> totalTimes = new HashMap<>();

        for (String record : records) {
            String[] infos = record.split(" ");

            int time = convertMinute(infos[0]);
            String car = infos[1];
            String status = infos[2];

            if (status.equals("IN")) {
                inTimes.put(car, time);
            } else {
                int parkingTime = time - inTimes.remove(car);

                totalTimes.put(
                        car,
                        totalTimes.getOrDefault(car, 0) + parkingTime
                );
            }
        }

        int endTime = convertMinute("23:59");
        for (String car : inTimes.keySet()) {
            int parkingTime = endTime - inTimes.get(car);

            totalTimes.put(
                    car,
                    totalTimes.getOrDefault(car, 0) + parkingTime
            );
        }

        List<String> cars = new ArrayList<>(totalTimes.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];

        for (int i = 0; i < cars.size(); i++) {
            int totalTime = totalTimes.get(cars.get(i));
            answer[i] = calculateFee(totalTime, fees);
        }

        return answer;
    }

    private int convertMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    private int calculateFee(int totalTime, int[] fees) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (totalTime <= basicTime) {
            return basicFee;
        }

        return basicFee +
                (int) Math.ceil((double) (totalTime - basicTime) / unitTime) * unitFee;
    }
}