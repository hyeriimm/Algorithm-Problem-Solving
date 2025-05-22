import java.util.*;

class Solution {
    public long solution(int n, int[] works) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.offer(work);
        }

        while (n > 0 && !pq.isEmpty()) {
            int max = pq.poll();

            if (max > 0) {
                pq.offer(max - 1);
            }

            n--;
        }

        long fatigue = 0;

        while (!pq.isEmpty()) {
            int work = pq.poll();
            fatigue += (long) work * work;
        }

        return fatigue;
    }
}
