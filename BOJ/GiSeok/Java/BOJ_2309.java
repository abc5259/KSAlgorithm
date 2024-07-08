/***
 * 순열, 브론즈1, 10분
 * 보자마자 순열로 뽑아야겠다는 생각
 * 왜? 순열 = 순서가 있게 뽑는 경우의 수
 * 해당 문제는 순서가 있고 (오름차순으로 출력) 합이 100이 되는 경우의 수 1개(또는 그 이상)를 찾아 그 순열을 출력하는 것이기 때문이다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309 {
    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++)
            arr[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        permutation(9, 7, 0);
    }

    static void permutation(int n, int r, int depth) {
        if (r == depth) {
            int sum = 0;
            for (int i = 0; i < r; i++)
                sum += arr[i];
            
            if (sum == 100) {
                for (int i = 0; i < r; i++)
                    System.out.println(arr[i]);
                System.exit(0);
            }

            return;
        }

        for (int i = depth; i < n; i++) {
            swap(i, depth);
            permutation(n, r, depth + 1);
            swap(i, depth);
        }
    }

    static void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
