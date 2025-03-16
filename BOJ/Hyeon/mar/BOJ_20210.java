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

                    // 둘다 숫자
                    if (num1 && num2) {
                        // 시작 인데스를 저장해두고 subString 할거다.
                        int start1 = i, start2 = j;
                        // 문자열의 숫자열의 끝 인덱스를 알아차려서
                        while (i < o1.length() && isNum(o1.charAt(i))) {
                            i++;
                        }
                        while (j < o2.length() && isNum(o2.charAt(j))) {
                            j++;
                        }
                        // 자른다.
                        String numStr1 = o1.substring(start1, i);
                        String numStr2 = o2.substring(start2, j);

                        // 숫자열의 0개수를 세서
                        int zeroCount1 = countZero(numStr1);
                        int zeroCount2 = countZero(numStr2);

                        // 0을 제외한 채로 숫자를 구한다.
                        numStr1 = numStr1.substring(zeroCount1);
                        numStr2 = numStr2.substring(zeroCount2);

                        // 길이가 긴게 크니까 이렇게 구하다가
                        if (numStr1.length() > numStr2.length()) {
                            return 1;
                        } else if (numStr1.length() < numStr2.length()) {
                            return -1;
                        }
                        // 길이가 같으면 숫자의 크기로 판별
                        int cmp = numStr1.compareTo(numStr2);
                        if (cmp != 0) {
                            return cmp;
                        }
                        // 숫자 값이 같을 때 0개수로 판별
                        if (zeroCount1 != zeroCount2) {
                            return zeroCount1 - zeroCount2;
                        }
                        // 다 같으면 다음꺼로 패스
                        continue;
                    }
                    // num1 만 숫자
                    if (num1) {
                        return -1;
                    }
                    // num2 만 숫자
                    if (num2) {
                        return 1;
                    }
                    // 만약 완전 같은 문자
                    if (c1 == c2) {
                        i++;
                        j++;
                        continue;
                    }
                    // 대문자 판별
                    boolean upper1 = isUpper(c1);
                    boolean upper2 = isUpper(c2);

                    int normalizedC1 = upper1 ? c1 - 'A' : c1 - 'a';
                    int normalizedC2 = upper2 ? c2 - 'A' : c2 - 'a';

                    // 아예 다른문자
                    if (normalizedC1 != normalizedC2) {
                        return normalizedC1 - normalizedC2;
                    }
                    // 같은 문자인데 대소문자가 달랐던 것
                    return upper1 ? -1 : 1;
                }
                return o1.length() - o2.length();
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
        int cnt = 0;
        while (cnt < numStr.length() && numStr.charAt(cnt) == '0') {
            cnt++;
        }
        return cnt;
    }
}

// G3 파일 탐색기 정렬
// 일단 retry 했다.
// 문자문자- 숫자숫자로 조건을 나누고 한개만 숫자이면 숫자가 문자열보다 먼저 나와야 하는 것으로 4개의 조건을 크게 둔다.
// 그리고 문자를 입력받고 그 문자가 숫자인지를 판별하는 메소드와 숫자가 아닐 때의 경우 문자를 판별할 때 대문자를 판별하는 메소드를 만든다.
// 숫자부터 하자면 먼저 숫자열에는 0이 포함될 수 있기 때문에 숫자열로 이루어진 문자열을 구하고 해당 인덱스를 통해 subString한다.
// 그리고 0의 개수를 구해서 저장한다음. 숫자 숫자의 경우 일단 길이가 긴거로 따진다 길이가 길면 큰 숫자이기 때문에 근데 숫자로만 이루어진 길이가 같다면
// 숫자의 크기로 판별하고 크기도 같다면 앞의 0의 개수에 따라 비교하면된다. 근데 0의 개수마저 같으면 다음 문자열로 이동해야하기 때문에 continue한다.
// 문자 문자의 경우 같으면 바로 continue 하는데 같은 경우가 대문자 대문자 소문자 소문자일 경우니까 isUpper를 통해 아예 다른 문자를 반환한다
// 근데 같은 문자인데 대소문자가 다를 수 있어서 대문자가 무조건 먼저이기 때문에 upper1 변수가 참일경우 1로 리턴해서 만든다.
