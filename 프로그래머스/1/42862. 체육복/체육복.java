class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        /* Initialize */
        int answer = 0;
        int[] cloth = new int[n];
        
        /* Count clothes */
        for (int i = 0; i < lost.length; i++) {
            cloth[lost[i] - 1]--;
        }
        for (int i = 0; i < reserve.length; i++) {
            cloth[reserve[i] - 1]++;
        }
        
        /* Lend to others */
        for (int i = 0; i < n; i++) {
            if (cloth[i] == 1) {
                if (i != 0 && cloth[i - 1] == -1) {
                    cloth[i - 1] = 0;
                    cloth[i] = 0;
                }
                else if (i != n - 1 && cloth[i + 1] == -1) {
                    cloth[i + 1] = 0;
                    cloth[i] = 0;
                }
            } 
        }
        
        /* Count result */
        for (int i = 0; i < n; i++) {
            if (cloth[i] != -1) answer++;
        }
        
        return answer;
    }
}