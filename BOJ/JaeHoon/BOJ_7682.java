package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_7682 {
    static Set<String> gameState = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String game = br.readLine();
            if(game.equals("end")) {
                break;
            }
            sb.append(check(game) ? "valid\n" : "invalid\n");
        }
        System.out.print(sb);
    }

    public static boolean check(String s) {
        int xCnt = 0;
        int oCnt = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='X') xCnt++;
            else if(s.charAt(i) == 'O') oCnt++;
        }
        if(oCnt > xCnt) return false;
        if(xCnt - oCnt > 1) return false;
        if(xCnt == 0 && oCnt == 0) return true;
        char[][] map = new char[3][3];
        int row = 0;
        for(int i=0; i<s.length(); i+=3) {
            map[row][0] = s.charAt(i);
            map[row][1] = s.charAt(i+1);
            map[row][2] = s.charAt(i+2);
            row++;
        }

        int winCnt = 0;
        int oWinCnt = 0;
        int xWinCnt = 0;
        for(int i=0; i<3; i++) {
            if(map[i][0] != '.' && map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                winCnt++;
                if(map[i][0] == 'X') xWinCnt++;
                else oWinCnt++;
            }
        }
        for(int j=0; j<3; j++) {
            if(map[0][j] != '.' && map[0][j] == map[1][j] && map[1][j] == map[2][j]) {
                winCnt++;
                if(map[0][j] == 'X') xWinCnt++;
                else oWinCnt++;
            }
        }

        if(map[0][0] != '.' && map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
            winCnt++;
            if(map[0][0] == 'X') xWinCnt++;
            else oWinCnt++;
        }
        if(map[0][2] != '.' && map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
            winCnt++;
            if(map[0][2] == 'X') xWinCnt++;
            else oWinCnt++;
        }
        if(xWinCnt <= 0 && oWinCnt <=0 && xCnt == oCnt) return false;
        if(xWinCnt <= 0 && oWinCnt <=0 && xCnt + oCnt < 9) return false;
        if(xWinCnt > 0 && oWinCnt > 0) return false;
        if(xWinCnt > 0 && xCnt == oCnt) return false;
        if(oWinCnt > 0 && xCnt > oCnt) return false;
        if(xCnt + oCnt == 9 && oWinCnt > 0) return false;
        return true;
    }
}
