package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class String2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++){
            int T = Integer.parseInt(br.readLine());

            String arr = br.readLine();
            String sentence = br.readLine();

            int sum = 0;
            int size = arr.length();
            for(int i=0; i<=sentence.length()-size; i++){
                if(sentence.substring(i, i+size).equals(arr)){
                    sum++;
                }
            }

            System.out.println("#"+T+" "+sum);
        }
    }
}
