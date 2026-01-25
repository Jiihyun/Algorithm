import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] input = new int[N];
            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            // 1️⃣ 팀별 인원 수 세기
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int team : input) {
                countMap.put(team, countMap.getOrDefault(team, 0) + 1);
            }

            // 2️⃣ 등수 매기기 (6명 이상 팀만)
            Map<Integer, List<Integer>> rankMap = new HashMap<>();
            int rank = 1;

            for (int team : input) {
                if (countMap.get(team) >= 6) {
                    rankMap
                        .computeIfAbsent(team, k -> new ArrayList<>())
                        .add(rank);
                    rank++;
                }
            }

            // 3️⃣ 점수 계산
            int winner = -1;
            int minScore = Integer.MAX_VALUE;
            int minFifth = Integer.MAX_VALUE;

            for (int team : rankMap.keySet()) {
                List<Integer> ranks = rankMap.get(team);

                int score = 0;
                for (int i = 0; i < 4; i++) {
                    score += ranks.get(i);
                }

                int fifth = ranks.get(4);

                if (score < minScore ||
                    (score == minScore && fifth < minFifth)) {
                    minScore = score;
                    minFifth = fifth;
                    winner = team;
                }
            }

            sb.append(winner).append("\n");
        }

        System.out.print(sb);
    }
}
