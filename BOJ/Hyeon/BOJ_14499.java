package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499 {
    static int[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new int[7];

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken()) - 1;

            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                continue;
            }

            if (dir == 0) {
                right();
            } else if (dir == 1) {
                left();
            } else if (dir == 2) {
                up();
            } else {
                down();
            }

            if (map[ny][nx] == 0) {
                map[ny][nx] = dice[6];
            } else {
                dice[6] = map[ny][nx];
                map[ny][nx] = 0;
            }
            y = ny;
            x = nx;
            sb.append(dice[1]).append("\n");
        }
        System.out.println(sb);
    }

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static void up() {
        int tmp = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[6];
        dice[6] = dice[2];
        dice[2] = tmp;
    }

    static void down() {
        int tmp = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[6];
        dice[6] = dice[5];
        dice[5] = tmp;
    }

    static void left() {
        int tmp = dice[1];
        dice[1] = dice[3];
        dice[3] = dice[6];
        dice[6] = dice[4];
        dice[4] = tmp;
    }

    static void right() {
        int tmp = dice[1];
        dice[1] = dice[4];
        dice[4] = dice[6];
        dice[6] = dice[3];
        dice[3] = tmp;
    }
}
// G4 주사위 굴리기 시뮬레이션
// 47분
// 주사위를 돌려야되는게 문제인데 굳이 주사위를 돌리는게 아닌 주사위는 고정시켜두고 값만 바꿔버리면됐다
// 동서북남 기준으로 정육면체의 값만 진행방향으로 회전하여 swap 해주면되었다.
// 그래서 dice 의 면을 맨위를 1로 두고 동쪽을 3으로 두기에 크기 7로 잡고 up down left right 메소드를 만들고
// trouble shooting
// 북쪽으로부터 아래로 가 r 이고 서쪽으로부터 동쪽으로가 c 이다 근데 r,c 가 알고보니 x,y 였다 나는 y,x 로 풀어서
// y x 조건 확인했고
// dir 4방향 벡터에서 지도안에 있는지 확인하고 있다면 방향으로 메소드 호출해서 진행시키고
// map 에 값이 있는지에 대해 여부를 물어서 실행하고 dice[1] 인 윗쪽을 출력한다
// 그리고 ny nx 로 진행된거는 y , x에 그대로 다시 대입해서 현재위치를 갱신한다.
