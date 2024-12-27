import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < A.length; i++) {
            int su = A[i];
            if (su >= num) {
                while (num <= su) {
                    stack.push(num);
                    bf.append("+\n");
                    num++;
                }
                stack.pop();
                bf.append("-\n");
            } else {
                Integer n = stack.pop();
                if (n != su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) {
            System.out.println(bf);
        }
    }
}

