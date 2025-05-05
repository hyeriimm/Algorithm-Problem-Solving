import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int len = citations.length;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < len; i++) {
            
            if (citations[i] >= len - i) 
                return len - i;
        }
        
        return 0;
    }
}