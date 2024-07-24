/**
 * 12869 - 뮤탈리스크 [실패]
 * 골드4, BFS
 * 
 * v1, v2, v3 3차원 정점으로 방향에 따라 1, 3, 9로 항상 가중치가 동일한 그래프 문제였음.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_12869 {
    // 시간제한 2초
    // 수빈이 뮤탈1개, 강호 SCV N개
    // 1. 첫 번째로 공격받은 SCV 체력 -9
    // 2. 두 번째 SCV -3
    // 3. 세 번째 SCV -1
    // 남아있는 SCV의 체력이 주어졌을 때, 모든 SCV를 파과하기 위해 공격해야 하는 횟수의 최솟값.

    // 1 <= N <= 3
    // 1 <= 체력 <= 60

    // 순열? x
    // BFS

    static int N;
    static int v1, v2, v3;
    static int[][][] hp = new int[61][61][61];
    static int[][] atk = {{1, 3, 9},
                          {1, 9, 3},
                          {3, 1, 9},
                          {3, 9, 1},
                          {9, 1, 3},
                          {9, 3, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        if (N >= 2) v2 = Integer.parseInt(st.nextToken());
        if (N >= 3)v3 = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(v1);
        q.add(v2);
        q.add(v3);
        hp[v1][v2][v3] = 0;

        while (!q.isEmpty()) {
            int q1 = q.poll();
            int q2 = q.poll();
            int q3 = q.poll();

            System.out.println("x: " + q1 + ", y: " + q2 + ", z: " + q3 + ", : " + hp[q1][q2][q3]);

            if (q1 == 0 && q2 == 0 && q3 == 0) break;
            for (int i = 0; i < 6; i++) {
                int nv1 = Math.max(0, q1 - atk[i][0]);
                int nv2 = Math.max(0, q2 - atk[i][1]);
                int nv3 = Math.max(0, q3 - atk[i][2]);

                if (hp[nv1][nv2][nv3] > 0) continue; // 이게 없으면 nv1, nv2, nv3이 0 0 0인 경우가 여러 번 나올때 그 값으로 바뀔 수 있다.
                hp[nv1][nv2][nv3] = hp[q1][q2][q3] + 1;
                q.add(nv1);
                q.add(nv2);
                q.add(nv3);
            }
        }

        System.out.println(hp[0][0][0]);
    }
}
