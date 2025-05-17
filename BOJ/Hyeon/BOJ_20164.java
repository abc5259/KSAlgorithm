package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20164 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        cutting(str, 0);
        System.out.println(min);
        System.out.println(max);
    }

    private static void cutting(String str, int total) {
        int len = str.length();
        if (len == 1) {
            if (isValid(str.charAt(0))) {
                total++;
            }
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }
        if (len == 2) {
            if (isValid(str.charAt(0))) {
                total++;
            }
            if (isValid(str.charAt(1))) {
                total++;
            }
            int sum = (str.charAt(0) - '0') + (str.charAt(1) - '0');
            cutting(String.valueOf(sum), total);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (isValid(str.charAt(i))) {
                total++;
            }
        }

        for (int i = 1; i <= len - 2; i++) {
            for (int j = i + 1; j <= str.length() - 1; j++) {
                int sum1 = Integer.parseInt(str.substring(0, i));
                int sum2 = Integer.parseInt(str.substring(i, j));
                int sum3 = Integer.parseInt(str.substring(j));
                cutting(String.valueOf(sum1 + sum2 + sum3), total);
            }
        }
    }

    static boolean isValid(char c) {
        int num = c - '0';
        return num % 2 == 1;
    }
}
// G5 홀수 홀릭 호석 재귀
// 재귀로 조건을 나눠서 반복해서 요청하고 매개변수로 관리하고
// 1개의 조건일 때 최종으로 기저조건을 발휘해서 리턴받는다.