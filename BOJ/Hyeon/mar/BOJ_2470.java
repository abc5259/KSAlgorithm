package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] liquids = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquids);

        int min = Integer.MAX_VALUE;
        int a = 0, b = 0;

        for (int i = 0; i < N; i++) {
            int target = -liquids[i];
            int j = lowerBound(liquids, target);

            if (i != j) {
                int sum = Math.abs(liquids[i] + liquids[j]);
                if (min > sum) {
                    min = sum;
                    a = liquids[i];
                    b = liquids[j];
                }
            }
        }

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.println(a + " " + b);
    }

    private static int lowerBound(int[] arr, int target) {
        int lo = -1;
        int hi = arr.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] >= target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (lo >= 0 && hi < arr.length) {
            if (Math.abs(arr[lo] - target) <= Math.abs(arr[hi] - target)) {
                return lo;
            } else {
                return hi;
            }
        }
        if (lo >= 0) {
            return lo;
        } else {
            return hi;
        }
    }
}

// G5 두 용액 이분 탐색
// 일단 이분 탐색문제로 생각해서 lower bound 를 사용했다. 그리고 생각해보면 두 용액의 합의 절댓값의 관계에 있어서
// 최소값을 구해야 되기 때문에 일단 target <= value[mid] 를 이용해서 큰 수중 가장 최소값 첫번 째를 이용한다.
// 근데 여기서 중요한 것은 lower 을 이용했더니 value[mid-1]< target 의 차이가 더 적게 나면 애써 만든 hi로 골라진 mid가 필요가 없어진다.
// 그래서 리턴할 때 이를 lo와 hi로 비교해서 적절한 인덱스를 넘겨주고
// 그 인덱스를 통해서 구한 용액의 합이 min일 때의 비교와 내가 마이너스로 target을 설정햇기 때문에 같은 값을 가져오면 안돼서
// i != j 를 했다.