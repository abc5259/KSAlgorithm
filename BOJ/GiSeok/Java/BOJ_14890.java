/**
 * 14890 - 경사로 [실패|01:20:11]
 * 골드3, 구현
 * 
 * cnt 이용, 다음칸과 비교하기 까지 생각해놓고, 정작 구현을 못해서 틀렸다.
 * 그리고 행에 놓은 것과 열에 놓는 것이 중복되면 안될 줄 알았는데 중복되도 상관없는 문제였다.
 * 그저, 같은 행 또는 열에서만 중복되지 않으면 된다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890 {
    // 시간제한 2초, 메모리제한 512MB
    // 크기가 N*N인 맵, 각 칸엔 높이
    // 길이 몇 개 있는지? -> 길이란 하나의 행 또는 하나의 열 전부를 나타내고 한쪽 끝 -> 다른쪽 끝
    // 길 지나려면 길에 속한 모든 칸 높이 같아야, 경사로를 놓을 수 있다. (경사로 높이1 길이L)

    static int[][] map;
    static int[][] pam;
    static int N, L;
    static int ret = 0;

    static void solve(int[][] map) {
        for (int y = 0; y < N; y++) {
            int cnt = 1;
            int x = 0;
            for (x = 0; x < N-1; x++) {
                if (map[y][x] - map[y][x + 1] == 0) cnt++;
                else if (map[y][x] - map[y][x+1] == -1 && cnt >= L) cnt = 1;
                else if (map[y][x] - map[y][x+1] == 1 && cnt >= 0) cnt = -L + 1;
                else break;
            }

            if (x == N-1 && cnt >= 0) ret++;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        pam = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                pam[j][i] = map[i][j];
            }
        }

        solve(map); solve(pam);
        System.out.println(ret);
    }
}
