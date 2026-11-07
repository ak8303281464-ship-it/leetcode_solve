import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> 
            a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]
        );
        
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> 
            a[0] != b[0] ? a[0] - b[0] : (a[1] != b[1] ? a[1] - b[1] : a[2] - b[2])
        );

        for (int i = 0; i < servers.length; i++) {
            free.offer(new int[]{0, servers[i], i});
        }

        int[] ans = new int[tasks.length];

        for (int j = 0; j < tasks.length; j++) {
            while (!busy.isEmpty() && busy.peek()[0] <= j) {
                free.offer(busy.poll());
            }

            int[] cur = free.isEmpty() ? busy.poll() : free.poll();
            ans[j] = cur[2];
            cur[0] = Math.max(j, cur[0]) + tasks[j];
            busy.offer(cur);
        }

        return ans;
    }
}
