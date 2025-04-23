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
// 이건 다시 고민해봐도 될듯