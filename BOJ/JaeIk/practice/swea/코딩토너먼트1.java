package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 코딩토너먼트1 {
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int k = Integer.parseInt(br.readLine());

            list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<Math.pow(2, k); i++){
                list.add(Integer.parseInt(st.nextToken()));
            }


            int boring = 0;
            while(list.size()!=1){
                int length = list.size();
                List<Integer> newList = new ArrayList<>();

                for(int i=0; i<length; i+=2){
                    int max = Math.max(list.get(i), list.get(i+1));
                    newList.add(max);
                    boring += Math.abs(list.get(i) - list.get(i+1));
                }

                list = new ArrayList<>(newList);
            }

            System.out.println("#"+(tc+1)+" "+boring);
        }
    }
}
