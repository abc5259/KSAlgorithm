package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17829 {
    static int[][] cnn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        cnn = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cnn[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(pooling(0, 0, N));


    }

    static int pooling(int y, int x, int N) {
        if (N == 2) {
            int idx = 0;
            int[] tmp = new int[4];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    tmp[idx++] = cnn[y + i][x + j];
                }
            }
            Arrays.sort(tmp);
            return tmp[2];
        }

        N /= 2;

        int[] arr = new int[4];

        arr[0] = pooling(y, x, N);
        arr[1] = pooling(y, x + N, N);
        arr[2] = pooling(y + N, x, N);
        arr[3] = pooling(y + N, x + N, N);

        Arrays.sort(arr);
        return arr[2];
    }
}
// S3 222-풀링 분할정복
// 35분
// 분할정복 오랜만에 푸니까 감을 잃었다.
// 일단 4사분면으로 나눠서 생각해야되고 2 X 2 사각형에서 2번째로 큰수를 리턴 해야된다
// 그래서 기저 조건을 N을 2로 했고 2로 기저 사례로 진입했을 때
// 4개의 원소 정렬 O(1) 을 통해서 2번째로 큰수를 리턴 받고 탈출하고 나와서 arr[1] arr[2] 등을 진행하여 최종적으로는
// arr 배열의 Arrays.sort 를 통해서 원하는 arr[2] 의 값을 리턴받을 수 있다.