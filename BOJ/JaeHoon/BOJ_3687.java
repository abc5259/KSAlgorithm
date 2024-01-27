package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3687 {
    static String[] num = {"1","7","4","2","6","8", "10"};
    static String[] num2 = {"1","7", "11", "71", "111", "711"};
    public static void main(String[] args) throws IOException {
        String[] minDP = new String[101];
        String[] maxDp = new String[101];


        for(int i=0; i<6; i++) {
            minDP[i+2] = num[i];
            maxDp[i+2] = num2[i];
        }

        minDP[8] = num[6];

        for(int i=9; i<=100; i++) {
            String min = "1111111111111111";

            for(int j=2; j<i; j++) {
                for(int k=j; k<i; k++) {
                    if(j + k == i) {
                        String ns1 = minDP[j] + minDP[k];
                        String ns2 = minDP[k] + minDP[j];

                        String minNx;
                        if(ns1.compareTo(ns2) >= 0) {
                            minNx = ns2;
                        }else {
                            minNx = ns1;
                        }

                        minNx = minNx.charAt(0) + minNx.substring(1).replace('6','0');

                        if(min.length() == minNx.length()) {
                            if(min.compareTo(minNx) >= 0) {
                                min = minNx;
                            }
                        }
                        else if(min.length() > minNx.length()) {
                            min = minNx;
                        }
                    }
                }
            }

            minDP[i] = min;
        }


        for(int i=8; i<=100; i++) {
            maxDp[i] = maxDp[i-2] + maxDp[2];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(minDP[n] + " " + maxDp[n]).append("\n");
        }

        System.out.println(sb);
    }
}

//2:35

//1
//