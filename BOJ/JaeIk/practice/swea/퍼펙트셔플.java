package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.plaf.basic.BasicButtonUI;

public class 퍼펙트셔플 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int length = Integer.parseInt(br.readLine());

            String[] arr = new String[length];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<length; i++){
                arr[i] = st.nextToken();
            }

            int mid = (length%2==0)?length/2-1 : length/2;

            List<String> part1 = new ArrayList<>();
            List<String> part2 = new ArrayList<>();
            for(int i=0; i<=mid; i++){
                part1.add(arr[i]);
            }
            for(int i=mid+1; i<length; i++){
                part2.add(arr[i]);
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<length; i++){
                if(i < part1.size())sb.append(part1.get(i)).append(" ");
                if(i < part2.size())sb.append(part2.get(i)).append(" ");
            }

            System.out.println("#"+(tc+1)+" "+sb);
        }
    }
}
