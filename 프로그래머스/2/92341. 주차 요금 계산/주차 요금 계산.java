import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTimes = new HashMap<>();
        Map<String, Integer> totalTimes = new HashMap<>();
        
        for (String record: records) {
            String[] infos = record.split(" ");
            String time = infos[0];
            String car = infos[1];
            String status = infos[2];
            
            if (status.equals("IN")) {
                inTimes.put(car, convertMinutes(time));
            } else {
                int parkingTime = convertMinutes(time) - inTimes.remove(car);
                totalTimes.put(
                    car,
                    totalTimes.getOrDefault(car, 0) + parkingTime
                );
            }
        }
        
        for(String car: inTimes.keySet()) {
            int parkingTime = convertMinutes("23:59") - inTimes.get(car);
                totalTimes.put(
                    car,
                    totalTimes.getOrDefault(car, 0) + parkingTime
                );
        }
        
        List<String> cars = new ArrayList<>(totalTimes.keySet());
        Collections.sort(cars);
        int[] answer = new int[cars.size()];
        
        for (int i = 0; i < cars.size(); i++) {
            if (totalTimes.get(cars.get(i)) <= fees[0]) {
                answer[i] = fees[1];
            } else {
                answer[i] = fees[1] + (int) Math.ceil((double) (totalTimes.get(cars.get(i)) - fees[0]) / fees[2]) * fees[3];
            }
        }
        return answer;
    }
    
    private int convertMinutes(String inTime) {
        String[] times = inTime.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}