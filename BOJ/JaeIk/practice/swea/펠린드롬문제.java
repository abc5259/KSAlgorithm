package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class 펠린드롬문제 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String[] arr = new String[n];
            for(int i=0; i<n; i++){
                arr[i] = br.readLine();
            }

            int answer = 0;
            int sum = 0;
            StringBuilder sb;
            for(int i=0; i<n; i++){
                sb = new StringBuilder();
                sb.append(arr[i]);
                String reverse = sb.reverse().toString();
                if(arr[i].equals(reverse)){
                    sum = m;
                } else {
                    for(int j=i+1; j<n; j++){
                        if(arr[j].equals(reverse)){
                            answer += 2*m;
                            break;
                        }
                    }
                }
            }

            answer += sum;
            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

}
