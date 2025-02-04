package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String word = br.readLine();
        int cnt = 0;
        int i = 0;
        while (i < s.length() && i + word.length() <= s.length()) {
            boolean check = true;
            for(int j=i; j<word.length()+i; j++) {
                if(s.charAt(j) != word.charAt(j-i)) {
                    check = false;
                    break;
                }
            }
            if(check) {
                cnt++;
                i += word.length();
            }else {
                i++;
            }
        }
        System.out.println(cnt);
    }
}
