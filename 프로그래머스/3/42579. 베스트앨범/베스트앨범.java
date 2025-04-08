import java.util.*;

class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        
        /* 0. Initialize */
		Map<String, Integer> total = new HashMap<>();
        Map<String, int[]> map = new HashMap<>();
        
        /* 1. Save Top2 songs of each genre */
        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
            	int[] list = map.get(genres[i]);
            	if (list[1] == -1 || plays[i] > plays[list[1]]) {
            		if (plays[i] > plays[list[0]]) {
                		list[1] = list[0];
                		list[0] = i;
                	}
            		else {
            			list[1] = i;
            		}
            	}
            	map.replace(genres[i], list);
                total.replace(genres[i], total.get(genres[i]) + plays[i]);
            }
            else {
            	int[] list = { i, -1 };
            	map.put(genres[i], list);
            	total.put(genres[i], plays[i]);
            }
        }
        
        /* 2. Sort genre by total in ascending order */
        List<String> keySet = new ArrayList<>(total.keySet());
        keySet.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return total.get(o2) - total.get(o1);
			}
        });
        
        /* 3. Get result */
        ArrayList<Integer> list = new ArrayList<>();
        for (String key : keySet) {
        	for (Integer idx : map.get(key)) {
        		if (idx != -1) list.add(idx);
        	}
        }
        int i = 0;
        int[] answer = new int[list.size()];
        for (Integer idx : list) {
        	answer[i++] = idx;
        }
        
        return answer;
    }
}