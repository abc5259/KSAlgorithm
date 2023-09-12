package Programmers.JaeHoon.level3;
import java.util.*;

public class 상담원_인원 {

    class Solution {
        int[] arr;
        int N;
        int K;
        ArrayList<ArrayList<int[]>> reqList = new ArrayList<>();
        int answer;
        public int solution(int k, int n, int[][] reqs) {
            N = n;
            K = k;
            arr = new int[k+1];
            Arrays.fill(arr,1);
            answer = Integer.MAX_VALUE;

            for(int i=0; i<=K; i++) reqList.add(new ArrayList<>());

            for(int i=0; i<reqs.length; i++) {
                reqList.get(reqs[i][2]).add(new int[]{reqs[i][0],reqs[i][1]});
            }

            dfs(N - K);
            return answer;
        }
        public void dfs(int sum) {
            if(sum == 0) {
                // System.out.println(Arrays.toString(arr));
                int min = 0;
                for(int i=1; i<=K; i++) {
                    min += getTime(i);
                }
                // System.out.println(min);
                answer = Math.min(answer,min);
                return;
            }

            int remind = Integer.MAX_VALUE;
            int idx = 1;
            for(int i=1; i<=K; i++) {
                arr[i]++;
                int min = 0;
                for(int j=1; j<=K; j++) {
                    min += getTime(j);
                }
                arr[i]--;

                if(min < remind) {
                    remind = min;
                    idx = i;
                }
                // arr[i]++;
                // dfs(sum - 1);
                // arr[i]--;
            }

            arr[idx]++;
            dfs(sum-1);
            arr[idx]--;
        }
        public int getTime(int type) {
            int waitTime = 0;
            ArrayList<int[]> req = reqList.get(type);
            int[] consultant = new int[arr[type]];
            for(int i=0; i<req.size(); i++) {
                int startTime = req.get(i)[0];
                int endTime = req.get(i)[1];
                // System.out.println(type + " " + startTime + " " + endTime);
                int min = Integer.MAX_VALUE;
                int minIdx = 0;
                for(int j=0; j<arr[type]; j++) {
                    int wait = 0;
                    if(startTime <= consultant[j])
                        wait = consultant[j] - startTime;
                    // System.out.println("wait = " + wait);
                    if(wait < min) {
                        min = wait;
                        minIdx = j;
                    }
                }

                consultant[minIdx] = Math.max(startTime,consultant[minIdx]) + endTime;
                waitTime += min;
            }

            return waitTime;
        }
    }
}
