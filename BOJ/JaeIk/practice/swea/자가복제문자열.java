package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 자가복제문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int k = Integer.parseInt(br.readLine())-1;

            int result=0;
            while(k>=0){
                if(k%2==1){
                    k=(k-1)/2;
                }
                if(k%4==0){
                    result=0;
                    break;
                }
                else if(k%2==0){
                    result=1;
                    break;
                }
            }

            System.out.println("#"+(tc+1)+" "+result);
        }
    }
}
