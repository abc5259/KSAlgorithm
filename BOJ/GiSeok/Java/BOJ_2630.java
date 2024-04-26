package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {

    static int N;
    static int[][] paper;
    static int white, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }

        cuttingAPaper(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
        
    }

    static void cuttingAPaper(int startx, int starty, int n) {
        if (n == 1) {
            if (paper[starty][startx] == 0) white++;
            else blue++;
            return;
        }
        
        int check = paper[starty][startx];
        boolean isNotPaper = false;
        for (int i = starty; i < starty + n; i++) {
            for (int j = startx; j < startx + n; j++) {
                if (paper[i][j] != check) {
                    isNotPaper = true;
                    break;
                }
            }
        }

        if (!isNotPaper) {
            if (check == 0) white++;
            else blue++;
        } else {
            cuttingAPaper(startx, starty, n/2);
            cuttingAPaper(startx + (n/2), starty, n/2);
            cuttingAPaper(startx, starty + (n/2), n/2);
            cuttingAPaper(startx + (n/2), starty + (n/2), n/2);
        }
    }
}
