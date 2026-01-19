package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int res = -1;
            for (int k = x; k <= getLCM(M, N); k += M) {
                int tmp = k % N == 0 ? N : k % N;

                if (tmp == y) {
                    res = k;
                    break;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static int getLCM(int a, int b) {
        int mul = a * b;
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return mul / a;
    }
}
// S1 카잉 달력 구현
// 1시간
// trouble
// 이게 풀 수는 있엇는데  M 과 N이 4만이라서 서로소 고려하면 16억번 연산이다 나는 4만 4만 고려해서 4만번이라고 생각했는데
// 그래서 1년씩 빼면서 접근했엇는데 1:1이 될때까지 근데 저거는 x 랑 y 가 1:1 되는게 33번째인데
// 33번째에는 M mod 연산 x랑 N mod 연산 y 가 같은 33이다. 그래서 k 를 구하기 위해서
// M을 반복적으로 더하면서 이게 N의 모드연산과 같으면 탈출했다.
// 근데 이게 최소공배수 이상은 다시 반복되기때문에 그 사이에 공통적인 k 가 없다면 -1을 출력한다.