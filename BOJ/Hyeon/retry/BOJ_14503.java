package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {
    static int[][] room;
    static int N, M, R, C, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(R, C, D);
        System.out.println(res);
    }

    static int res;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void clean(int y, int x, int dir) {

        if (room[y][x] == 0) {
            room[y][x] = 2;
            res++;
        }
//        boolean flag = false; // 빈칸이 없다.
//
//        for (int i = 0; i < 4; i++) {
//            int ny = y + dy[i];
//            int nx = x + dx[i];
//
//            if (ny >= 0 && ny < N && nx >= 0 && nx < M && room[ny][nx] == 0) {
//                flag = true;// 빈칸이 있다.
//                break;
//            }
//        }
//        if (flag) {
//            for (int i = 0; i < 4; i++) {
//                dir = (dir + 3) % 4;
//                int ny = y + dy[dir];
//                int nx = x + dx[dir];
//
//                if (room[ny][nx] == 0) {
//                    clean(ny, nx, dir);
//                    break;
//                }
//            }
//        } else {
//            int ny = y + dy[(dir + 2) % 4];
//            int nx = x + dx[(dir + 2) % 4];
//
//            if (room[ny][nx] != 1) {
//                clean(ny, nx, dir);
//            }
//        }
        boolean flag = false; // 빈칸이 없다.

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M && room[ny][nx] == 0) {
                clean(ny, nx, dir);
                flag = true;// 빈칸이 있다.
                break;
            }
        }
        if (!flag) {
            int ny = y + dy[(dir + 2) % 4];
            int nx = x + dx[(dir + 2) % 4];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M && room[ny][nx] != 1) {
                clean(ny, nx, dir);
            }
        }
    }
}

//G5 로봇 청소기 시뮬레이션

// 재귀를 이용하고, 일단 의사코드를 작성하여 순서대로 써내려갔다.
// 현재 칸을 청소하고 현재칸의 좌표와 방향을 인수로 청소하는 재귀 메소드를 만든다.
// 그리고 해당 방을 청소하면 2로 배열을 초기화하고
// 빈칸이 없다는 플래그를 만들고
// 빈칸이 있을경우 반시계방향으로 회전하면서 빈칸을 찾아서 전진하고 이를 청소하며 반복하고
// 빈칸이 없을경우 후진할 수 있으면 후진하여서 다시 청소하러 떠나고 없으면 종료한다.

// 새롭게 알게된 풀이는 4방 탐색때부터 그냥 반시계로 빈칸을 찾아서 있으면 그대로 청소하면된다
// 없으면 바로 후진여부를 따지면되고 어렵게 풀었다 정말