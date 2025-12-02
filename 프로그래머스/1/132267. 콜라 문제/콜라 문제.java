class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int countOfEmptyCola = n;
        
        while (countOfEmptyCola >= a) {
            int exchangeCount = countOfEmptyCola / a;
            int coutOfFreeCola = exchangeCount * b;
            countOfEmptyCola = (countOfEmptyCola - (exchangeCount * a) + coutOfFreeCola);            
            answer += coutOfFreeCola;
        }
        return answer;
    }
}