package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int prev = 0;
        while (!s.isEmpty()) {
            String c = s.charAt(0) + "";
            while (true) {
                prev++;
                String sprev = String.valueOf(prev);
                if(sprev.contains(c)) {
                    break;
                }
            }
            String sprev = String.valueOf(prev);
            int idx = 0;
            for(int i=0; i<sprev.length(); i++) {
                if(sprev.charAt(i)==s.charAt(0)) {
                    idx = i;
                    break;
                }
            }
            int idx2 = 0;
            for(int i=idx; i<sprev.length(); i++) {
                if(sprev.charAt(i) == s.charAt(idx2)) {
                    idx2++;
                    if(idx2 == s.length()) break;
                }
            }
            s = s.substring(Math.max(1, idx2));
        }
        System.out.println(prev);
    }
}
