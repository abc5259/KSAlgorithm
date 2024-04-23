package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5213 {
    static int[][] map;

    static int[] parent;

    static int N;
    static int R,C;
    static int[] end;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] num;
    static int answer;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        R = N+1;
        C = 2*N + 1;
        map = new int[N+1][2*N+2];
        num = new int[N+1][2*N+2];
        parent = new int[N*N - N/2+1];
        end = new int[2];

        if(N % 2 == 1) {
            end[0] = N;
            end[1] = C-1;
        }else {
            end[0] = N;
            end[1] = C-2;
        }

        int r = 1;
        int c = 1;

        for(int i=1; i<=N*N - N/2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            num[r][c] = i;
            num[r][c+1] = i;
            map[r][c] = a;
            map[r][c+1] = b;
            c+=2;
            if(r % 2 == 0 && c >= 2 * N) {
                r++;
                c=1;
            }
            else if(r % 2 == 1 && c > 2*N) {
                r++;
                c=2;
            }
        }

        bfs();

        int last = 0;
        for(int i=parent.length-1; i>=1; i--) {
            if(parent[i] != 0) {
                last = i;
                break;
            }
        }

        find(last);
        System.out.println(answer);
        System.out.println(sb);
    }

    public static void find(int x) {
        answer++;

        if(parent[x] == x) {
            sb.append(x + " ");
            return;
        }

        find(parent[x]);
        sb.append(x + " ");
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[R][C];

        isVisited[1][1] = true;
        isVisited[1][2] = true;
        parent[1] = 1;
        q.offer(new int[]{1,1});
        q.offer(new int[]{1,2});

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for(int i=0; i<4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if(nx <= 0 || nx >= R || ny <= 0 || ny >= C) continue;
                if(map[nx][ny] == 0) continue;
                if(isVisited[nx][ny]) continue;

                //같은 타일인지 체크
                if(map[curr[0]][curr[1]] != map[nx][ny]) continue;

                parent[num[nx][ny]] = num[curr[0]][curr[1]];

                isVisited[nx][ny] = true;
                q.offer(new int[]{nx,ny});

                if(num[nx][ny] == num[nx][ny + 1]) {
                    q.add(new int[]{nx,ny+1});
                    isVisited[nx][ny + 1] = true;
                }
                // 탐색한 칸이 타일의 오른쪽일 때
                else if(num[nx][ny - 1] == num[nx][ny]) {
                    q.add(new int[]{nx,ny-1});
                    isVisited[nx][ny - 1] = true;
                }
            }
        }

        return -1;
    }
}
