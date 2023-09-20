package Programmers.JaeHoon.level2;

public class 혼자서_하는_틱택토 {

    class Solution {
        String[] map;
        boolean[][] isVisited;
        int totalCnt = 0;
        Integer[] oCntArr = {0,0,0,0,0,0,0,0};
        Integer[] xCntArr = {0,0,0,0,0,0,0,0};
        public int solution(String[] board) {
            int answer = -1;
            map = board;
            isVisited = new boolean[3][3];
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    if(board[i].charAt(j) != '.') {
                        totalCnt++;
                    }
                }
            }

            boolean a = dfs('O',0);
            return a ? 1 : 0;
        }
        public boolean dfs(char curr, int cnt) {
            if(cnt == totalCnt) return true;

            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    if(isVisited[i][j] || map[i].charAt(j) != curr) continue;

                    Integer[] cntArr = curr == 'O' ? oCntArr : xCntArr;
                    if(cnt + 1 != totalCnt) {
                        if((cntArr[i] + 1 == 3) || (cntArr[j+3] + 1 == 3)) continue;
                        if(i == 1 && j == 1) {
                            if((cntArr[6] + 1 == 3) || (cntArr[7] + 1 == 3)) continue;
                        }
                        if(i+j == 0 || i+j == 4) {
                            if(cntArr[6] + 1 == 3) continue;
                        }
                        if(i + j == 2) {
                            if(cntArr[7] + 1 == 3) continue;
                        }
                    }


                    char next = curr == 'O' ? 'X' : 'O';

                    isVisited[i][j] = true;
                    cntArr[i] += 1;
                    cntArr[j+3] += 1;
                    if(i+j == 0 || i+j == 4) cntArr[6] += 1;
                    if(i+j == 2) cntArr[7] += 1;
                    if(i == 1 && j == 1) cntArr[6] += 1;

                    if(dfs(next,cnt+1)) return true;

                    isVisited[i][j] = false;
                    cntArr[i] -= 1;
                    cntArr[j+3] -= 1;
                    if(i+j == 0 || i+j == 4) cntArr[6] -= 1;
                    if(i+j == 2) cntArr[7] -= 1;
                    if(i == 1 && j == 1) cntArr[6] -= 1;

                }
            }

            return false;


        }
    }
}
