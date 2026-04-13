package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String str = br.readLine();

            StringBuilder tmp = new StringBuilder();
            int idx = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(idx) != str.charAt(i)) {
                    tmp.append(str.charAt(idx));
                    idx = i;
                }
            }
            tmp.append(str.charAt(str.length() - 1));

            if (check(tmp.toString())) {
                sb.append("Infected!");
            } else {
                sb.append("Good");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean check(String str) {
        if (str.length() > 5) {
            return false;
        }
        if (('A' <= str.charAt(0) && str.charAt(0) <= 'F') &&
                ('A' <= str.charAt(str.length() - 1) && str.charAt(str.length() - 1) <= 'F')) {
            if (str.contains("AFC")) {
                return true;
            }
        }
        return false;
    }
}
// S3 염색체 문자열
// 28분
// 어케 풀었노 이게 맞나?? 그냥 조건에 따라서 풀었는데 시작이랑 끝은 A~F사이여야되고 없어도 되고
// AFC는 무조건 포함이 되어야 한다 생각했다
// 그래서 tmp 라는 가변객체를 만들어서 압축하는 걸 했다.
// 압축된 tmp 를 가지고 check에서 판별해서 return 해줬다.