package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20164 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cutting(br.readLine(), 0);
        System.out.println(min);
        System.out.println(max);
    }

    static void cutting(String str, int sum) {
        int len = str.length();

        if (len == 1) {
            if (isOdd(str.charAt(0) - '0')) {
                sum++;
            }
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        if (len == 2) {
            int a = str.charAt(0) - '0';
            int b = str.charAt(1) - '0';
            if (isOdd(a)) {
                sum++;
            }
            if (isOdd(b)) {
                sum++;
            }
            cutting(String.valueOf(a + b), sum);
            return;
        }
        for (int i = 0; i < len; i++) {
            if (isOdd(str.charAt(i) - '0')) {
                sum++;
            }
        }

        for (int i = 1; i <= len - 2; i++) {
            for (int j = i + 1; j <= len - 1; j++) {
                int a = Integer.parseInt(str.substring(0, i));
                int b = Integer.parseInt(str.substring(i, j));
                int c = Integer.parseInt(str.substring(j));
                cutting(String.valueOf(a + b + c), sum);
            }
        }
    }

    private static boolean isOdd(int n) {
        return n % 2 == 1;
    }
}

// G5 홀수 홀릭 호석 재귀
// 일단 주어진 값을 문자열로 입력하여서 str.chatAt으로 접근하여 연산하고
// 재귀마다 사용되는 sum 값은 파라미터로 넣어서 재귀가 반복문을 통해서 다시 호출될때마다 새값을
// 가지게끔 동작한다
// 길이가 1일때는 기저사례로 반복문 마다 탈출하는 거기때문에 이때
// sum 값을 max 와 min을 비교해서 저장해둔다.