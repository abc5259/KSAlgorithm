package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_ex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int line = N + (N-1);
        StringBuffer sb = new StringBuffer();

        int cnt = 1;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=3; j++) {
                if(j % 2 != 0) {
                    for(int l=N-i; l>=1; l--) {
                        sb.append(" ");
                    }
                    for(int l=1; l<=cnt; l++) {
                        sb.append("*");
                    }
                    for(int l=N-i; l>=1; l--) {
                        sb.append(" ");
                    }
                }else {
                    for(int l=N-i; l>=1; l--) {
                        sb.append(" ");
                    }
                    for(int l=1; l<=cnt; l++) {
                        if(l == 1 || l == cnt) sb.append("*");
                        else sb.append(" ");
                    }
                    for(int l=N-i; l>=1; l--) {
                        sb.append(" ");
                    }
                }
            }
            cnt+=2;
            sb.append("\n");
        }
        cnt -=4;
        for(int i=N-1; i>=1; i--) {
            for(int j=1; j<=3; j++) {
                if(j % 2 != 0) {
                    for(int l=N-i; l>=1; l--) {
                        sb.append(" ");
                    }
                    for(int l=1; l<=cnt; l++) {
                        sb.append("*");
                    }
                    for(int l=N-i; l>=1; l--) {
                        sb.append(" ");
                    }
                }else {
                    for(int l=N-i; l>=1; l--) {
                        sb.append(" ");
                    }
                    for(int l=1; l<=cnt; l++) {
                        if(l == 1 || l == cnt) sb.append("*");
                        else sb.append(" ");
                    }
                    for(int l=N-i; l>=1; l--) {
                        sb.append(" ");
                    }
                }
            }
            cnt-=2;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
