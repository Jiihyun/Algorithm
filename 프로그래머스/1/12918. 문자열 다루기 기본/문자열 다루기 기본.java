class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() == 4 || s.length() == 6) {
            try {
                Integer.parseInt(s);
                return answer;
            } catch (RuntimeException e) {
                return false;
            }
        }
        return false;
    }
}