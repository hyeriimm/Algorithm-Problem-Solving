import java.util.*;

class Solution {
    public int solution(String arr[]) {
        
        int n = arr.length / 2 + 1;
        int[][] dpMax = new int[n][n];
        int[][] dpMin = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(arr[i * 2]);
            dpMax[i][i] = num;
            dpMin[i][i] = num;
        }
        
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;
                
                for (int k = i; k < j; k++) {
                    int leftMax = dpMax[i][k];
                    int leftMin = dpMin[i][k];
                    int rightMax = dpMax[k + 1][j];
                    int rightMin = dpMin[k + 1][j];
                    String op = arr[k * 2 + 1];
                    
                    if (op.equals("+")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], leftMax + rightMax);
                        dpMin[i][j] = Math.min(dpMin[i][j], leftMin + rightMin);
                    }
                    else if (op.equals("-")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], leftMax - rightMin);
                        dpMin[i][j] = Math.min(dpMin[i][j], leftMin - rightMax);
                    }
                }
            }
        }
        
        return dpMax[0][n - 1];
    }
}