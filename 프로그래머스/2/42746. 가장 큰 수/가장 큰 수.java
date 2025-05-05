import java.util.*;
import java.io.*;;

class Solution {
    public String solution(int[] numbers) {

        StringBuilder sb = new StringBuilder();
        
        String[] nums = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));
        
        if (nums[0].equals("0")) return "0";
        
        for (String s : nums) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}