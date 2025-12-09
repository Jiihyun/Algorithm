class Solution {
    public long solution(int price, int money, int count) {
        long sum = getPrice(price, count);
        if (money > sum ){
            return 0;
        }
        return sum - money;
    }
    
    public long getPrice(int price, int count) {
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += (long) price * i;
        }
        return sum;
    }
}