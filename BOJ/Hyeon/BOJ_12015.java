package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            lowerBound(lis, A[i]);
        }
        System.out.println(lis.size());
    }

    static void lowerBound(List<Integer> lis, int var) {

        int lo = -1;
        int hi = lis.size();

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (lis.get(mid) >= var) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (hi == lis.size()) {
            lis.add(var);
        } else {
            lis.set(hi, var);
        }
    }
}
// G2 가장 긴 증가하는 부분 수열 2 이분탐색 LIS
// LIS 를 이때까지 계속해서 DP 로만 풀었는데 그건 시간복잡도가 N^2 인데 지금은 N이 100만으로 주어져서
// 시간초과 때문에 이분탐색으로 처음 풀었다
// LIS 이분탐색은 LIS 배열을 만들어서 이를 이분탐색해서 삽입하는 구조이다.
// 근데 lis 배열의 이분탐색 해야되는데 사이즈를 N으로 둬도되지만 그냥 size 변수를 안쓰기 위해서 그리고 동적으로 관리하기 위해서
// ArrayList 를 썻다. 그래서 숫자마다 lowerBound 를 통해서 lis 배열에 입력한다.
// 일단 lowerBound 라서 lo 를 -1로 둔다 이상으로 판단하는데 lo 가 0이 되면 hi는 무조건 1까지 밖에 안돼서 hi가 0이 되는 경우도 고려해서 -1로 lo 를 만들고
// hi는 size 로 해서 늘려나간다
// 이때 hi 랑 size 랑 같다는건 list 의 수가 다 작다는 거라서 그냥 맨끝에 add 해주고 아니면
// set 으로 hi 인덱스의 값을바꿔준다.