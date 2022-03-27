import java.util.Arrays;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] sum = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            sum[i] = gas[i] - cost[i];
        }

        if (Arrays.stream(sum).sum() < 0) {
            return -1;
        }

        for (int i = 0; i < sum.length; i++) {        
            if (sum[i] < 0 || gas[i] <= 0) {
                continue;
            }
            int tank = sum[i];
            int currentStation = i;
            int nextStation = currentStation == sum.length - 1 ? 0 : currentStation + 1;
            while (nextStation != i) {
                tank += sum[nextStation];
                if (tank < 0) {
                    break;
                }
                currentStation = nextStation;
                if (currentStation == i) {
                    break;
                }
                nextStation = nextStation == gas.length - 1 ? 0 : nextStation + 1;
            }
            if (tank >= 0 && nextStation == i) {
                return i;
            }
        }
        return -1;
    }
}