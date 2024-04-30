package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 의석이의세로로말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            Character[][] arr = new Character[15][15];

            for(int i=0; i<5; i++){
                String input = br.readLine();
                for(int j=0; j<input.length(); j++){
                    arr[i][j] = input.charAt(j);
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#"+(tc+1)+" ");

            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr[i].length; j++){
                    if(arr[j][i]!=null){
                        sb.append(arr[j][i]);
                    }
                }
            }

            System.out.println(sb);
        }
    }
}
