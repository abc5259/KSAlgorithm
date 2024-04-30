package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 문제제목붙이기 {
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            arr = new boolean[26];

            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++){
                String input = br.readLine();
                int idx = input.charAt(0)-65;
                arr[idx] = true;
            }

            int result = 0;
            for(int i=0; i<arr.length; i++){
                if(!arr[i]) break;
                result++;
            }

            System.out.println("#"+(tc+1)+" "+result);
        }
    }
}
