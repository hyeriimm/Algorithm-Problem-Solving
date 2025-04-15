import java.util.*;
import java.io.*;

class Solution {
    
    String[][] tickets;
    boolean[] visited;
    List<String> list;
    
    public String[] solution(String[][] tickets) {

        /* 0. Initialize */
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        list = new ArrayList<>();
        
        /* 1. DFS - start at ICN */
        dfs("ICN", "ICN", 0);

        /* 2. Sort by ascending order */
        Collections.sort(list);
        
        /* 3. Return result as array */
        return list.get(0).split(" ");
    }
    
    /* 2. DFS */
    void dfs(String port, String path, int count) {
        
        if (count == tickets.length) {
            list.add(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(port)) {
                
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}