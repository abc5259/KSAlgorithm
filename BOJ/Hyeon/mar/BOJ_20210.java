package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_20210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] files = new String[N];

        for (int i = 0; i < N; i++) {
            files[i] = br.readLine();
        }

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = 0, j = 0;

                while (i < o1.length() && j < o2.length()) {
                    char c1 = o1.charAt(i);
                    char c2 = o2.charAt(j);

                    boolean num1 = isNum(c1);
                    boolean num2 = isNum(c2);

                    // 둘 다 숫자
                    if (num1 && num2) {
                        int start1 = i, start2 = j;

                        while (i < o1.length() && isNum(o1.charAt(i))) i++;
                        while (j < o2.length() && isNum(o2.charAt(j))) j++;

                        String numStr1 = o1.substring(start1, i);
                        String numStr2 = o2.substring(start2, j);

                        // 앞에 붙은 0의 개수 세기
                        int zeroCount1 = countZero(numStr1);
                        int zeroCount2 = countZero(numStr2);

                        // 앞 0을 제거한 숫자 비교
                        numStr1 = numStr1.substring(zeroCount1);
                        numStr2 = numStr2.substring(zeroCount2);

                        // 숫자 크기 비교
                        if (numStr1.length() > numStr2.length()) {
                            return 1;
                        }
                        if (numStr1.length() < numStr2.length()) {
                            return -1;
                        }

                        // 숫자의 길이가 같은 경우
                        int cmp = numStr1.compareTo(numStr2);
                        if (cmp != 0) {
                            return cmp;
                        }

                        // 0을 제외한 숫자가 같을 때
                        if (zeroCount1 != zeroCount2) {
                            return zeroCount1 - zeroCount2;
                        }
                        continue;
                    }

                    // 숫자 vs 문자 비교
                    if (num1) {
                        return -1;
                    }

                    if (num2) {
                        return 1;
                    }

                    // 같은 문자일 경우 다음 문자 비교
                    if (c1 == c2) {
                        i++;
                        j++;
                        continue;
                    }

                    // 대소문자 구분
                    boolean upper1 = isUpper(c1);
                    boolean upper2 = isUpper(c2);

                    int normalizedC1 = upper1 ? c1 - 'A' : c1 - 'a';
                    int normalizedC2 = upper2 ? c2 - 'A' : c2 - 'a';

                    // 대소문자 무시한 비교
                    if (normalizedC1 != normalizedC2) return normalizedC1 - normalizedC2;

                    // 대소문자가 다르고 같은 문자일 경우 대문자가 먼저 오도록
                    return upper1 ? -1 : 1;
                }

                // 길이가 다르면 더 짧은 것이 먼저 온다.
                return Integer.compare(o1.length(), o2.length());
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String file : files) {
            sb.append(file).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }

    private static boolean isUpper(char c) {
        return 'A' <= c && c <= 'Z';
    }

    private static int countZero(String numStr) {
        int count = 0;
        while (count < numStr.length() && numStr.charAt(count) == '0') {
            count++;
        }
        return count;
    }
}

// G3 파일 탐색기 정렬
// 일단 여러가지의 조건을 순서대로 따르면 된다. 리트라이 필요
