package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 자가복제문자열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            Long k = Long.parseLong(br.readLine())-1;

            int answer = 0;
            while(k>=0) {
                if(k%2==1) {
                    k = (k-1)/2;
                }
                else if(k%2==0 && k%4==0) {
                    answer = 0;
                    break;
                }
                else if(k%2==0) {
                    answer = 1;
                    break;
                }
            }

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }
}
