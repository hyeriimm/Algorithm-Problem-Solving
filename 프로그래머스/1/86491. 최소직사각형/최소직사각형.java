class Solution {
    public int solution(int[][] sizes) {
        int maxShort = 0;
        int maxLong = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if (w < h) {
                if (maxShort < w) maxShort = w;
                if (maxLong < h) maxLong = h;
            }
            else {
                if (maxShort < h) maxShort = h;
                if (maxLong < w) maxLong = w;
            }
        }
        
        return maxShort * maxLong;
    }
}