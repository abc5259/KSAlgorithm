package Programmers.JaeHoon.level3;

public class 고고학_최고의_발견 {
    class Solution {

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};

        int N;
        int[][] clockHandArr;
        int answer = Integer.MAX_VALUE;
        public int solution(int[][] clockHands) {
            N = clockHands.length;
            clockHandArr = clockHands;

            solve(0,0);
            return answer;
        }

        public void solve(int depth, int cnt) {

            if(depth == N) {
                dfs(1,0,cnt);
                return;
            }

            for(int i=0; i<4; i++) {
                int old = clockHandArr[0][depth];
                clockHandArr[0][depth] = (clockHandArr[0][depth] + i) % 4;

                for(int d=0; d<4; d++) {
                    int nx = 0 + dx[d];
                    int ny = depth + dy[d];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    clockHandArr[nx][ny] = (clockHandArr[nx][ny] + i) % 4;
                }

                solve(depth + 1 , cnt + i);

                clockHandArr[0][depth] = old;

                for(int d=0; d<4; d++) {
                    int nx = 0 + dx[d];
                    int ny = depth + dy[d];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    clockHandArr[nx][ny] = (clockHandArr[nx][ny] + 4 - i) % 4;
                }
            }
        }

        public void dfs(int x, int y, int cnt) {
            if(x == N) {
                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        if(clockHandArr[i][j] != 0) return;
                    }
                }
                answer = Math.min(answer, cnt);
                return;
            }

            if(y == N) {
                dfs(x+1,0,cnt);
                return;
            }

            int rotateCnt = clockHandArr[x-1][y] == 0 ? 0 : 4 - clockHandArr[x-1][y];

            clockHandArr[x][y] = (clockHandArr[x][y] + rotateCnt) % 4;

            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                clockHandArr[nx][ny] = (clockHandArr[nx][ny] + rotateCnt) % 4;
            }

            dfs(x,y+1,cnt + rotateCnt);

            clockHandArr[x][y] = (clockHandArr[x][y] + 4 - rotateCnt) % 4;
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                clockHandArr[nx][ny] = (clockHandArr[nx][ny] + 4 - rotateCnt) % 4;
            }
        }
    }
}
