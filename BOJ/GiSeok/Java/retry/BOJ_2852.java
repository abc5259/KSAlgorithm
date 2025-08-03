package BOJ.GiSeok.Java.retry;

// 00:54:30 S3 구현
import java.util.*;
import java.io.*;

public class BOJ_2852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int team1WinStartTime = 0;
        int team2WinStartTime = 0;

        int team1WinTotalSec = 0;
        int team2WinTotalSec = 0;
        int currentTime = 0;

        int team1score = 0;
        int team2score = 0;

        int winner = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int teamNo = Integer.parseInt(st.nextToken());
            String goalTime = st.nextToken();

            currentTime = Integer.parseInt(goalTime.split(":")[0]) * 60
                + Integer.parseInt(goalTime.split(":")[1]);
            if (teamNo == 1) team1score++;
            else team2score++;

            if (team1score > team2score) {
                if (winner != -1) {
                    team1WinStartTime = currentTime;
                    winner = -1;
                }
            } else if (team2score > team1score) {
                if (winner != 1) {
                    team2WinStartTime = currentTime;
                    winner = 1;
                }
            } else {
                if (winner == -1) {
                    team1WinTotalSec += (currentTime - team1WinStartTime);
                } else if (winner == 1) {
                    team2WinTotalSec += (currentTime - team2WinStartTime);
                }
                winner = 0;
            }
        }

        if (winner == -1) {
            team1WinTotalSec += ((48 * 60) - team1WinStartTime);
        } else if (winner == 1) {
            team2WinTotalSec += ((48 * 60) - team2WinStartTime);
        }

        int min = team1WinTotalSec / 60;
        int sec = team1WinTotalSec % 60;
        System.out.println(String.format("%02d:%02d", min, sec));

        min = team2WinTotalSec / 60;
        sec = team2WinTotalSec % 60;
        System.out.println(String.format("%02d:%02d", min, sec));
    }
}
