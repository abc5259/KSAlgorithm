/**
 * 10845 - 큐(S4/구현) [O]
 * 시도1
 */
package BOJ.GiSeok.Java;

import java.io.*;

public class BOJ_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] queue = new int[10001];
        int front = 0;
        int tail = 0;
        for (int i = 0; i < t; i++) {
            String[] words = br.readLine().split(" ");

            if (words[0].equals("push")) {
                int num = Integer.parseInt(words[1]);
                queue[tail++] = num;
            } else if (words[0].equals("pop")) {
                int pop = -1;
                if (front < tail) pop = queue[front++];
                System.out.println(pop);
            } else if (words[0].equals("size")) {
                System.out.println(tail - front);
            } else if (words[0].equals("empty")) {
                if (front < tail) System.out.println(0);
                else System.out.println(1);
            } else if (words[0].equals("front")) {
                int fr = -1;
                if (front < tail) fr = queue[front];
                System.out.println(fr);
            } else if (words[0].equals("back")) {
                int bk = -1;
                if (front < tail) bk = queue[tail-1];
                System.out.println(bk);
            }
        }
    }
}
