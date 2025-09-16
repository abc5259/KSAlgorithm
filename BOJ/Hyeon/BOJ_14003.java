package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        int[] tracking = new int[N];

        for (int i = 0; i < N; i++) {
            int hi = lowerBound(lis, A[i]);

            if (hi == lis.size()) {
                lis.add(A[i]);
            } else {
                lis.set(hi, A[i]);
            }
            tracking[i] = hi;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        int idx = lis.size() - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (tracking[i] == idx) {
                stack.push(A[i]);
                idx--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis.size()).append("\n");

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.print(sb);
    }

    static int lowerBound(List<Integer> lis, int var) {
        int lo = -1;
        int hi = lis.size();

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (lis.get(mid) >= var) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }
}
// P5 가장 긴 증가하는 부분 수열 5 이분탐색 LIS 역추적
// 일단 가장 긴 증가하는 부분 수열 2나 3이랑 비슷한 문제에다가 역추적만 더했다
// lowerBound 이기 때문에 FFFF ...TTT에서 가장 첫번째 T를 반환한다
// 근데 lo가 -1 이고 hi 가 size 이기 때문에 T는 hi가 되어야 한다 lo 는 F까지 이기 때문
// 그래서 원래같으면 lowerBound 에서 hi를 통해 lis 리스트에 넣었는데
// 이제는 hi를 리턴하는 lowerBound 를 통해서 메소드 바깥에서 리스트에 작업한다.
// 역추적
// 그리고 이때 tracking 배열을 통해서 각 숫자에 해당하는 인덱스를 정한다
// hi에 대한 인덱스 값을 tracking 배열에 저장해서 lis.size -1 인 인덱스가 가장 크기 때문ㅇ
// N만큼 반복문에서 idx 라는 변수를 따로둬서 역추적되는 값을 순서대로 stack에 넣어서
// 이를 꺼내면서 선입 후출로 StringBuilder 에 출력한다.