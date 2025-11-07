package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17951 {
    static int N, K;
    static int[] solves;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int sum = 1;
        solves = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solves[i] = Integer.parseInt(st.nextToken());
            sum += solves[i];
        }

        System.out.println(binarySearch(sum));
    }

    static int binarySearch(int score) {
        int lo = 0;
        int hi = score;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (check(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    static boolean check(int var) {
        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            sum += solves[i];
            if (sum >= var) {
                cnt++;
                sum = 0;
            }
        }
        return cnt >= K;
    }
}
// G3 흩날리는 시험지 속에서 내 평점이 느껴진거야 이분탐색 + 그리디
// 26분
// 영광이다 뿌듯.
// 일단 먼저 풀이를 뜯어보자면 흩날린 시험지 에서의 순서대로 점수를 매겨서 그 값중 최소값을 시험점수로 처리해주는데
// 이때의 시험점수 중 가장 최대값을 구한다 -> 이거는 그냥 이분 탐색이다 왜냐하면
// TTTT FFFF 의 흐름으로 최소값중 최대값을 구하기 때문 그래서 이분 탐색을 떠올렸고 극단적으로
// 구간을 나누었을 때의 1이나 2같은 시험점수도 최소값으로 인지되지만 최대값이랑 거리가 멀기에 TTT 이고
// 이제 check 함수를 통해서 그리디로 이용하여 구간의 개수를 구하면된다
// 제공되는 mid 에 대한 점수보다 높은 점수의 합이 나오면 초기화 시키고 갯수를 증가시킨다음에 이를 통해서
// cnt 와 K의 비교를 할 때 1과 같은 초반의 var 이라고 따지면 여러개수가 나오기에 이를 return 으로 참값으로 만들고
// T면 더 오른쪽에 T가 있다고 생각하고 lo를 mid로 올려버린다. 이를 통해 T 중 가장 늦게 나오는 값이 정답 점수