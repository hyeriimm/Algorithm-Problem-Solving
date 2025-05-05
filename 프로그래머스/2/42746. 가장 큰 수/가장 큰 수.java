import java.util.*;
import java.io.*;;

class Solution {
    public String solution(int[] numbers) {

        String[] nums = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));
        
        if (nums[0].equals("0")) return "0";
        
        for (String s : nums) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}