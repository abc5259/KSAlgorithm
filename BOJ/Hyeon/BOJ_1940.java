package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1940 {
    private static final int LIMIT = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        boolean[] numbers = new boolean[LIMIT];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            numbers[num] = true;
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (M - arr[i] > 0 && M - arr[i] < LIMIT && M - arr[i] > arr[i]) {
                if (numbers[M - arr[i]]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
// S4 주몽 카운팅 배열
// 19분
// 내생각에 두수의 합이 M 이 되면 되는거고 N의 범위는 15000으로 O(N^2) 는 시간초과
// 카운팅 배열으로 접근 아니면 HashSet 도 가능
// 이게 M은 1000만까지 가능한데 고유한 num은 10만이 맥스라서 문제가 좀 이상했지만
// arr 배열이 주어진 고유한 번호들이고 numbers가 배열 체크에 대해서 사용
// M 과 arr[i] 에 대한 범위 체크부터 해야된다..인덱스에 아웃오브 바운즈 발생시킴
// 고유한 값은 중복되면 안되기에 만약 10이 M일때 arr[i] 가 5이면 뺄셈도 참으로 접근해서 조건을 걸었다