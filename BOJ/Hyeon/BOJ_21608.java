package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21608 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] room = new int[N][N];
        int[][] like = new int[N * N + 1][4];

        StringTokenizer st;
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            for (int s = 0; s < 4; s++) {
                like[num][s] = Integer.parseInt(st.nextToken());
            }

            int finalY = -1, finalX = -1;
            int maxFCnt = -1, maxEmpty = -1;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (room[r][c] == 0) {
                        int fCnt = 0, empty = 0;

                        for (int d = 0; d < 4; d++) {
                            int ny = r + dy[d];
                            int nx = c + dx[d];

                            if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                                continue;
                            }

                            if (room[ny][nx] == 0) {
                                empty++;
                            } else {
                                for (int favoriteFriend : like[num]) {
                                    if (room[ny][nx] == favoriteFriend) {
                                        fCnt++;
                                        break;
                                    }
                                }
                            }
                        }
                        if ((maxFCnt < fCnt) || (maxFCnt == fCnt && maxEmpty < empty)) {
                            maxFCnt = fCnt;
                            maxEmpty = empty;
                            finalY = r;
                            finalX = c;
                        }
                    }
                }
            }
            room[finalY][finalX] = num;
        }
        int satisfaction = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int studentNum = room[i][j];
                int cnt = 0;

                for (int d = 0; d < 4; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
                        continue;
                    }
                    for (int favoriteFriend : like[studentNum]) {
                        if (room[ny][nx] == favoriteFriend) {
                            cnt++;
                            break;
                        }
                    }
                }
                if (cnt != 0) {
                    satisfaction += (int) Math.pow(10, cnt - 1);
                }
            }
        }
        System.out.println(satisfaction);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
}
// G5 상어 초등학교 구현
// 1시간 12분
// 와,, 진짜 진이 빠진다 개힘들게 풀었는데 일단
// 순서가 학생을 배치를 해야되는데 맨 처음학생은 1,1에 둔다 이게 1,2,3번의 룰에 기저해서 결정했고
// 또 그다음 부터는 각 빈칸별로 내가 좋아하는 친구의 수가 가장 많거나 수가 같다면 빈 칸이 많거나 해야되거든 이게 룰 1,2번에다가 3번은
// 행열을 가장 적어야되는데 그게 그냥 제일 먼저 조건이 만족된 곳이라서 이건 신경안쓰고 한다.
// 그래서 이게 4방향 벡터로 탐색해서 칸을 구하는데 maxFCnt 랑 maxEmpty 의 값이 가장 큰 좌표에 있어서
// finalY , finalX 로 좌표를 가져거 교실의 학생 번호 num 을 배치한다
// 그리고 N*N 학생이기에 like 좋아하는 사람 4명씩있는 2차원 배열을 한다
// 근데 여기서 배치할때 maxFCnt 를 구할 수 있는데 만약 처음넣거나 그이후에 넣어도 주변이 아직 학생으로 채워지기전 빈칸이면
// 좋아하는 학생 수를 카운트를못해서 반복문을 별개로 또 돌려서 거기서 학생의 cnt 만 구하게끔 했다
// 원래라면 교실에 배치할때 알수있는 애들도있어서 합치거나 배열을 3차원을 하거나 고민했다
// trouble shooting 이 있는데 finalY 랑 finalX 를 어쩔 수 없이 초기화를 하다보니 값이 덮어쓰이는 경우가 있다
// 모든 칸의 조건이 다 0일경우 그래서 0,0에 덮어씌어지길래 0,0이 결과로 떨어지기전에 first 라는 플래그를 둬서
// 이거로 가장 최근의 빈칸의 좌표를 일단 대입해두고 갱신되지 않으면 그자리를 준다.
// 리팩토링 결과
// 위에서 고민했던 trouble shooting의 0,0 덮어쓰기 문제와 first 플래그는 초기값 설정 하나로 훨씬 깔끔하게 해결할 수 있었다.
// 기존에는 maxFCnt와 maxEmpty를 0으로 초기화해서, fCnt와 empty가 둘 다 0인 상황(최악의 조건)일 때
// if문을 통과하지 못해 좌표 갱신이 안 되는 문제가 발생했던 거다. 하지만 이 초기값들을 0이 아닌 -1로 두면 상황이 달라진다.
// 빈칸이라면 최소한 fCnt와 empty는 0 이상이 보장되니까, 처음 만나는 빈칸에서 무조건 조건문(maxFCnt < fCnt ...)을 타게 되고
// finalY와 finalX가 자동으로 첫 빈칸의 좌표로 세팅된다.