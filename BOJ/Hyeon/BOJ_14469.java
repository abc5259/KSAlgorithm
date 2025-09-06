package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_14469 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int res = time[0][0];

        for (int i = 0; i < N; i++) {
            if (res < time[i][0]) {
                res = time[i][0];
            }
            res += time[i][1];
        }
        System.out.print(res);
    }
}
// S4 소가 길을 건너간 이유 3 그리디
// 그냥 쉽게 풀었다
// 도착 시간이 같을 경우 걸리는 시간을 오름차순으로 최소인 경우로 정렬을 한다음에
// 총 걸리는 시간을 구할 때
// 현재까지 내가 걸린 시간보다 그때의 소의 도착시간이 더 클경우 소의 도착 시간 기준으로 바꿔버리고
// 누적해서 걸리는 시간을 합산하면 된다.