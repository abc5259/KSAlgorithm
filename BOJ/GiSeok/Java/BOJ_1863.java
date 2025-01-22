/**
 * [G4 스택] 스카이라인 쉬운거 - O(반례힌트), 00:32:10
 * 시도 3
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1863 {

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ret = 0;
        ArrayDeque<Point> skyline = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (skyline.isEmpty()) skyline.push(new Point(x, y));
            else {
                Point peek = skyline.peek();
                if (peek.y < y) skyline.push(new Point(x, y));
                else {
                    int tmp = 0;
                    while (!skyline.isEmpty() && skyline.peek().y > y) {
                        Point pop = skyline.pop();
                        if (pop.y != tmp) {
                            ret++;
                            tmp = pop.y;
                        }
                    }
                    if (y != 0) skyline.push(new Point(x, y));
                }
            }
        }

        int tmp = 0;
        while (!skyline.isEmpty()) {
            Point pop = skyline.pop();
            if (pop.y != tmp) {
                ret++;
                tmp = pop.y;
            }
        }
        System.out.println(ret);
    }
}
