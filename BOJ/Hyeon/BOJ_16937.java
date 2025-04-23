package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16937 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        int[][] stickers = new int[N][2];

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if ((R <= h && C <= w) || (R <= w && C <= h)) {
                stickers[cnt][0] = R;
                stickers[cnt][1] = C;
                cnt++;
            }
        }

        if (cnt < 2) {
            System.out.println(0);
            return;
        }

        int res = 0;

        for (int i = 0; i < cnt; i++) {
            for (int j = i + 1; j < cnt; j++) {
                if (stickers[i][0] <= h && stickers[i][1] <= w) {
                    if (stickers[j][0] <= h && stickers[j][1] <= w) {
                        // 가로로 이어 붙이기
                        if (stickers[i][1] + stickers[j][1] <= w) {
                            res = Math.max(res, sum(stickers, i, j));
                        }
                        // 세로로 이어 붙이기
                        if (stickers[i][0] + stickers[j][0] <= h) {
                            res = Math.max(res, sum(stickers, i, j));
                        }
                    }
                    if (stickers[j][1] <= h && stickers[j][0] <= w) {
                        // 가로로 이어 붙이기
                        if (stickers[i][1] + stickers[j][0] <= w) {
                            res = Math.max(res, sum(stickers, i, j));
                        }
                        // 세로로 이어 붙이기
                        if (stickers[i][0] + stickers[j][1] <= h) {
                            res = Math.max(res, sum(stickers, i, j));
                        }
                    }
                }
                if (stickers[i][1] <= h && stickers[i][0] <= w) {
                    if (stickers[j][0] <= h && stickers[j][1] <= w) {
                        // 가로로 이어 붙이기
                        if (stickers[i][0] + stickers[j][1] <= w) {
                            res = Math.max(res, sum(stickers, i, j));
                        }
                        // 세로로 이어 붙이기
                        if (stickers[i][1] + stickers[j][0] <= h) {
                            res = Math.max(res, sum(stickers, i, j));
                        }
                    }
                    if (stickers[j][1] <= h && stickers[j][0] <= w) {
                        // 가로로 이어 붙이기
                        if (stickers[i][0] + stickers[j][0] <= w) {
                            res = Math.max(res, sum(stickers, i, j));
                        }
                        // 세로로 이어 붙이기
                        if (stickers[i][1] + stickers[j][1] <= h) {
                            res = Math.max(res, sum(stickers, i, j));
                        }
                    }
                }
            }
        }
        System.out.print(res);
    }

    private static int sum(int[][] stickers, int i, int j) {
        return (stickers[i][0] * stickers[i][1]) + (stickers[j][0] * stickers[j][1]);
    }
}

// S3 두 스티커 브루트포스
// 일단 첫번째로 생각하자면 2개의 스티커를 골라야 하는데 2개가 안될 경우는 곧바로 0을 출력하고 종료한다.
// 2차원 배열을 통해서 생성하고 0,0 이 안들어가게 유의하는 cnt 인덱스를 따로 둔다.
// 그리고 첫번째 스티커가 그대로 인지 회전했는지 2개의 경우의 수와
// 2번째 스티커가 그대로 인지 회전했는지 2개의 경우의 수로 총 4가지에다가
// 각 경우의 수에서 2개의 스티커를 세로로 나란히 붙이는 방법과 가로로 나란히 붙이는 방법 2가지해서 총 8가지의 경우의 수가 분기된다
// 그런데 if 조건을 통해서 발생할 수 있는 모든 경우의 수 (브루트포스) 를 통해서 구한다음 최고값 == 최대 넓이를 반영한다.
// trouble shooting 당연시 하게 가장 넓이가 큰 도형부터 출력되게 해서 2개가 출력되면 종료라는 조건을 통해서 우선순위 큐를 사용했는데
// 반레
// 4 4
// 4
// 4 3
// 4 2
// 2 4
// 1 1  일때 크기순으로 우선순위 큐를 해버리면 4 3 과 1 1 이 반영되는데 최고값은 2 4 와 4 2 이다.