/**
 * 5430 - AC [성공(반례힌트)|02:03:29]
 * 골드5, 구현, 시도7
 * 
 * 미친 문제다.
 * 처음에 R마다 직접 큐를 뒤집었다. 근데, 이게 상당히 비효율적인 방법이다.
 * 왜냐면 어차피 ArrayDeque라서 양옆으로 add, poll 할 수 있기 때문이다.
 * 그래서 이로 인한 시간 초과를 줄이기 위해서 R을 만날때마다 뒤집어졌는지를 판단하는 boolean 변수를 선언하였고,
 * D를 만났을 때 이 변수에 따라 뒤집어졌다면 반대로 pop(), 아니라면 정상적으로 pop() 하는 로직으로 바꾸었다.
 * 
 * 그리고, 그냥 숫자 구분없이 입력된 배열 정수들을 그대로 담아서 사용했는데,
 * [12,3,4] 와 같이 한 자리 수가 아닌 두 자리 수가 들어오면 뒤집어서 출력 시에 [4,3,21]과 같은 상황이 발생했다.
 * 그래서 그냥 숫자로 ArrayDeque에 넣어서 해결했다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class BOJ_5430 {
    // 시간제한 1초, 메모리제한 256MB
    // AC는 정수 배열에 연산을 하기 위해 만든 언어
    // 두 가지 함수 R(뒤집기), D(버리기)
    // R은 배열의 수의 순서를 뒤집는다.
    // D는 첫 번째 수를 버린다.
    // 배열이 비어있을 때 D ==> 에러

    // 테케 T <= 100
    // p <= 100,000 (수행할 함수)
    // 0 <= n <= 100,000 (배열 길이)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            String p = br.readLine();

            int n = Integer.parseInt(br.readLine());
            String num = br.readLine();
            String s = "";
            for (int i = 1; i < num.length(); i++) {
                if (num.charAt(i) != ']' && num.charAt(i) != ',') {
                    s += num.charAt(i);
                } else {
                    if (s.length() != 0) q.add(Integer.parseInt(s));
                    s = "";
                }
            }
            
            boolean isreverse = false;
            boolean flag = false;
            for (int idx = 0; idx < p.length(); idx++) {
                char op = p.charAt(idx);

                if (q.isEmpty()) {
                    if (op == 'D') flag = true;
                } else if (op == 'R') {
                    if (n >= 2) isreverse = !isreverse;
                } else if (op == 'D') {
                    if (!isreverse)
                        q.pop();
                    else
                        q.pollLast();
                }
            }

            if (flag) bw.write("error");
            else {
                bw.write('[');
                while (!q.isEmpty()) {
                    if (!isreverse) bw.write(q.poll() + "");
                    else bw.write(q.pollLast() + "");

                    if (q.size() < 1) continue;
                    bw.write(',');
                }
                bw.write(']');
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
