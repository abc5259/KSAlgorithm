package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10775 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G+1];
        for(int i=1; i<=G; i++) parent[i] = i;

        int answer = 0;
        boolean isOk = true;
        for(int i=1; i<=P; i++) {
            int g = Integer.parseInt(br.readLine());
            int root = find(g);

            if(root == 0) isOk = false;

            if(isOk) {
                parent[root] = root-1;
                answer++;
            }
        }

        System.out.println(answer);
    }
    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
