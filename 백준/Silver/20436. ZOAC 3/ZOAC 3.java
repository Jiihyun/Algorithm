import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Character, Direction> left = new HashMap<>();
    static HashMap<Character, Direction> right = new HashMap<>();

    public static void main(String[] args) throws IOException {
        initKeyBoard();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Direction leftNow = left.get(st.nextToken().charAt(0));
        Direction rightNow = right.get(st.nextToken().charAt(0));
        String word = br.readLine();
        int time = word.length();

        for (char ch : word.toCharArray()) {
            if (left.containsKey(ch)) {
                Direction leftNext = left.get(ch);
                time += Math.abs(leftNow.y - leftNext.y) + Math.abs(leftNow.x - leftNext.x);
                leftNow = leftNext;
            } else {
                Direction rightNext = right.get(ch);
                time += Math.abs(rightNow.y - rightNext.y) + Math.abs(rightNow.x - rightNext.x);
                rightNow = rightNext;
            }
        }
        System.out.println(time);
    }

    private static void initKeyBoard() {
        left.put('q', new Direction(1, 1));
        left.put('w', new Direction(1, 2));
        left.put('e', new Direction(1, 3));
        left.put('r', new Direction(1, 4));
        left.put('t', new Direction(1, 5));
        left.put('a', new Direction(2, 1));
        left.put('s', new Direction(2, 2));
        left.put('d', new Direction(2, 3));
        left.put('f', new Direction(2, 4));
        left.put('g', new Direction(2, 5));
        left.put('z', new Direction(3, 1));
        left.put('x', new Direction(3, 2));
        left.put('c', new Direction(3, 3));
        left.put('v', new Direction(3, 4));

        right.put('y', new Direction(1, 6));
        right.put('u', new Direction(1, 7));
        right.put('i', new Direction(1, 8));
        right.put('o', new Direction(1, 9));
        right.put('p', new Direction(1, 10));
        right.put('h', new Direction(2, 6));
        right.put('j', new Direction(2, 7));
        right.put('k', new Direction(2, 8));
        right.put('l', new Direction(2, 9));
        right.put('b', new Direction(3, 5));
        right.put('n', new Direction(3, 6));
        right.put('m', new Direction(3, 7));
    }

    static class Direction {
        int y;
        int x;

        public Direction(final int y, final int x) {
            this.y = y;
            this.x = x;
        }
    }
}
