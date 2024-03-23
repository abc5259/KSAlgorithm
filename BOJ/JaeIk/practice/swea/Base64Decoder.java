package BOJ.JaeIk.practice.swea;

import java.io.*;

public class Base64Decoder {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            String now = br.readLine();
            int cnt = 3;
            int sum = 0;
            for(int i = 0; i < now.length(); i++) {
                int tmp = base64(now.charAt(i));
                for(int j=0; j<cnt; j++) tmp *= 64;
                sum += tmp;
                if(--cnt==-1) {
                    cnt = 3;
                    char[] arr = new char[3];
                    for(int j=0; j<3; j++) {
                        arr[2-j] = (char)(sum%256);
                        sum/=256;
                    }
                    sb.append(arr[0]).append(arr[1]).append(arr[2]);
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int base64(char input) {
        if(input>=65 && input<=90) return input-65;
        else if(input>=97 && input<=122) return input-71;
        else if(input>=48 && input<=57) return input+4;
        else {
            if(input=='+') return 62;
            else return 63;
        }
    }
}