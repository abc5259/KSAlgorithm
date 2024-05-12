package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 쇠막대기자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            String input = br.readLine();

            int result = 0;
            int count = 0;
            for(int i=0; i<input.length(); i++){
                if(input.charAt(i)=='(' && input.charAt(i+1)==')'){
                    result += count;
                    i++;
                }
                else if(input.charAt(i)=='('){
                    count++;
                }
                else if(input.charAt(i)==')'){
                    count--;
                    result++;
                }
            }

            System.out.println("#"+(tc+1)+" "+result);
        }
    }
}
