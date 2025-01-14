package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21943 {
    static int N;
    static int[] arr;
    static boolean[] isUsed;
    static int P;
    static int Q;
    static List<boolean[]> list;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        isUsed = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        solveOperators(0,P,Q,new boolean[N-1]);
        solve(0, new int[N]);

        System.out.println(max);
    }

    static void solveOperators(int depth, int pCnt, int qCnt, boolean[] operators) {
        if(depth == N-1) {
            list.add(operators.clone());
            return;
        }

        if(pCnt > 0) {
            solveOperators(depth+1, pCnt-1, qCnt, operators);
        }

        if(qCnt > 0) {
            operators[depth] = true;
            solveOperators(depth+1, pCnt, qCnt-1, operators);
            operators[depth] = false;
        }
    }

    public static void solve(int depth, int[] nums) {
        if(depth == N) {
            calculate(nums);
            return;
        }

        for(int i=0; i<N; i++) {
            if(isUsed[i]) continue;
            isUsed[i] = true;
            nums[depth] = arr[i];
            solve(depth+1, nums);
            isUsed[i] = false;
        }
    }

    static void calculate(int[] nums) {
        for(boolean[] operators: list) {
            List<Integer> add = new ArrayList<>();
            int index = 0;
            int prev = nums[0];
            int sum = 0;
            for(int i=1; i<nums.length; i++) {
               if(!operators[index]) {
                   prev += nums[i];
               } else {
                   if(sum == 0) {
                       sum = prev;
                   } else {
                       sum *= prev;
                   }
                   prev = nums[i];
               }
               index++;
            }
            if(sum == 0) {
                sum = prev;
            } else {
                sum *= prev;
            }
            max = Math.max(max, sum);
        }
    }
}
