import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalSize = Integer.parseInt(br.readLine());
        Map<String, Integer> bookCounts = new HashMap<>();

        for (int i = 0; i < totalSize; i++) {
            String book = br.readLine();
            bookCounts.put(book, bookCounts.getOrDefault(book, 0) + 1);
        }

        Optional<String> bestSeller = findBestSeller(bookCounts);
        System.out.println(bestSeller.get());
    }

    private static Optional<String> findBestSeller(Map<String, Integer> bookCounts) {
        int maxCount = Collections.max(bookCounts.values());

        return bookCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .sorted()
                .findFirst();
    }
}
