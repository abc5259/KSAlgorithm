package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] room = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = line.charAt(j);
            }
        }

        int col = 0;
        int row = 0;


        for (int i = 0; i < N; i++) {
            int emptySpaceCount = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') {
                    emptySpaceCount++;
                } else {

                    if (emptySpaceCount >= 2) {
                        col++;
                    }
                    emptySpaceCount = 0;
                }
            }
            if (emptySpaceCount >= 2) {
                col++;
            }
        }

        for (int j = 0; j < N; j++) {
            int emptySpaceCount = 0;
            for (int i = 0; i < N; i++) {
                if (room[i][j] == '.') {
                    emptySpaceCount++;
                } else {
                    if (emptySpaceCount >= 2) {
                        row++;
                    }
                    emptySpaceCount = 0;
                }
            }
            if (emptySpaceCount >= 2) {
                row++;
            }
        }

        System.out.println(col + " " + row);
    }
}
// S5 누울 자리를 찾아라 문자열
