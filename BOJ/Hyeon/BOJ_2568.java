package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Line[] lines = new Line[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            lines[i] = new Line(A, B);
        }
        Arrays.sort(lines);

        List<Integer> lis = new ArrayList<>();

        int[] tracking = new int[N];

        for (int i = 0; i < N; i++) {
            int var = lines[i].B;
            int hi = lowerBound(lis, var);

            if (hi == lis.size()) {
                lis.add(var);
            } else {
                lis.set(hi, var);
            }
            tracking[i] = hi;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        int idx = lis.size() - 1;

        for (int i = N - 1; i >= 0; i--) {
            if (tracking[i] == idx) {
                idx--;
            } else {
                stack.push(lines[i].A);
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(N - lis.size()).append("\n");

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append("\n");
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

    static class Line implements Comparable<Line> {
        int A;
        int B;

        public Line(int a, int b) {
            A = a;
            B = b;
        }

        @Override
        public int compareTo(Line o) {
            return this.A - o.A;
        }
    }
}
// P5 전깃줄 - 2 이분탐색 LIS 역추적
// 일단 Line 이라는 클래스 타입 만들어서 전깃줄만의 배열을 만들었다 그리고
// 이게 꼬인것들을 구하는거기때문에 A를 오름차순으로해서 Comparable를 구현하고 B 만 가지고 LIS 를 만들면된다.
// lis 리스트에는 B의 값으로만 가지고 이분 탐색으로 가장 긴 증가하는 부분 수열 처럼
// 나보다 작은 수 가 있는지 없는지로 판단해서 움직인다.
// 그리고 tracking 배열을 통해 역추적한다 이는 hi 라는 인덱스 값을 저장하는 배열로
// N의 크기만큼 한다음에 최종적으로 역추적 시
// lis.size - 1 의 인덱스부터 시작해서 이 값이 있으면 증감식으로 해서 idx 와 같은지를 확인하고 같다면 idx만 감소시켜버리고
// 안 같다면 이를 stack 에 넣어서 역으로 출력되게 하면된다.
