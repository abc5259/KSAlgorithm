/**
 * 3190 - 뱀 [성공(반례힌트)|02:14:43]
 * 골드4, 구현/시뮬레이션, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_3190 {
    // 시간제한 1초, 메모리제한 128MB
    // 뱀 게임
    // 시작 좌표 (0, 0) 길이 1
    // 맨 처음 오른쪽으로 감

    /*
    매 초마다 이동
    1. 뱀은 몸길이를 늘려 머리를 다음칸에 위치 시킴
    2. 벽이나 자기자신의 몸과 부딪히면 게임 끝
    3. 이동한 칸에 사과가 있다면, 사과가 없어지고 꼬리는 움직이지 않음
    4. 사과가 없다면, 몸길이를 줄여 꼬리가 위치한 칸을 비움
     */

    // 보드의 크기 N (2 <= N <= 100)
    // 사과의 개수 K (0 <= K <= 100)
    // 방향 변환 정보.
    // X C
    // 시작시간으로부터 X초가 끝난 뒤에 C 왼쪽(L) 또는 오른쪽(D)로 90도 방향 회전

    // 1. 정사각형 배열이므로 방향 전환 --> 그냥 보드 자체를 돌리자. (시간 초과 남)
    // 2. 좌, 우로만 이동하므로 동 남 서 북으로 이동 좌표를 구성하면 오른쪽 1, 왼쪽 -1을 통해 움직임 가능!!
    //    꼬리의 좌표는 어떻게 할 것인가? --> queue에 넣고, 0을 만나면 가장 처음 넣은 좌표를 꺼내 0으로 만든다.
    //    그리고, 이동할 좌표를 2(뱀)으로 만들어주면 됨!!

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static int[][] map;
    static char[] time;
    static int N, K, L;

    static ArrayDeque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y-1][x-1] = 1;
        }

        L = Integer.parseInt(br.readLine());
        time = new char[10001];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            time[t] = c;
        }

        int d = 0;
        int y = 0, x = 0;
        map[0][0] = 2;
        q.add(0);
        q.add(0);

        for (int t = 0; t < 10001; t++) {

            if (time[t] == 'D')
                d = (d + 1) % 4;
            else if (time[t] == 'L')
                d = (d - 1) < 0 ? 3 : d-1;

            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N ||
                map[ny][nx] == 2) {
                System.out.println(t + 1);
                return;
            }

            if (map[ny][nx] == 0) {
                int yy = q.poll();
                int xx = q.poll();
                map[yy][xx] = 0;
            }

            map[ny][nx] = 2;
            q.add(ny);
            q.add(nx);

            y = ny;
            x = nx;
        }
    }
}
