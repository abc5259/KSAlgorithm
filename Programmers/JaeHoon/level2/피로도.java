package Programmers.JaeHoon.level2;

public class 피로도 {
    class Solution {
        int[] arr;
        boolean[] isUsed;
        int N;
        int[][] dungeon;
        int K;
        int answer;
        public int solution(int k, int[][] dungeons) {
            dungeon = dungeons;
            K = k;
            N = dungeons.length;
            arr = new int[N];
            isUsed = new boolean[N];
            solve(0);
            return answer;
        }

        public void solve(int depth) {

            if(depth == N) {
                int currK = K;
                int total = 0;
                for(int i=0; i<N; i++) {
                    if(currK >= dungeon[arr[i]][0]) {
                        total++;
                        currK -= dungeon[arr[i]][1];
                    }
                }
                answer = Math.max(answer, total);
                return;
            }

            for(int i=0; i<N; i++) {
                if(isUsed[i]) continue;
                arr[depth] = i;
                isUsed[i] = true;

                solve(depth+1);

                isUsed[i] = false;
                arr[depth] = 0;
            }
        }
    }
}
