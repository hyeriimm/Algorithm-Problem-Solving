import java.util.*;

class Solution {
    public int solution(int[][] jobs) {

        /* Sort by request time */
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        /* PQ : sort by time required */
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int time = 0;
        int index = 0;
        int totalTime = 0;
        int count = 0;

        /* Operate job */
        while (count < jobs.length) {

            while (index < jobs.length && jobs[index][0] <= time) {
                pq.offer(jobs[index]);
                index++;
            }

            if (!pq.isEmpty()) {

                int[] job = pq.poll();

                // time spent (operating)
                time += job[1];
                // time spent (from request)
                totalTime += time - job[0];
                
                count++;
            } 
            else {
                // time jump
                time = jobs[index][0];
            }
        }

        return totalTime / jobs.length; // avg
    }
}
