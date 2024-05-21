package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
    static int[] dh = {-1, 1};
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int m, n, h;
    static int[][][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        boolean flag = false;
        map = new int[h][n][m];
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());

                for(int k=0; k<m; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] != 1)flag = true;
                }
            }
        }

        int answer = flag?bfs():0;

        System.out.println(answer);
    }

    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        int[][][] day = new int[h][n][m];

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(map[i][j][k] == 1){
                        queue.add(new int[] {i, j, k});
                        day[i][j][k] = 1;
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowH = now[0];
            int nowR = now[1];
            int nowC = now[2];

            for(int i=0; i<2; i++){
                int nextH = nowH + dh[i];

                if(nextH<0 || nextH>=h)continue;
                if(map[nextH][nowR][nowC] == -1 || map[nextH][nowR][nowC] == 1)continue;

                queue.add(new int[] {nextH, nowR, nowC});
                map[nextH][nowR][nowC] = 1;
                day[nextH][nowR][nowC] = day[nowH][nowR][nowC] + 1;
            }

            for(int i=0; i<4; i++){
                int nextR = nowR + dr[i];
                int nextC = nowC + dc[i];

                if(nextR<0 || nextC<0 || nextR>=n || nextC>=m)continue;
                if(map[nowH][nextR][nextC] == -1 || map[nowH][nextR][nextC] == 1)continue;

                queue.add(new int[] {nowH, nextR, nextC});
                map[nowH][nextR][nextC] = 1;
                day[nowH][nextR][nextC] = day[nowH][nowR][nowC] + 1;
            }
        }

        int max = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    max = Math.max(day[i][j][k], max);

                    if(map[i][j][k] == 0){
                        return -1;
                    }
                }
            }
        }

        return max-1;
    }
}
