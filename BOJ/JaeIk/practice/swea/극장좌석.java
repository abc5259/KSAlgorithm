package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 극장좌석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> seat = new ArrayList<>();
            for(int i=0; i<n; i++){
                seat.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(seat);

            int total=0;
            for(int i=0; i<n; i++){
                if(i==n-1){
                    total+=seat.get(i)*2;
                    break;
                }
                total+=seat.get(i);
            }
            total += n;

            System.out.println("#"+(tc+1)+" "+total);
        }
    }
}
