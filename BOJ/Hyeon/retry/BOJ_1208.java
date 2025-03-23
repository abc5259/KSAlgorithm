package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int middle = N / 2;

        ArrayList<Integer> left = new ArrayList<>();
        for (int i = 0; i < (1 << middle); i++) {
            int value = 0;
            for (int j = 0; j < middle; j++) {
                if ((i & (1 << j)) != 0) {
                    value += arr[j];
                }
            }
            left.add(value);
        }
        Collections.sort(left);

        long res = 0;

        for (int i = 0; i < (1 << (N - middle)); i++) {
            int value = 0;
            for (int j = 0; j < N - middle; j++) {
                if ((i & (1 << j)) != 0) {
                    value += arr[j + middle];
                }
            }
            res += upperBound(left, S - value) - lowerBound(left, S - value);
        }
        if (S == 0) {
            res--;
        }
        System.out.println(res);
    }

    private static int lowerBound(ArrayList<Integer> arr, int x) {
        int lo = -1;
        int hi = arr.size();

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (arr.get(mid) >= x) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }

    private static int upperBound(ArrayList<Integer> arr, int x) {
        int lo = -1;
        int hi = arr.size();

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (arr.get(mid) > x) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }
}

// G1 부분수열의 합2 이분탐색 + 중간에서 만나기
// 어제 풀었던 중간에서 만나기를 또 풀었다. 일단 주어지는 시간복잡도가 40이고 부분집합의 합이므로 2^40으로 1초를 초과한다
// 그래서 2*2^20으로 만들어서 했다 한 수열을 2부분으로 나누어서 부분집합의 합을 구했다
// 비트 마스킹으로 1<< 집합의 원소 개수로 크기를 만든다음
// 해당 인덱스가 있는지에 대해서 i와 1<<j의 AND 연산을 통해 원소의 유무를 판별하였다.
// 그리고 요구되는 숫자가 있는지에 대해서 정렬한 왼쪽 수열에 오른쪽 값을 이분탐색으로 찾는다
// 갯수를 반환하기에 upperbound -lowerbound 를 하였다.
// 그리고 S가 0일 때는 공집합도 연산에 합산되어서 -1을 해줬다.