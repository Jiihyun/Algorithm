import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        List<Stack<Integer>> columns = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            Stack<Integer> column = new Stack<>();
            for (int j = board.length - 1; j >= 0; j--) {
                int item = board[j][i];

                if (item != 0) {
                    column.push(item);
                }
            }
            columns.add(column);
        }

        for (int index = 0; index < moves.length; index++) {
            Stack<Integer> line = columns.get(moves[index] - 1);
            if (!line.isEmpty()) {
                basket.push(line.pop());
            }
            if (basket.size() > 1) {
                int doll1 = basket.peek();
                int doll2 = basket.get(basket.size() - 2);
                if (doll1 == doll2) {
                    basket.pop();
                    basket.pop();
                    answer+=2;
                }
            }
        }
        return answer;
    }
}