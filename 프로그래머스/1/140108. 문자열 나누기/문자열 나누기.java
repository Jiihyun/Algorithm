class Solution {
    public int solution(String s) {
        int answer = 0;
        int firstCount = 0;
        int otherCount = 0;
        char first = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == first) {
                firstCount++;
            } else {
                otherCount++;
            }

            if (firstCount == otherCount) {
                answer++;
                firstCount = 0;
                otherCount = 0;

                if (i + 1 < s.length()) {
                    first = s.charAt(i + 1);
                }
            } else if (i == s.length() - 1) {
                answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution("banana");
        System.out.println("solution1 = " + solution1);
    }
}
