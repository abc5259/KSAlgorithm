package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] times = new int[C + 1][3];
        st = new StringTokenizer(br.readLine());
        int prior = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (times[num][0] == 0) {
                times[num][1] = prior++;
                times[num][2] = num;
            }
            times[num][0]++;
        }
        Arrays.sort(times, (o1, o2) -> {
            if (o2[0] == o1[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        for (int i = 0; i <= C; i++) {
            if (times[i][0] != 0) {
                for (int j = 0; j < times[i][0]; j++) {
                    System.out.print(times[i][2] + " ");
                }
            }
        }
    }
}

// S3 빈도 정렬 해시
// 메모리 초과났음 왜냐하면 C가 10억까지 되니까 인트 인덱스가 수도 없이 커짐 그래서 숫자를 인덱스로 관리하면안된다.