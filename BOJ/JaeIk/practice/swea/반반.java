package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 반반 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int[] alphabet = new int[93];

            String line = br.readLine();

            for(char c : line.toCharArray()){
                alphabet[c]++;
            }

            int sum = 0;
            for(int i=65; i<92; i++){
                if(alphabet[i]==2){
                    sum++;
                }
            }

            String answer = sum==2?"Yes":"No";

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }
}
