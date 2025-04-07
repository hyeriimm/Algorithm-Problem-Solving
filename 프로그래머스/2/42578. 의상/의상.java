import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
	    
        for (int i = 0; i < clothes.length; i++) {
	       	if (map.containsKey(clothes[i][1])) {
	       		map.replace(clothes[i][1], map.get(clothes[i][1]) + 1);
        	}
        	else {
        		map.put(clothes[i][1], 1);
        	}
	    }
        
        for (int v : map.values()) {
            answer *= (v + 1);
        }
        
        return answer - 1;
    }
}