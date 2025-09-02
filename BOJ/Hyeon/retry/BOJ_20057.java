package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057 {
    static int[] percent = {1, 1, 2, 2, 5, 7, 7, 10, 10};

    static int[][] sandY = {
            {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0},
            {-1, -1, 0, 0, 2, 0, 0, 1, 1, 1},
            {1, -1, 2, -2, 0, 1, -1, 1, -1, 0},
            {1, 1, 0, 0, -2, 0, 0, -1, -1, -1}
    };

    static int[][] sandX = {
            {1, 1, 0, 0, -2, 0, 0, -1, -1, -1},
            {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0},
            {-1, -1, 0, 0, 2, 0, 0, 1, 1, 1},
            {1, -1, 2, -2, 0, 1, -1, 1, -1, 0}
    };
    static int outSand = 0;
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tornado();
        System.out.println(outSand);
    }

    static void tornado() {
        int r = N / 2 + 1;
        int c = N / 2 + 1;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {-1, 0, 1, 0};
        int dir = 0;
        int moveDistance = 1;

        while (r != 1 || c != 1) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < moveDistance; j++) {

                    int nr = r + dr[dir];
                    int nc = c + dc[dir];

                    if (nr < 1 || nc < 1 || nr > N || nc > N) {
                        return;
                    }

                    SpreadSand(nr, nc, dir);
                    r = nr;
                    c = nc;
                }
                dir = (dir + 1) % 4;
            }
            moveDistance++;
        }
    }

    static void SpreadSand(int r, int c, int dir) {

        int sand = map[r][c];
        int remainSand = sand;

        if (sand == 0) {
            return;
        }

        map[r][c] = 0;

        for (int i = 0; i < percent.length; i++) {
            int amount = sand * percent[i] / 100;

            if (amount == 0) {
                continue;
            }

            int ny = r + sandY[dir][i];
            int nx = c + sandX[dir][i];

            if (ny < 1 || nx < 1 || ny > N || nx > N) {
                outSand += amount;
            } else {
                map[ny][nx] += amount;
            }
            remainSand -= amount;
        }

        int ar = r + sandY[dir][9];
        int ac = c + sandX[dir][9];
        if (ar < 1 || ac < 1 || ac > N || ar > N) {
            outSand += remainSand;
        } else {
            map[ar][ac] += remainSand;
        }
    }
}
// G3 마법사 상어와 토네이도 시뮬레이션
// 일단 중요한게 달팽이 처럼 뱅글 뱅글 도는 토네이도와 그 토네이도를 통해 날라가는 모래를 알아야된다.
// 그러기전에는 모래가 날라가는 퍼센테이지를 알아야하고 방향별로 각 퍼센티지를 배치해야되기에 2차원 4방향을 통한 좌표값을 정한다
// sandY 와 sandX 를 통해 좌표값을 설정하고 percent 로 해당 퍼센트와 좌표를 매치한다.
// 그리고 alpha 는 그냥 마지막에 넣는다 좌표만 percent 에는 안넣는다 그냥 인덱스 9로 접근하면된다.
// 먼저 r과 c 토네이도의 중심부터 시작해서 이게 둘다 1,1이면 종료해야된다.
// dr dc 를 통해 4방 탐색을 위한 배열을 만들고 dir 을 통해 해당 인덱스를 관리한다
// 그리고 moveDistance 를 통해서 나선형으로 진행되는것들을 계산한다 이를테면 1,1, 2,2, 3,3, 4,4, 이렇게 증가하기에 2번씩 반복하고 moveDistance를 늘려주면된다.
// 이동거리를 다 진행하면 방향도 바꿔줘야된다.
// 그다음에 중요한게 모래를 날려줘야되고
// trouble
// 모래를 날릴 때 현재 토네이도가 이동한 좌표의 모래를 sand 변수에 저장하고 sand 에 대하여 퍼센티지를 매기기에 남아있는 모래도 따로 변수를 만든다.
// 근데 모래가 0-이면 날릴 필요가없어서 그냥 종료시켜버리고 0이아니면 일단 토네이도가 이동한 자리는 모래를 0으로 만든다.
// percent 횟수만큼 반복하고 이때 날릴 모래의 값도 0이라면 그냥 넘겨버리고 아니라면 그 좌표에 대해서 검사한다음 격자내에 있다면 그 좌표의 모래값 누적합이고
// 아니라면 나가는 모래에 누적합해버린다.
// 그리고 남아있는 모래는 계속해서 빼준다.
// alpha 자리가 남아있는데 이때 알파의 좌표값을 검사하고 남아있는 모래를 알파의 좌표값에 넣을지 바깥으로 나간 모래에 넣을지를 조건 분기로 정하면 끝이다.
// r과 c의 좌표값이 현재 이동한 토네이도 좌표로 바껴야된다. 이점을 유의해야된다.
