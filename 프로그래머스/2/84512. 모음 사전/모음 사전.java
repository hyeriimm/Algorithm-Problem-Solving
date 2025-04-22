import java.util.*;
import java.io.*;

class Solution {
    
    char[] vowel = { 'A', 'E', 'I', 'O', 'U' };
    List<String> list;
    
    void permutation(int cnt, String str) {
        
        if (cnt == 5) {
            list.add(str);
            return;
        }
        else if (cnt != 0) {
            list.add(str);
        }
        
        for (int i = 0; i < 5; i++) {
            permutation(cnt + 1, str + vowel[i]);
        }
    }
    
    public int solution(String word) {

        list = new ArrayList<>();
        
        permutation(0, "");
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) return i + 1;
        }
        
        return 0;
    }
}