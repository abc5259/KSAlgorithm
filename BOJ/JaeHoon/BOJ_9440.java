package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9440 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static long min = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            min = Long.MAX_VALUE;
            if(N == 0) break;

            arr = new int[N];
            visited = new boolean[N];
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            dfs(0,"", "");
            sb.append(min).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int depth, String s1, String s2) {
        if(depth == N) {
            if(s1.equals("") || s2.equals("")) return;
            String s1Zeros = getZeros(s1);
            String s2Zeros = getZeros(s2);
            if(s1Zeros.equals(s1) || s2Zeros.equals(s2)) return;
            s1 = covert(s1Zeros, s1);
            s2 = covert(s2Zeros, s2);
            long sum = Long.parseLong(s1) + Long.parseLong(s2);
            min = Math.min(min, sum);
            return;
        }

        dfs(depth+1, s1+arr[depth], s2);
        dfs(depth+1, s1, s2+arr[depth]);
    }

    private static String covert(String zeros, String str) {
        if(zeros.length() > 0) {
            str = str.substring(zeros.length());
            String before = str.substring(0, 1);
            String after = str.substring(1);
            str = before + zeros + after;
        }
        return str;
    }

    private static String getZeros(final String str) {
        String zeros = "";
        for(int i = 0; i< str.length(); i++) {
            if(str.charAt(i) == '0') {
                zeros += '0';
            }else {
                break;
            }
        }
        return zeros;
    }
}
