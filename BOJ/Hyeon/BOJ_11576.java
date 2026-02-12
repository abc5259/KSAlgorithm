package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        int ten = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());
            ten = ten * A + value;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        while (ten > 0) {
            stack.push(ten % B);
            ten /= B;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
// S5 Base Conversion 구현
// 40분
// 문제 이해만 20분 걸림 걍 A 진법의 숫자로 입력된 값을 m 을 감소시키면서 Math.pow 연사능로
// ten 이라는 십진수 값으로 가진다 그리고 stack 을 통해 1의 자리 부터 한다음에
// B 진법으로 ten 을 변환한다
// 이를 통해서 stack 에 넣어지고 stack에서 1개 씩 빼서 값을 출력한다.
// 개선
// 호너의 방식으로 A -> 10 을 Math.pow 가 아닌 ten * A + value 로 접근해서
// value 를 계속해서 A 를 곱하게 했다. 누적된다 이의 곱은
// 그리고 10 -> B 또한 ten % B 하고 이를 나눈값을 가지게 해서 각 자리수를 처리했다.