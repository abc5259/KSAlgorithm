package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password = br.readLine();
        long k = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<password.length(); i++) {
            if(password.charAt(i) == '1' || password.charAt(i) == '6'
              || password.charAt(i) == '2' || password.charAt(i) == '7') {
                sb.append(password.charAt(i));
            }
        }

        StringBuffer result = new StringBuffer();
        long change = 1;
        int pos = 0;
        for(int i=sb.length()-1; i>=0; i--) {
            pos++;
//            long
        }

    }
}
