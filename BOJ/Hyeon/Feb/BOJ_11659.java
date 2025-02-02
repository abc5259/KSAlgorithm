package BOJ.Hyeon.Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            long sum = arr[j] - arr[i - 1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
// 구간 합 구하기4
// 시간초과 관련해서 고민을 해봤다. 근데 i랑 j를 가지고 배열을 접근하면 시간복잡도가 10^2이 돼서 시간초과가 된다.
// 이때 누적합을 활용하여 1부터 3까지의 합은 누적합을 통해 3까지의 합을 3인덱스가 가지고 1부터 시작하니까 0의 값을 뺀다.
// 똑같이 2~4의 값은 4까지의 누적합에서 1을 빼야하기때문에 i-1을 빼준다.