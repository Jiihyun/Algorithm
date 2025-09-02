class Solution {
    public int solution(String[] babbling) {
        String[] cannot = {"ayaaya", "yeye", "woowoo", "mama"};
        int answer = 0;
        outer: for (int i = 0; i < babbling.length; i++) {
            for (String word : cannot) {
                if (babbling[i].contains(word)) {
                    continue outer;
                }
            }
            String replaced = babbling[i].replaceAll("aya|ye|woo|ma", "");
            if (replaced.equals("")) {
                answer++;
            }
        }
        return answer;
    }
}