package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2776 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringBuilder sb = new StringBuilder();

            N = Integer.parseInt(br.readLine());

            arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int var = Integer.parseInt(st.nextToken());
                sb.append(binarySearch(var)).append("\n");
            }

            System.out.print(sb);
        }
    }

    static int binarySearch(int var) {
        int lo = 0;
        int hi = N - 1;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (arr[mid] >= var) {
                hi = mid;
            } else {
                lo = mid;
            }

        }
        if (arr[lo] == var || arr[hi] == var) {
            return 1;
        }
        return 0;
    }
}
// S4 암기왕 이분탐색
// 17분
// 그냥 풀었다 왜냐하면 N 이랑 M 이 둘다 100만이라서 시간초과를 야기하기 때문에
// NlogN + Mlog N 으로 풀었다.
// 이게 그냥 arr 라는 배열을 정렬을 한다음에 M 개의 숫자를 이분 탐색한다
// 근데 lowerBound 형태로 접근한 다음에 if 조건 분기를 통해 1이나 0을 리턴받고
// StringBuilder 는 매 T 마다 객체가 생성되어야 하기 때문에 이를 조심해야된다.