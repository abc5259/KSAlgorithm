package Programmers.JaeHoon.level3;

import java.util.*;
public class 외벽_점검 {

    class Solution {
        List<int[]> weaks = new ArrayList<>();
        List<int[]> dists = new ArrayList<>();
        boolean[] isUsed;
        int N;
        int[] copyDist;
        int[] arr;
        int max;
        int answer = Integer.MAX_VALUE;
        public int solution(int n, int[] weak, int[] dist) {
            max = n;
            copyDist = dist;
            N = dist.length;
            arr = new int[N];
            isUsed = new boolean[N];

            for(int i=0; i<weak.length; i++) {
                int[] arr = new int[weak.length];

                int idx = 0;
                for(int j=i; j<weak.length; j++) {
                    arr[idx++] = weak[j];
                }

                for(int j=0; j<=i-1; j++) {
                    arr[idx++] = weak[j];
                }

                weaks.add(arr);
            }

            solve(0);

            for(int[] d: dists) {
                for(int[] w: weaks) {
                    check(d, w);
                }
            }

            return answer == Integer.MAX_VALUE ? -1 : answer+1;
        }

        public void check(int[] d, int[] w) {
            int dIdx = 0;

            int start = 0;
            int end = 0;
            while(end < w.length && dIdx < d.length) {
                int dif = w[end] - w[start];
                if(dif < 0) dif = w[end] + (max - w[start]);

                if(d[dIdx] >= dif) {
                    end++;
                }else {
                    dIdx++;
                    start = end;
                }
            }

            if(end >= w.length) {
                answer = Math.min(dIdx, answer);
            }

        }

        public void solve(int depth) {
            if(depth == N) {
                dists.add(arr.clone());
                return;
            }

            for(int i=0; i<N; i++) {
                if(isUsed[i]) continue;
                arr[depth] = copyDist[i];
                isUsed[i] = true;

                solve(depth + 1);
                isUsed[i] = false;
            }
        }
    }
}
