package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830 {
    final static int MOD = 1_000;
    static int[][] origin;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        origin = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] a : pow(origin, B)) {
            for (int num : a) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int[][] pow(int[][] arr, long b) {
        if (b == 1L) {
            return arr;
        }
        int[][] tmp = pow(arr, b / 2);

        tmp = multiply(tmp, tmp);

        if (b % 2 == 1L) {
            tmp = multiply(multiply(tmp, tmp), origin);
        }
        return tmp;
    }

    static int[][] multiply(int[][] arr, int[][] brr) {
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                for (int j = 0; j < N; j++) {
                    tmp[i][k] += arr[i][j] * brr[j][k];
                    tmp[i][k] %= MOD;
                }
            }
        }
        return tmp;
    }
}

// G4 행렬 제곱 분할정복
// 일단 기저사례를 b라는 지수가 1일때 바로 입력된 origin 배열을 반환해야되고 origin 배열을 초기화활 때 이미
// mod 연산을 해둬야 한다.
// 그리고 나서 행렬간 곱셈을 하는 multiply 메소드를 만들어서 int[][] 로 리턴받게 한다.
// 그러면 처음에 origin 배열과 지수가 들어갈 것이고 지수를 /2 해서 재귀호출을 해서 재귀호출된 결과 2차원 배열과 연산해서
// 다시 2차원 배열을 뱉어내는 함수를 사용해서 최종적인 2차원 배열을 반환한다
// 근데 만약에 b라는 지수가 홀수 일경우 /2 제곱 * 1개짜리로 곱해야 되는데 1개짜리를 기억해둬야되기 때문에 이때 사용되는건
// origin 이라는 정적변수를 사용한다. arr은 변화에 적응된 배열이다
// trouble shooting
// TLE 발생 이유
// 재귀를 2번이나 호출해서 틀렸다 나는 당연하게 /2로 나눠서 재귀를 각각 해줬는데
// tmp 라는 변수로 빼지않고 tmp 에다가 multiply 내에 재귀를 2번이나 썼다. 값만 가지고 썻어도 됐었는데
// 괜하게 재귀를 2번이나 해서 시간초과를 발생시켰다.
// 원래도 값을 저장해둬서 값간에 연산을 했었는데