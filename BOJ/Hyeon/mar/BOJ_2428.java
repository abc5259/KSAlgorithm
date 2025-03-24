package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2428 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] files = new int[N];
        for (int i = 0; i < N; i++) {
            files[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(files);
        long cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            cnt += lowerBound(files, i);
        }
        System.out.println(cnt);
    }

    private static int lowerBound(int[] arr, int idx) {
        int lo = idx;
        int hi = arr.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (arr[idx] >= arr[mid] * 0.9) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo - idx;
    }
}

// S3 표절 이분탐색
// 일단 어려운데도 풀긴 했는데,,, file 에 있어서 본인보다 큰애들만 비교하기 위해서 오름차순 정렬하고 앞에서 부터 1개씩 가져와서
// 뒤와 비교할 때 다음 파일의 0.9배 크기보다 클 경우 계속해서 lo 를 오른쪽으로 민다.
// 밀고나서 본인의 0.9보다 작은거면 멈춰서 시작한 idx 부터 lo 까지의 허용된 인수가 개수를 반환한다.
// 풀기는 했는데 너무 직관적으로 풀었다.