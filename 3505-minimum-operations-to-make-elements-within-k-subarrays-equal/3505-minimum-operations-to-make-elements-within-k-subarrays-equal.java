import java.util.*;

class Solution {

    class Fenwick {

        int n;
        long[] count;
        long[] sum;

        Fenwick(int n) {
            this.n = n;
            count = new long[n + 1];
            sum = new long[n + 1];
        }

        void update(int i, int val, int delta) {

            while (i <= n) {
                count[i] += delta;
                sum[i] += (long) val * delta;
                i += i & -i;
            }
        }

        long queryCount(int i) {

            long res = 0;

            while (i > 0) {
                res += count[i];
                i -= i & -i;
            }

            return res;
        }

        long querySum(int i) {

            long res = 0;

            while (i > 0) {
                res += sum[i];
                i -= i & -i;
            }

            return res;
        }

        int kth(int k) {

            int idx = 0;

            for (int bit = Integer.highestOneBit(n);
                 bit > 0; bit >>= 1) {

                int next = idx + bit;

                if (next <= n && count[next] < k) {
                    idx = next;
                    k -= (int) count[next];
                }
            }

            return idx + 1;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int m = 0;

        for (int v : sorted) {

            if (m == 0 || sorted[m - 1] != v) {
                sorted[m++] = v;
            }
        }

        Fenwick bit = new Fenwick(m);

        // Calculate cost of every window of size x
        long[] cost = new long[n - x + 1];

        for (int i = 0; i < x; i++) {

            int id = Arrays.binarySearch(
                sorted, 0, m, nums[i]
            ) + 1;

            bit.update(id, nums[i], 1);
        }

        for (int i = 0; i <= n - x; i++) {

            // Find median
            int medianId = bit.kth((x + 1) / 2);

            long median = sorted[medianId - 1];

            long leftCount = bit.queryCount(medianId);
            long leftSum = bit.querySum(medianId);

            long totalSum = bit.querySum(m);

            long rightCount = x - leftCount;
            long rightSum = totalSum - leftSum;

            // Minimum operations to make window equal
            cost[i] = median * leftCount - leftSum
                    + rightSum - median * rightCount;

            // Slide window
            if (i < n - x) {

                int removeId = Arrays.binarySearch(
                    sorted, 0, m, nums[i]
                ) + 1;

                int addId = Arrays.binarySearch(
                    sorted, 0, m, nums[i + x]
                ) + 1;

                bit.update(removeId, nums[i], -1);
                bit.update(addId, nums[i + x], 1);
            }
        }

        // Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int j = 0; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        // Zero subarrays require zero operations
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int j = 1; j <= k; j++) {

            for (int i = 1; i <= n; i++) {

                // Option 1: Skip current element
                dp[j][i] = dp[j][i - 1];

                // Option 2: Select a window ending at i - 1
                if (i >= x && dp[j - 1][i - x] != INF) {

                    long candidate =
                        dp[j - 1][i - x] + cost[i - x];

                    dp[j][i] = Math.min(
                        dp[j][i],
                        candidate
                    );
                }
            }
        }

        return dp[k][n];
    }
}