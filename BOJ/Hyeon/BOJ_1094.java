package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int cnt = 0;

        while (x > 0) {
            x = x & (x - 1);
            cnt++;
        }
        System.out.println(cnt);
    }
}
// S5 막대기 비트마스킹 복습
// 30분
// 쉬프트 연산과 비트마스킹을 썼는데 이러면 무조건 1자리가 남을 때까지 해야된다
// 그래서 브라이언 커니핸 알고리즘으로 이진수에서 1로 설정된 비트의 갯수를 구한다
// 이는 borrow 의 원리를 통해서 원래값에서 -1 한 값과 and 비트 연산을 한 후
// x 에 그것을 대입하면 1이 사라진다 이를 반복하면된다
// 맨 뒤에 1이 있으면 그냥 1이 사라지는 것이고 그 앞에 1이 있다면
// 빌림으로 통해 1이 없어진다.