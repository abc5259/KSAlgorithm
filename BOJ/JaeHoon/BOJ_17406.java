package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {
    static int N,M,K;
    static int[][] arr;
    static int[][] carr;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] list;
    static int[][] pickArr;
    static boolean[] isVisit;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        carr = new int[N+1][M+1];
        list = new int[K][3];
        pickArr = new int[K][3];
        isVisit = new boolean[K];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                carr[i][j] = arr[i][j];
            }
        }

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
            list[i][2] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(min);
    }
    public static void dfs(int depth) {
        if(depth == K) {
            for(int i=0; i<K; i++) {
                int R = pickArr[i][0];
                int C = pickArr[i][1];
                int S = pickArr[i][2];
                rotate(R-S,C-S,2*S + 1, 2*S + 1);
            }
            for(int i=1; i<=N; i++) {
                int sum = 0;
                for(int j=1; j<=M; j++) {
                    sum += arr[i][j];
                    arr[i][j] = carr[i][j];
                }
                min = Math.min(min,sum);
            }
            return;
        }

        for(int i=0; i<K; i++) {
            if(isVisit[i]) continue;
            isVisit[i] = true;
            pickArr[depth][0] = list[i][0];
            pickArr[depth][1] = list[i][1];
            pickArr[depth][2] = list[i][2];
            dfs(depth+1);
            isVisit[i] = false;
        }
    }
    public static void rotate(int r, int c, int n, int m) {
        int size = Math.min(n,m) / 2;
        for(int i=0; i<size; i++) {
            int x = r + i;
            int y = c + i;
            int a = r + i;
            int b = c + i;

            int temp = arr[x][y];
            int idx = 0;

            while (idx < 4) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if(a <= nx && b <= ny && nx <= n + a -1 && ny <= m + b -1) {
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                }else {
                    idx++;
                }
            }
            arr[a][b+1] = temp;

            n -= 2;
            m -= 2;
        }
    }
}
