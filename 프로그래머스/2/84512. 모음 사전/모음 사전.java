import java.util.*;
import java.io.*;

class Solution {
    
    char[] vowel = { 'A', 'E', 'I', 'O', 'U' };
    String word;
    int seq;
    int answer;
    
    void permutation(int cnt, String str) {
        
        if (answer > 0) return;
        
        if (str.equals(word)) {
            answer = seq + 1;
            return;
        }
        
        if (cnt == 5) {
            seq++;
            return;
        }
        else if (cnt != 0) {
            seq++;
        }
        
        for (int i = 0; i < 5; i++) {
            permutation(cnt + 1, str + vowel[i]);
        }
    }
    
    public int solution(String word) {

        this.word = word;
        
        permutation(0, "");
        
        return answer;
    }
}