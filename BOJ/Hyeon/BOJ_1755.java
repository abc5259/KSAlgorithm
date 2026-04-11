package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            list.add(i);
        }

        List<String> eng = Arrays.asList(
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        );

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {

                String str1 = (i1 < 10) ? eng.get(i1) : eng.get(i1 / 10) + " " + eng.get(i1 % 10);
                String str2 = (i2 < 10) ? eng.get(i2) : eng.get(i2 / 10) + " " + eng.get(i2 % 10);

                return str1.compareTo(str2);
            }
        });

        int cnt = 0;

        StringBuilder sb = new StringBuilder();

        for (Integer i : list) {
            if (cnt == 10) {
                sb.append("\n");
                cnt = 0;
            }
            cnt++;
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
// S4 숫자놀이 문자열
// 20분
// 걍 풀었다 문자열 비교연산