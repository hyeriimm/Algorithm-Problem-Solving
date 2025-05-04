import java.util.*;

class Solution {
    
    public int solution(int[] A, int[] B) {

        int answer = 0;
        int N = A.length;
        int i = 0;
        int j = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        while (i < N && j < N) {
            if (A[i] < B[j]) {
                answer++;
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        
        return answer;
    }
}