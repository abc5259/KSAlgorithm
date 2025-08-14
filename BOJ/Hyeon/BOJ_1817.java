package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        int[] books = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        int tmp = M;
        for (int i = N - 1; i >= 0; i--) {
            if (books[i] <= tmp) {
                tmp -= books[i];
            } else {
                tmp = M - books[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
// S5 짐 챙기는 숌 그리기
// 쉽게 풀었다. 그리디라는 조건은 무조건 cnt 를 1개로 잡고 그리고 책으로 되어있기 때문에
// 스택과 큐와 같이 순차적으로만 빼야하기때문에 그냥 배열을 써서
// 뒤에서 부터 차감시켰고 또 tmp 의 값보다 책이 더 크면 이때 tmp 를 다시 M으로 초기화 시킨다음에
// 갯수를 늘리는 식으로 반복해서 쉽게 풀었다.