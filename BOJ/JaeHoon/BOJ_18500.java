package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_18500 {
    static int N,M;
    static char[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int c = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        boolean turn = true;
        for(int i=0; i<c; i++) {
            int h = Integer.parseInt(st.nextToken()) - N;
            int r = Math.abs(h);

            int[] pos = throwBar(r,turn);

            turn = !turn;
            if(pos[0] == -1 && pos[1] == -1) {
                continue;
            }

//            System.out.println("throw = " + r);
            map[pos[0]][pos[1]] = '.';
            boolean good = false;
            for(int d=0; d<4; d++) {
                if(good) break;
                Set<int[]> set = new HashSet<>();
                int nextX = pos[0] + dx[d];
                int nextY = pos[1] + dy[d];
//                System.out.println("nextX = " + nextX + " nextY = " + nextY);
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N ) continue;
                if(map[nextX][nextY] == '.') continue;

                findCluster(set, new int[]{nextX, nextY});
                int plusX = Integer.MAX_VALUE;
                for(int[] point: set) {
                    System.out.println("x = " + point[0] + " y = " + point[1]);
                    if(point[0] + 1 >= N) {
                        plusX = 0;
                        break;
                    }
                    int plus = 1;
                    int x = point[0];
                    int y = point[1];
                    if(x + plus < N && map[x+plus][y] == 'x') continue;

                    while (x + plus < N && map[x+plus][y] == '.') {
                        plus++;
                    }
                    boolean isOk = true;
                    for (int[] a : set) {
                        if(x+plus == a[0]) {
                            isOk = false;
                            break;
                        }
                    }
                    if(!isOk) continue;
                    System.out.println("plus = " +  plus);
                    plusX = Math.min(plusX, plus-1);
                }

                if(plusX > 0) good = true;
                System.out.println("plusX = " + plusX);
                ArrayList<int[]> arr = new ArrayList<>(set);
                Collections.sort(arr, (a,b) -> b[0] - a[0]);
//                System.out.println("size = " + arr.size());
                if(plusX != Integer.MAX_VALUE) {
                    for(int[] point: arr) {
//                        System.out.println("x = " + point[0] + " y = " + point[1]);
//                        System.out.println("x = " + (point[0] + plusX) + " y = " + point[1]);
                        map[point[0]][point[1]] = '.';
                        map[Math.min(point[0] + plusX, N-1)][point[1]] = 'x';
                    }
                }

//                break;
            }

        }


        StringBuilder sb = new StringBuilder();
        for(int a=0; a<N; a++) {
            for(int b=0; b<M; b++) {
                sb.append(map[a][b]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static int findCluster(Set<int[]> set, int[] pos) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];
        q.offer(pos);
        isVisited[pos[0]][pos[1]] = true;
        set.add(pos);

        int bottom = pos[0];
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for(int i=0; i<4; i++) {
                int nextX = curr[0] + dx[i];
                int nextY = curr[1] + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || isVisited[nextX][nextY]) continue;
                if(map[nextX][nextY] == '.') continue;

                int[] next = {nextX,nextY};
                set.add(next);
                isVisited[nextX][nextY] = true;
                q.offer(next);
                System.out.println("x = " + nextX + " y = " + nextY);
                bottom = Math.max(bottom,nextX);
            }
        }

        return bottom;
    }

    public static int[] throwBar(int r, boolean turn) {
        if(turn) {
            for(int i=0; i<M; i++) {
                if(map[r][i] == 'x') {
                    return new int[]{r,i};
                }
            }
        }else {
            for(int i=M-1; i>=0; i--) {
                if(map[r][i] == 'x') {
                    return new int[]{r,i};
                }
            }
        }

        return new int[]{-1,-1};
    }
}
