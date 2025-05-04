class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int i = 0;
        
        if (s / n == 0) return new int[] { -1 };
        
        for ( ; i < n - s % n; i++) {
            answer[i] = s / n;
        }
        for ( ; i < n; i++) {
            answer[i] = s / n + 1;
        }
        
        return answer;
    }
}