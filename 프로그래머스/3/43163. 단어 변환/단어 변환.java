import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.word.equals(target)) {
                return now.depth;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canBfs(now.word, words[i])) {
                    visited[i] = true;
                    q.add(new Node(words[i], now.depth + 1));
                }
            }
        }

        return 0;
    }

    private boolean canBfs(String now, String word) {
        int difference = 0;

        for (int j = 0; j < now.length(); j++) {
            if (now.charAt(j) != word.charAt(j)) {
                difference++;
            }
        }

        return difference == 1;
    }

    class Node {
        String word;
        int depth;

        private Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}