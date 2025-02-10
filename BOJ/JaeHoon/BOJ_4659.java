package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if(s.equals("end")) break;
            if(check(s)) {
                sb.append(String.format("<%s> is acceptable.\n", s));
            } else {
                sb.append(String.format("<%s> is not acceptable.\n", s));
            }
        }
        System.out.print(sb);
    }

    private static boolean check(String s) {
        boolean isGood = false;
        int cnt = 0;
        int cnt2 = 0;
        for(int i = 0; i< s.length(); i++) {
            if(i != 0 && s.charAt(i-1) == s.charAt(i) && s.charAt(i) != 'e' && s.charAt(i) != 'o') return false;
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                isGood = true;
                cnt++;
                cnt2 = 0;
            }else {
                cnt2++;
                cnt = 0;
            }

            if(cnt2 == 3 || cnt == 3) {
                return false;
            }
        }

        return isGood;
    }
}
