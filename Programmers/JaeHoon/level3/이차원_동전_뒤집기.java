package Programmers.JaeHoon.level3;

public class 이차원_동전_뒤집기 {
    class Solution {
        boolean[] isRowUsed;
        boolean[] isColUsed;
        int[][] targets;
        int[][] beginnings;
        int answer = Integer.MAX_VALUE;
        int n,m;

        public int solution(int[][] beginning, int[][] target) {
            n =  beginning.length;
            m =  beginning[0].length;

            isRowUsed = new boolean[n];
            isColUsed = new boolean[m];
            beginnings = beginning;
            targets = target;
            dfs(0,0,0);
            return answer == Integer.MAX_VALUE ? - 1 : answer;
        }

        public void dfs(int x, int y, int cnt) {

            boolean isOk = true;
            Loop: for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(beginnings[i][j] != targets[i][j]) {
                        isOk = false;
                        break Loop;
                    }
                }
            }

            if(isOk) {
                answer = Math.min(cnt, answer);
                return;
            }

            if(x == n) return;
            if(y == m) {
                dfs(x+1,0,cnt);
                return;
            }

            if(beginnings[x][y] == targets[x][y]) {
                dfs(x,y+1,cnt);
                return;
            }

            if(!isRowUsed[x]) {
                isRowUsed[x] = true;
                reverseRow(x);

                dfs(x,y+1,cnt+1);

                isRowUsed[x] = false;
                reverseRow(x);
            }

            if(!isColUsed[y]) {
                isColUsed[y] = true;
                reverseCol(y);

                dfs(x,y+1,cnt+1);

                isColUsed[y] = false;
                reverseCol(y);
            }
        }
        public void reverseRow(int x) {
            for(int i=0; i<m; i++) {
                beginnings[x][i] = beginnings[x][i] == 1 ? 0 : 1;
            }
        }

        public void reverseCol(int y) {
            for(int i=0; i<n; i++) {
                beginnings[i][y] = beginnings[i][y] == 1 ? 0 : 1;
            }
        }
    }
}
