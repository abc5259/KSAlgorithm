package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳공부 {
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            String input = br.readLine();

            int answer = 0;
            for(int i=0; i<input.length(); i++){
                if(alphabet.charAt(i) == input.charAt(i)){
                    answer++;
                }else break;
            }

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }
}
