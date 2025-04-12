import java.util.*;

class Solution {
    
    int[] arr;
    int target;
    int answer;
    
    public int solution(int[] numbers, int target) {

        arr = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
    void dfs(int cnt, int sum) {
        
        if (cnt == arr.length) {
            if (sum == target) answer++;
            return ;
        }
        
        dfs(cnt + 1, sum + arr[cnt]);
        dfs(cnt + 1, sum - arr[cnt]);
    }
}