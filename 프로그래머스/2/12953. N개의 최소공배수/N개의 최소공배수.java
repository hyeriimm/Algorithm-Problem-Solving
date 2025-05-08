import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = lcm(arr[0], arr[1]);
        
        for (int i = 2; i < arr.length; i++) {
            System.out.println(answer);
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    
    int gcd(int a, int b) {
        int gcd = 1;
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
    
    int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return a * b / gcd;
    }
}