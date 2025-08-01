package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1652 {

    public static void main(String[] args) throws IOException {
        //02:45
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int cnt1 = 0;
        for(int i=0; i<N; i++) {
            int j = 0;
            while (j < N-1) {
                if(map[i][j] == '.' && map[i][j+1] == '.') {
                    cnt1++;
                    while (j < N && map[i][j] != 'X') {
                        j++;
                    }
                }
                j++;
            }
        }

        int cnt2 = 0;
        for(int j=0; j<N; j++) {
            int i = 0;
            while (i < N-1) {
                if(map[i][j] == '.' && map[i+1][j] == '.') {
                    cnt2++;
                    while (i < N && map[i][j] != 'X') {
                        i++;
                    }
                }
                i++;
            }
        }

        System.out.println(cnt1 + " " + cnt2);
    }
}
