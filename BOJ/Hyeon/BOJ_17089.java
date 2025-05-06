package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int res = Integer.MAX_VALUE;

        boolean[][] friends = new boolean[N + 1][N + 1];
        int[] cnt = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            friends[A][B] = true;
            friends[B][A] = true;
            cnt[A]++;
            cnt[B]++;
        }

        for (int i = 0; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (friends[i][j]) {
                    for (int q = j + 1; q <= N; q++) {
                        if (friends[i][q] && friends[j][q]) {
                            int sum = cnt[i] + cnt[j] + cnt[q] - 6;
                            res = Math.min(res, sum);
                        }
                    }
                }
            }
        }
        if (res == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(res);
        }
    }
}

// G5 세 친구 브루트포스, 그래프
// 무방향 그래프로 했다. boolean 2차원 배열을 만들어서 친구간의 관계를 나타내었고 이를 무방향 그래프로 그렸을 때
// 삼각형이 생성되어야 3친구임을 확인할 수 있었다. 그래서 친구관계를 입력받아서 2차원 배열을 만들고
// A와 B가 친구관계 일 때 A와 C , B와 C가 친구이면 셋의 친구의 수 합산에서 -6(서로) 를 빼주면 값이 된다.

// for 문의 반복인데
/*
for (int i = 0; i < N; i++) {
  for (int j = 0; j < N; j++) {
    for (int k = 0; k < N; k++) {
      // O(1) 작업
    }
  }
} 다음의 시간복잡도는 항상 반복되기에 O(N^3)인데

for (int i = 0; i < N; i++) {
  for (int j = i+1; j < N; j++) {
    if (friends[i][j]) {        // 친구 관계인 경우에만
      for (int k = j+1; k < N; k++) {
        // O(1) 작업
      }
    }
  }
} 이때 친구관계는 M이고 N 만큼 반복해서 O(N^2 + M*N) 이 시간복잡도 이다.
*/