import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();
        int num = sc.nextInt();
        int currentNum = 1;
        while (myQueue.size() < num) {
            myQueue.add(currentNum++);
        }
        while (myQueue.size() > 1) {
            myQueue.poll();
            Integer topNum = myQueue.poll();
            myQueue.add(topNum);
        }
        System.out.println(myQueue.element());
    }
}

