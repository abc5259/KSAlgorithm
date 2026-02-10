package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] world = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) world[i] = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 1; i < m-1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) left = Math.max(left, world[j]);
            for (int j = i+1; j < m; j++) right = Math.max(right, world[j]);

            if (world[i] < left && world[i] < right) {
                ans += Math.min(left - world[i], right - world[i]);
            }
        }

        System.out.println(ans);
    }
}

/**
 * 좌측 벽을 기준으로 크거나 같은 우측 벽을 찾아 그 사이에 빗물을 구하려고 했음.
 * 근데, 이게 말이 안되는게 5 4 1 3 1 2 와 같은 반례가 생김
 * 5보다 크거나 같지 않아도 3 1 2는 별도의 빗물을 가지게 된다.
 *
 * 그럼 어케 푸냐.
 * 빗물이 받아지는 장소를 기준으로 좌측과 우측 벽을 구함.
 * 위 예제에서 4를 기준으로 좌측에서 젤 큰 값은 5
 * 우측에서 젤 큰 값은 3
 * 4가 좌측, 우측 벽보다 작은가? No
 * 그럼 재낌
 *
 * 1을 기준으로 좌측 젤 큰 값 5
 * 우측 젤 큰 값 3
 * 1이 좌측, 우측 벽보다 작은가? YES
 * 그럼 이 장소에는 빗물이 고인다는 것.
 * 두 벽 중 작은 값을 기준으로 해당 장소의 빗물을 구하면 된다.
 *
 * 벽이라는 요소에 집중했는데, 빗물이 고이는 장소로 관점을 바꿨어야 했다.
 *
 */
