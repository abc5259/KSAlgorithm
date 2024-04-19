package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1039 {
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        int n = Integer.parseInt(s);
        int k = Integer.parseInt(st.nextToken());

        isVisited = new boolean[1000001][11];

        int answer = -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, 0});
        isVisited[n][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if(curr[1] == k) {
                answer = Math.max(answer, curr[0]);
                continue;
            }

            for(int i=0; i<s.length()-1; i++) {
                for(int j=i+1; j<s.length(); j++) {
                    String newN = swap(i, j, curr[0]);
                    int num = Integer.parseInt(newN);
                    int nCnt = curr[1] + 1;
                    if(newN.charAt(0) == '0' || isVisited[num][nCnt]) continue;

                    q.offer(new int[]{num, nCnt});
                    isVisited[num][nCnt] = true;
                }
            }
        }

        System.out.println(answer);
    }
    static String swap(int i, int j, int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));

        char tmp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, tmp);

        return sb.toString();
    }
}
