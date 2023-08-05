package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_22251 {
    static boolean[][] nums = {
            {true,true,true,false,true,true,true},
            {false,false,true,false,false,true,false},
            {true,false,true,true,true,false,true},
            {true,false,true,true,false,true,true},
            {false,true,true,true,false,true,false},
            {true,true,false,true,false,true,true},
            {true,true,false,true,true,true,true},
            {true,false,true,false,false,true,false},
            {true,true,true,true,true,true,true},
            {true,true,true,true,false,true,true}
    };
    static int[][] changeNum = new int[10][10];
    static int total;
    static int P,N,K;
    static Set<Integer> set = new HashSet<>();
    static char[] X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        char[] C = st.nextToken().toCharArray();
        X = new char[K];
        if(C.length < K) {
            Arrays.fill(X,'0');
            int j = K-1;
            for(int i=C.length-1; i>=0; i--) {
                X[j] = C[i];
                j--;
            }
        }else {
            X = C;
        }
        getCnt();
//        System.out.println(X.length);
        solve(0, X.length,0);


        System.out.println(set.size() - 1);
    }
    public static void solve(int depth, int size, int changeCnt) {
        if(changeCnt > P) return;

        if(depth == size) {
            int newNum = Integer.parseInt(String.valueOf(X));
            if(newNum >=1 && newNum <=N ) {
                if(!set.contains(newNum)) {
                    set.add(newNum);
                }

            }
            return;
        }

        for(int i=0; i<10; i++) {
            char c = X[depth];
            if(changeCnt + changeNum[c - '0'][i] <= P) {
                X[depth] = (char)(i + '0');
                solve(depth+1,size,changeCnt + changeNum[c - '0'][i]);
                X[depth] = c;
            }
        }

    }
    public static void getCnt() {
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                for(int l=0; l<7; l++) {
                    if(nums[i][l] != nums[j][l]) {
                        changeNum[i][j]++;
                    }
                }
            }
        }
    }
}
