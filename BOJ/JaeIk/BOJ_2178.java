package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int[][] map;
    static int n;
    static int m;
    
    //Boolean 타입 -> Null로 초기화
    //boolean 타입 -> false로 초기화
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();

            for(int j=0; j<m; j++){
                //문자형에서 정수형으로 변환
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                //벽을 벗어낫을 경우 다음으로
                if(nextX<0||nextY<0||nextX>=n||nextY>=m)continue;
                // 0이면 장애물이므로 다음으로
                if(visited[nextX][nextY]==true||map[nextX][nextY]==0)continue;

                q.add(new int[] {nextX, nextY});
                //이전까지의 거리에 +1을 해 갱신 해준다
                map[nextX][nextY] = map[nowX][nowY] + 1;
                //방문한 좌표는 벽으로 만든다
                visited[nextX][nextY] = true;
            }
        }
    }
}
