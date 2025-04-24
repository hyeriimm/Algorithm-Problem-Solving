class Solution {
    public int solution(String name) {
        int len = name.length();
        int move = len - 1;
        int answer = 0;
        
        for (int i = 0; i < name.length(); i++) {
            
            char c = name.charAt(i);
            
            if (c < 'N') answer += (c - 'A');
            else answer += ('Z' - c + 1);
            
            int index = i + 1;
            while (index < len && name.charAt(index) == 'A') {
                index++; // skip A
            }
            
            move = Math.min(move, i * 2 + len - index);
            move = Math.min(move, (len - index) * 2 + i);
        }
        
        return answer + move;
    }
}