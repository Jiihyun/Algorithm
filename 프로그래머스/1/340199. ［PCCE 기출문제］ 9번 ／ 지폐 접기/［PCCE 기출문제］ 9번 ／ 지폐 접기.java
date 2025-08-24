import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        for (int i = 0; i < wallet.length; i++) {
            int billMin = Math.min(bill[0], bill[1]);
            int walletMin = Math.min(wallet[0], wallet[1]);
            int billMax = Math.max(bill[0], bill[1]);
            int walletMax = Math.max(wallet[0], wallet[1]);
            while (billMin > walletMin || billMax > walletMax) {
                if (bill[0] > bill[1]) {
                    bill[0] /= 2;
                    billMin = Math.min(bill[0], bill[1]);
                    billMax = Math.max(bill[0], bill[1]);
                } else {
                    bill[1] /= 2;
                    billMin = Math.min(bill[0], bill[1]);
                    billMax = Math.max(bill[0], bill[1]);
                }
                answer++;
            }
        }
        return answer;
    }
}