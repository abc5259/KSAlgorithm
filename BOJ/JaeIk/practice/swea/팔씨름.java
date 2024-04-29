package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팔씨름 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            String input = br.readLine();

            int count=0;
            for(int i=0; i<input.length(); i++){
                if(input.charAt(i)=='x')count++;
            }

            String result = (count>=8)? "NO": "YES";

            System.out.println("#"+(tc+1)+" "+result);
        }
    }
}
