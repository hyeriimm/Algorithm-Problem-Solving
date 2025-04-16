class Solution {
    public String solution(String s) {
        String answer = "";
        boolean first = true;
        
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            if (c == ' ') {
                answer += c;
                first = true;
            }
            else if (first) {
                if ('a' <= c && c <= 'z') {
                    answer += (char)(c - 'a' + 'A');
                }
                else {
                    answer += c;
                }
                first = false;
            }
            else if ('A' <= c && c <= 'Z') {
                answer += (char)(c -'A' + 'a');
            }
            else {
                answer += c;
            }
        }
        
        return answer;
    }
}