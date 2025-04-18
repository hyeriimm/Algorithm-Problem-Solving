import java.util.*;
import java.io.*;

class Solution {
    
    char[] arr;
    boolean[] selected;
    Set<Integer> set;
    
    public int solution(String numbers) {
        
        /* 0. Initialize */
        arr = numbers.toCharArray();
        selected = new boolean[arr.length];
        set = new HashSet<>();
        
        permutation(0, 0);

        /* 3. Return the count of prime numbers */
        return set.size();
    }
    
    /* 1. Permutation : Make all possible numbers */
    void permutation(int cnt, int num) {
        if (cnt == arr.length) {
            if (num < 2) return;
            if (isPrime(num))
                set.add(num);
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            permutation(cnt + 1, num * 10 + (arr[i] - '0'));
            permutation(cnt + 1, num);
            selected[i] = false;
        }
    }
    
    /* 2. Check if the number is prime */
    boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) 
                return false;
        }
        return true;
    }
}