package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1450 {
    static int N,C;
    static ArrayList<Integer> leftList = new ArrayList<>();
    static ArrayList<Integer> rightList = new ArrayList<>();
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,N/2,0,leftList);
        dfs(N/2+1, N-1, 0, rightList);

        Collections.sort(leftList);

        int answer = 0;
        for(int sum:rightList) {
            if(C < sum) continue;

            int low = 0;
            int high = leftList.size();
            int limit = C - sum;
            while (low + 1 < high) {
                int mid = (low + high) / 2;

                if(limit >= leftList.get(mid)) {
                    low = mid;
                }else {
                    high = mid;
                }
            }
            answer += low+1;
        }

        System.out.println(answer);
    }
    public static void dfs(int start, int end, int sum,ArrayList<Integer> list) {
        if(sum > C) return;

        if(start > end) {
            list.add(sum);
            return;
        }
        dfs(start+1,end,sum+arr[start],list);
        dfs(start+1,end,sum,list);
    }
}
