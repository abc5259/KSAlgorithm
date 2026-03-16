package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            StringBuilder s = new StringBuilder();
            char front = ' ';
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                char w = st.nextToken().charAt(0);
                if (i == 0) {
                    front = w;
                    s.append(w);
                } else {
                    if (front >= w) {
                        front = w;
                        s.insert(0, w);
                    } else {
                        s.append(w);
                    }
                }
            }
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
// S3 카드 문자열 그리디
// 23분
// 아 계속 오류 고민했는데 그냥 조건이 1개였다.
// 맨앞보다 작을때만 최산화 하고 계속 맨뒤에 넣어야됨
// 가장 왼쪽과 오른쪽만 넣을 수 있다길래 Deque 을 구상해서 자료구조 쓰려고 했는데
// 그러면 또 자료구조에서 꺼내서 String을 만들어야 되게 그냥 가변 객체 써서 앞뒤로 붙인다음에 이를
// sb 로 배정했다.