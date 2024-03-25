package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class N_Queen
{
    static int count;
    static int n;
    static int[] arr;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            count = 0;
            nQueen(0);

            System.out.println("#"+(tc+1)+" "+count);
        }
    }

    static void nQueen(int depth) {
        if(depth == n) {
            count++;
            return;
        }

        for(int i=0; i<n; i++) {
            arr[depth] = i;

            if(isPromising(depth)) {
                nQueen(depth+1);
            }
        }
    }

    static boolean isPromising(int col) {
        //왜 반복문을 col까지만 검사할까 고민했었는데, 왼쪽에서 오른쪽으로 열 단위로 탐색하기 때문
        for(int i=0; i<col; i++) {
            if(arr[col] == arr[i])return false;
            if(Math.abs(arr[col]-arr[i]) == Math.abs(col-i))return false;
        }
        return true;
    }
}
