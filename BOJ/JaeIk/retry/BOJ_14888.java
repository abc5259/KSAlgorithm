package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int n;
    static int[] nums;
    static int[] operators = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }

        solve(nums[0], 1);

        System.out.println(max);
        System.out.println(min);

    }

    static void solve(int num, int depth){
        if(depth == n){
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        for(int i=0; i<4; i++){
            //operator배열 원소가 1일 때만 탐색을 하므로 백트래킹이다
            //같은 연산자가 여러번 쓰일 수 있기 때문에 탐색 조건을 0보다 클 때로 준다
            if(operators[i] > 0){
                operators[i]--;

                switch (i){
                    case 0:
                        solve(num+nums[depth], depth+1);
                        break;

                    case 1:
                        solve(num-nums[depth], depth+1);
                        break;

                    case 2:
                        solve(num*nums[depth], depth+1);
                        break;

                    case 3:
                        solve(num/nums[depth], depth+1);
                }

                operators[i]++;
            }
        }
    }
}
