package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class 석찬이의받아쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            String sentence = br.readLine();
            String writing = br.readLine();

            int sum=0;
            for(int i=0; i<n; i++){
                if(Objects.equals(sentence.charAt(i), writing.charAt(i))){
                    sum++;
                }
            }

            System.out.println("#"+(tc+1)+" "+sum);
        }
    }
}
