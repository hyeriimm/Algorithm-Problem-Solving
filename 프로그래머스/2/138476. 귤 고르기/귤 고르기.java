import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] count = new int[10000000];
        
        for (int t : tangerine) {
            count[t - 1]++;
        }
        
        Arrays.sort(count);
        
        for (int i = 9999999; i >= 0; i--) {
            k -= count[i];
            answer++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}