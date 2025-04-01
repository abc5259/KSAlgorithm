package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] guitars = new String[N];

        for (int i = 0; i < N; i++) {
            guitars[i] = br.readLine();
        }

        Arrays.sort(guitars, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    if (getSum(s1) == getSum(s2)) {
                        return s1.compareTo(s2);
                    }
                    return getSum(s1) - getSum(s2);
                }
                return s1.length() - s2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String guitar : guitars) {
            sb.append(guitar).append("\n");
        }
        System.out.println(sb);
    }

    public static int getSum(String str) {
        int sum = 0;
        char[] c = str.toCharArray();
        for (char c1 : c) {
            if ('0' <= c1 && c1 <= '9') {
                sum += c1 - '0';
            }
        }
        return sum;
    }
}

// S3 시리얼 번호 정렬
// 조건을 순차적으로 따르기만하면된다.
// 문자를 관리할 때 문자를 정수로 바꿀 때 -'0'을 써서 해야된다 그냥 아스키코드를 더하면 안된다.
