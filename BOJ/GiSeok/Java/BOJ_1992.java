/**
 * 1992 - 쿼드트리 [성공|00:27:48]
 * 실버1, 분할정복, 시도2
 *
 * 범위 내에 수가 모두 같지않으면 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래로 나눠서
 * 범위 내의 수가 모두 같은지 검사하는 행동을 반복한다.
 * 중요한 것은 나눌때마다 괄호를 친다는 점.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
    // 1: 검은 점
    // 0: 흰 점
    // 주어진 영상이 모두 0으로만 되어 있으면 압축 결과 = 0
    // 주어진 영상이 모두 1으로만 되어 있으면 압축 결과 = 1
    // 4/1로 계속 나눈다. 왼쪽 위, 아래|오른쪽 위, 아래

    static int[][] map;
    static int N;
    static String ret = "";

    static class Pair {
        int x, y;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void zip(int n, Pair p) {

        int flag = map[p.y][p.x];
        for (int y = p.y; y < p.y + n; y++) {
            for (int x = p.x; x < p.x + n; x++) {
                if (flag != map[y][x]) { flag = -1; break; }
            }
        }

        if (flag != -1) {
            ret += map[p.y][p.x];
            return;
        }

        ret += "(";
        zip(n/2, new Pair(p.y, p.x)); // 왼 위
        zip(n/2, new Pair(p.y, p.x + (n/2))); // 오 위
        zip(n/2, new Pair(p.y + (n/2), p.x)); // 왼 아래
        zip(n/2, new Pair(p.y + (n/2), p.x + (n/2))); // 오 아래
        ret += ")";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++)
                map[i][j] = s.charAt(j) - '0';
        }

        // logic
        zip(N, new Pair(0, 0));
        System.out.println(ret);
    }
}
