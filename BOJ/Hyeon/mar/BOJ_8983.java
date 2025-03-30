package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8983 {
    static int L; // binary 에서 쓰기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] saro = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            saro[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(saro); // 사로를 이분탐색

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (lowerBound(saro, x, y)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean lowerBound(int[] arr, int x, int y) {
        int lo = -1;
        int hi = arr.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (Math.abs(arr[mid] - x) + y <= L) {
                return true;
            }
            if (arr[mid] >= x) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return false;
    }
}

// G4 사냥꾼 이분탐색
// 사로를 이분 탐색해서 동물을 대입하고 사로를 움직여서 정확한 조건을 통과할경우 true를 반환하고 아니면 flase를 반환 근데
// 동물을 반복해서 대입하기 때문에 동물을 2차원 배열로 만들지 않고 그냥 x와 y 값으로 대입해서 lowerbound 한다.
// lowerbound는 사로보다 작거나 같은 x를 구하기 때문이다.
// 이렇게 이분탐색으로 접근해야 N * log M 이 가능하다 N*M 일 경우 10만 ^2 이기에 시간초과 발생한다.
// 그리고 이분탐색해서 매번 인덱스나 값을 반환했지만 boolean 타입으로 리턴하고 탈출 조건에 맞을 경우 탐색할 수 있게 적용 가능했다.
// lower bound의 의미인 lo = -1, hi = length 이다.