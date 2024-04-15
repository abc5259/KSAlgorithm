package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class 새샘이의735게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[7];
            for(int i=0; i<7; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            HashSet<Integer> set = new HashSet<>();
            for(int i=0; i<5; i++){
                for(int j=i+1; j<6; j++){
                    for(int k=j+1; k<7; k++){
                        int sum = 0;
                        sum += arr[i];
                        sum += arr[j];
                        sum += arr[k];

                        set.add(sum);
                    }
                }
            }

            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list, Collections.reverseOrder());

            System.out.println("#"+(tc+1)+" "+list.get(4));
        }
    }
}
