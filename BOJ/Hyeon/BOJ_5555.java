package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String find = br.readLine();

        int N = Integer.parseInt(br.readLine());

        int res = 0;

        for (int i = 0; i < N; i++) {
            String str1 = br.readLine();
            String str2 = str1.substring(0, str1.length() - 1);

            String ring = str1 + str2;

            if (ring.contains(find)) {
                res++;
            }
        }
        System.out.println(res);
    }
}
// S5 반지 문자열
// 7분
// 그냥 반지의 의미상 그대로 이어지기 때문에 문자열의 끝과 처음은 이어져야 한다.
// 그래서 문자열을 맨끝만 빼고 그대로 이후에 concat 해서 새로운ring 이라는 문자열을 만들어서
// 주어지는 find 문자열 은 길이가 10보다 작거나 같고 ring 은 그 문자열을 포함하고 있냐 없냐가 정답 여부