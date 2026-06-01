import java.util.*;

class Solution {

    private int[][] users;
    private int[] emoticons;

    private int maxSubscriber;
    private int maxSales;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;

        int[] discounts = new int[emoticons.length];

        dfs(0, discounts);

        return new int[]{maxSubscriber, maxSales};
    }

    private void dfs(int depth, int[] discounts) {
        int[] rates = {10, 20, 30, 40};

        if (depth == discounts.length) {
            evaluate(discounts);
            return;
        }

        for (int rate : rates) {
            discounts[depth] = rate;
            dfs(depth + 1, discounts);
        }
    }

    private void evaluate(int[] discounts) {
        int subscriberCount = 0;
        int sales = 0;

        for (int[] user : users) {
            int requiredDiscount = user[0];
            int subscribePrice = user[1];

            int purchaseAmount = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= requiredDiscount) {
                    purchaseAmount += emoticons[i] * (100 - discounts[i]) / 100;
                }
            }

            if (purchaseAmount >= subscribePrice) {
                subscriberCount++;
            } else {
                sales += purchaseAmount;
            }
        }

        if (subscriberCount > maxSubscriber) {
            maxSubscriber = subscriberCount;
            maxSales = sales;
        } else if (subscriberCount == maxSubscriber && sales > maxSales) {
            maxSales = sales;
        }
    }
}