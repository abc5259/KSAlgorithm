package BOJ.GiSeok.Java;

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

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int jari = Integer.parseInt(br.readLine());

        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = jari - 1; i >= 0; i--) sum += (int) (Integer.parseInt(st.nextToken()) * Math.pow(a, i));

        Deque<Integer> stk = new ArrayDeque<>();
        while (sum > 0) {
            stk.push(sum % b);
            sum /= b;
        }

        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
    }
}


// 2 16
// 0 ~ 16 -> 16
// 1 0 ~ 16 -> 32개
// 2 0 ~ 16 -> 48개 ===> 17^1 * 2 + 17^0 * 16 = 34 + 16 = 50
// 2 16

// 50 / 8 = 6
// 나머지 2

// == 6 2

// 2 -> 10 => 0011 -> 2^0 + 2^1 = 3
// 10 -> 2 ==> 계속 2로 나눔

// 0 0 1 2 3 4 5 6 7
// 1 0 1 2 3 4 5 6 7
// 2 0 1 2 3 4 5 6 7
// 3 0 1 2 3 4 5 6 7
// 0 ~ 7 -> 7
// 1 0 ~ 7 -> 14
// 2 0 ~ 7 -> 21
// 3 0 ~ 7 -> 28
// 4 0 ~ 7 -> 35
// 5 0 ~ 7 -> 42
// 6 0 ~ 7 -> 6 0 43
// 6 1 44 6 2 45
