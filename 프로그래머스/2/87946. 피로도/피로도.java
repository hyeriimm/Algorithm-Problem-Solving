class Solution {
    
    int N;
    int[][] dungeons;
    boolean[] visited;
    int answer;

    void dfs(int hp, int cnt) {
        
        if (hp == 0) {
            if (answer < cnt)
                answer = cnt;
            return;
        }
        
        if (cnt == N) {
            answer = N;
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (dungeons[i][0] > hp) continue;
            
            visited[i] = true;
            dfs(hp - dungeons[i][1], cnt + 1);
            visited[i] = false;
        }
        
        if (answer < cnt)
            answer = cnt;
    }
    
    public int solution(int k, int[][] dungeons) {
        
        N = dungeons.length;
        this.dungeons = dungeons;
        visited = new boolean[N];

        dfs(k, 0);
        
        return answer;
    }
}