package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        while (S.length() != T.length()) {

            char last = T.charAt(T.length() - 1);

            T.deleteCharAt(T.length() - 1);
            if (last == 'B') {
                T.reverse();
            }
        }

        System.out.println(S.equals(T.toString()) ? 1 : 0);
    }
}
// G5 A와 B 그리디 복습
// 27분
// 복습 그리디 S -> T는 2의 1000승이다 가능한 경우의 수가 그래서 S에서 T로는 어떻게 가야되나 싶었는데
// T에서 S로 가게되면서 1방향만 가다보니 1000번 반복이라고 생각 O(2^1000) 에서 O(N)으로