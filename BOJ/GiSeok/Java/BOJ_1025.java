package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1025 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] table = new int[n][m];
        for (int y = 0; y < n; y++) {
            String input = br.readLine();
            for (int x = 0; x < m; x++) {
                table[y][x] = input.charAt(x) - '0';
            }
        }

        int ans = -1;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                // dr, dc를 독립적으로 순회 (둘 다 0인 경우 제외)
                // 범위를 -(n-1) ~ (n-1)로 잡아준다.
                // 범위를 이렇게 잡는 이유는 역방향 탐색으로도 수를 찾아야 하기 때문이다.
                // 8방향으로 탐색하는 문제인 줄 알았는데, 등차를 이용해 탐색하는 문제였음
                for (int dr = -(n - 1); dr < n; dr++) {
                    for (int dc = -(m - 1); dc < m; dc++) {
                        if (dr == 0 && dc == 0) {
                            // 한 자리 숫자만 체크
                            int digit = table[y][x];
                            if (isPerfectSquare(digit)) {
                                ans = Math.max(ans, digit);
                            }
                            continue;
                        }

                        int ny = y, nx = x;
                        int num = 0;
                        while (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                            num = num * 10 + table[ny][nx];
                            if (isPerfectSquare(num)) {
                                ans = Math.max(ans, num);
                            }
                            ny += dr;
                            nx += dc;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        long s = (long) Math.sqrt(num);
        return s * s == num || (s + 1) * (s + 1) == num;
    }
}
