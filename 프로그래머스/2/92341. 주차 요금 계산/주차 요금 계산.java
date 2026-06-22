import java.util.*;

class Solution {

    public int[] solution(int[] fees, String[] records) {

        Map<String, String> in = new TreeMap<>();
        Map<String, Integer> totalTimes = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");

            if (record[2].equals("IN")) {
                in.put(record[1], record[0]);
            } else {
                String inTime = in.get(record[1]);

                // 변경: calculate -> calculateTime
                int parkingTime = calculateTime(inTime, record[0]);

                totalTimes.put(
                        record[1],
                        totalTimes.getOrDefault(record[1], 0) + parkingTime
                );

                in.remove(record[1]);
            }
        }

        // 출차 기록이 없는 차량 처리
        for (String carNumber : in.keySet()) {
            String inTime = in.get(carNumber);

            // 변경: calculate -> calculateTime
            int parkingTime = calculateTime(inTime, "23:59");

            totalTimes.put(
                    carNumber,
                    totalTimes.getOrDefault(carNumber, 0) + parkingTime
            );
        }

        int[] answer = new int[totalTimes.size()];

        int index = 0;

        // 변경: valueSet() -> values()
        for (int time : totalTimes.values()) {

            // 변경: 기본 시간 이하 처리 추가
            if (time <= fees[0]) {
                answer[index] = fees[1];
            } else {

                // 변경:
                // Math.ceil 대신 정수 연산 사용
                // ceil(a / b) == (a + b - 1) / b

                int extraTime = time - fees[0];
                int unitCount = (extraTime + fees[2] - 1) / fees[2];

                answer[index] = fees[1] + unitCount * fees[3];
            }

            index++;
        }

        return answer;
    }

    public int calculateTime(String start, String end) {

        String[] startTime = start.split(":");
        String[] endTime = end.split(":");

        int startMinute =
                Integer.parseInt(startTime[0]) * 60
                        + Integer.parseInt(startTime[1]);

        int endMinute =
                Integer.parseInt(endTime[0]) * 60
                        + Integer.parseInt(endTime[1]);

        return endMinute - startMinute;
    }
}