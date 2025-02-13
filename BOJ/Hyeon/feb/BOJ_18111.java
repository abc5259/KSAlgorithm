package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];

        int min = 256;
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, ground[i][j]);
                max = Math.max(max, ground[i][j]);
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;

        for (int k = min; k <= max; k++) {
            int block = B;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ground[i][j] > k) {
                        cnt += ((ground[i][j] - k) * 2);
                        block += (ground[i][j] - k);
                    } else {
                        cnt += (k - ground[i][j]);
                        block -= (k - ground[i][j]);
                    }
                }
            }
            if (block < 0) {
                break;
            }
            if (cnt <= time) {
                time = cnt;
                height = k;
            }
        }
        System.out.println(time + " " + height);
    }
}
// S2 마인크래프트
// 모든 경우를 따져봐야 하는 브루트포스
// 반복문을 통해 2차원 배열로 형성하고 최소값과 최대값을 구한다 이를 활용하여 높이를 구한다.
// 최소값보다 더 낮은 높이는 시간이 더 걸리기 때문에 못해도 최소값보다는 높은 높이를 나타낸다.
// 최소값일 때는 일단 다 빼기 때문에 인벤토리가 모자르지 않는데,
// 층을 올리면서 시간도 줄어든다. 왜냐? 제거하는거보다 꺼내쓰는게 더 빠르기 때문에
// 그래서 층을 올리면 시간이 줄어드는데, 인벤토리가 모자르면 그전값이 최소 시간이다.

// troubleshooting : if(cnt <= time)에서 =를 빼었더니 틀렸다. 이유는?