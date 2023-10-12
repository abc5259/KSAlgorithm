package Programmers.JaeHoon.level3;

import java.util.*;
public class 표_병합 {

    class Solution {
        int[] parents;
        int N;
        public ArrayList<String> solution(String[] commands) {
            ArrayList<String> answer = new ArrayList<>();
            N = 50*50+1;
            parents = new int[N];
            for(int i=0; i<N; i++) parents[i] = i;

            String[][] cells = new String[51][51];

            for(String cmd: commands) {
                String[] cmdArr = cmd.split(" ");
                if(cmdArr[0].equals("UPDATE")) {
                    if(cmdArr.length == 4) {
                        int r = Integer.valueOf(cmdArr[1]);
                        int c = Integer.valueOf(cmdArr[2]);
                        int p = find(50 * (r-1) + c-1);
                        int newR = p / 50 + 1;
                        int newC = p % 50 + 1;
                        cells[r][c] = cmdArr[3];
                        cells[newR][newC] = cmdArr[3];
                    }else {

                        for(int i=1; i<=50; i++) {
                            for(int j=1; j<=50; j++) {
                                int p = find(50 * (i-1) + j-1);
                                int r = p / 50 + 1;
                                int c = p % 50 + 1;
                                if(cells[r][c] != null && cells[r][c].equals(cmdArr[1])) {
                                    cells[r][c] = cmdArr[2];
                                }
                            }
                        }
                    }
                }
                else if(cmdArr[0].equals("MERGE")) {
                    int r1 = Integer.valueOf(cmdArr[1]);
                    int c1 = Integer.valueOf(cmdArr[2]);
                    int p = find(50 * (r1-1) + c1 - 1);

                    int r2 = Integer.valueOf(cmdArr[3]);
                    int c2 = Integer.valueOf(cmdArr[4]);
                    int p2 = find(50 * (r2-1) + c2 - 1);

                    if(p == p2) continue;

                    int pr1 = p / 50 + 1;
                    int pc1 = p % 50 + 1;

                    int pr2 = p2 / 50 + 1;
                    int pc2 = p2 % 50 + 1;

                    //원래 r1, c1에 해당하는 셀의 값 가져오기
                    String newValue = cells[pr1][pc1];
                    String newValue2 = cells[pr2][pc2];

                    // cells[r1][c1] = null;
                    // cells[r2][c2] = null;

                    // 두 셀 병합하기
                    union(50 * (r1-1) + c1 - 1, 50 * (r2-1) + c2 - 1);

                    //병합 된 셀에서 부모에 해당하는 셀에 값 부여
                    p = find(50 * (r1-1) + c1 - 1);
                    r1 = p / 50 + 1;
                    c1 = p % 50 + 1;

                    if(newValue != null) {
                        cells[r1][c1] = newValue;
                    }
                    else if(newValue2 != null){
                        cells[r1][c1] = newValue2;
                    }else {
                        cells[r1][c1] = null;
                    }
                }
                else if(cmdArr[0].equals("UNMERGE")) {
                    int r1 = Integer.valueOf(cmdArr[1]);
                    int c1 = Integer.valueOf(cmdArr[2]);
                    int p = find(50 * (r1-1) + c1 - 1);
                    r1 = p / 50 + 1;
                    c1 = p % 50 + 1;

                    String value = cells[r1][c1]; //해당값
                    r1 = Integer.valueOf(cmdArr[1]);
                    c1 = Integer.valueOf(cmdArr[2]);


                    ArrayList<int[]> list = new ArrayList<>();
                    for(int i=1; i<=50; i++) {
                        for(int j=1; j<=50; j++) {
                            int findP = find(50 * (i-1) + j - 1);
                            if(p == findP) list.add(new int[]{i,j});
                        }
                    }

                    for(int[] cell: list) {
                        cells[cell[0]][cell[1]] = null;
                        parents[50 * (cell[0]-1) + cell[1] - 1] = 50 * (cell[0]-1) + cell[1] - 1;
                    }

                    cells[r1][c1] = value; //값 주기
                }
                else if(cmdArr[0].equals("PRINT")) {
                    int r1 = Integer.valueOf(cmdArr[1]);
                    int c1 = Integer.valueOf(cmdArr[2]);
                    int p = find(50 * (r1-1) + c1 - 1);

                    r1 = p / 50 + 1;
                    c1 = p % 50 + 1;
                    if(cells[r1][c1] == null) {
                        answer.add("EMPTY");
                    }else  {
                        answer.add(cells[r1][c1]);
                    }

                }
            }
            return answer;
        }
        public int find(int x) {
            if(parents[x] == x) return x;
            return parents[x] = find(parents[x]);
        }
        public void union(int x, int y) {
            x = find(x);
            y = find(y);

            if(x <= y) parents[y] = x;
            else parents[x] = y;
        }
    }
}
