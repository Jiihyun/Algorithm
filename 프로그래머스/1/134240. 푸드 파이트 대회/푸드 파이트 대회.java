class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 != 0) {
                food[i] = food [i] - 1;
            }
            if (food[i] > 0) {
                for (int j = 0; j < food[i] / 2; j++) {
                    sb.append(i);
                }
            }
        }
        String first = sb.toString();
        String last = sb.reverse().toString();
        return first + "0" + last;
    }
}