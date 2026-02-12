import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        TreeMap<String, Integer> map = new TreeMap<>();
        int total = 0;
        
        while ((line = br.readLine()) != null) {
            if (line.length() == 0) {
                continue;
            }
            map.put(line, map.getOrDefault(line, 0) + 1);
            total++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double percentage = (entry.getValue() / (double) total) * 100.0;
            sb.append(entry.getKey())
              .append(" ")
              .append(String.format("%.4f", percentage))
              .append("\n");
        }
        System.out.print(sb.toString());
    }
}
