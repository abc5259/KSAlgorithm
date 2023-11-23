package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ_1931 {
    static ArrayList<ArrayList<Integer>> planner;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        planner = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            planner.add(new ArrayList<>());
            planner.get(i).add(Integer.parseInt(st.nextToken()));
            planner.get(i).add(Integer.parseInt(st.nextToken()));
        }

        planner.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(Objects.equals(o1.get(1), o2.get(1))){
                    return o1.get(0) - o2.get(0);
                }
                return o1.get(1) - o2.get(1);
            }
        });

        int end = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            //이전 회의가 끝나는 동시에 다음 회의의 시작이 가능 하기 때문에 다음과 같은 조건문
            if(planner.get(i).get(0) >= end){
                end = planner.get(i).get(1);
                count++;
            }
        }

        System.out.println(count);
    }
}
