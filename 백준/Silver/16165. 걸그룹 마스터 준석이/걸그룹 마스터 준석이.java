import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, List<String>> members;
    static Map<String, String> team;

    public static void main(String[] args) throws Exception {
        members = new HashMap<>();
        team = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String teamName = br.readLine();
            int count = Integer.parseInt(br.readLine());
            members.put(teamName, new ArrayList<>());
            for (int j = 0; j < count; j++) {
                String name = br.readLine();
                members.get(teamName).add(name);
                team.put(name, teamName);
            }
        }

        for (List<String> members : members.values()) {
            Collections.sort(members);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            int category = Integer.parseInt(br.readLine());

            if (category == 0) {
                for (String member : members.get(name)) {
                    sb.append(member).append("\n");
                }
            } else {
                sb.append(team.get(name)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
