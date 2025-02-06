package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int pos1 = -1;
        int pos2 = -1;
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            if(s.equals("KBS1")) {
                pos1 = i;
            }
            if(s.equals("KBS2")) {
                pos2 = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(pos2 < pos1) {
            for(int i=0; i<pos1; i++) sb.append(1);
            for(int i=0; i<pos1; i++) sb.append(4);
            for(int i=0; i<=pos2; i++) sb.append(1);
            for(int i=1; i<=pos2; i++) sb.append(4);
        } else {
            for(int i=0; i<pos1; i++) sb.append(1);
            for(int i=0; i<pos1; i++) sb.append(4);
            for(int i=0; i<pos2; i++) sb.append(1);
            for(int i=1; i<pos2; i++) sb.append(4);
        }
        System.out.println(sb);
    }
}
