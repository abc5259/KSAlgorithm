package BOJ.GiSeok.Java.retry;

// 00:22:18 G5

import java.util.*;
import java.io.*;

public class BOJ_1068 {
    
    private static int[] tree;
    private static int n, ret = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new int[n];

        int top = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (tree[i] == -1) {
                top = i;
            }
        }

        int wanna = Integer.parseInt(br.readLine());
        deleteNode(wanna);

        for (int i = 0; i < n; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        countNode(top);
        System.out.println(ret);
    }

    private static void deleteNode(int node) {
        tree[node] = -10;

        for (int i = 0; i < n; i++) {
            if (tree[i] == node) {
                deleteNode(i);
            }
        }
    }

    private static void countNode(int node) {
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (tree[i] == node) {
                countNode(i);
                flag = false;
            }
        }

        if (tree[node] != -10 && flag) {
            ret++;
        }
    }
}
