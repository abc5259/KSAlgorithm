// 그래프 - boj.kr/11404 플로이드
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ_11404 {
    static int MAX_NUM = 10000001;
    static int[][] Floyd(int[][] path, int V) {
        for (int k = 1; k < V+1; k++) {
            for (int i = 1; i < V+1; i++) {
                for (int j = 1; j < V+1; j++) {
                    path[i][j] = Math.min(path[i][j], path[i][k] + path[k][j]);
                }
            }
        }

        return path;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] path = new int[N+1][N+1];

        for (int i = 0; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (i == j) continue;
                path[i][j] = MAX_NUM;
            }
        }
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (path[v1][v2] == 0 || path[v1][v2] > w)
                path[v1][v2] = w;
        }

        path = Floyd(path, N);

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (path[i][j] == MAX_NUM)
                    path[i][j] = 0;
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }
}