package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int ans = 0;
        for (int i = 0; i < input.length(); i++) {
            char w = input.charAt(i);

            if (w >= 'A' && w <= 'C') ans += 3;
            else if (w >= 'D' && w <= 'F') ans += 4;
            else if (w >= 'G' && w <= 'I') ans += 5;
            else if (w >= 'J' && w <= 'L') ans += 6;
            else if (w >= 'M' && w <= 'O') ans += 7;
            else if (w >= 'P' && w <= 'S') ans += 8;
            else if (w >= 'T' && w <= 'V') ans += 9;
            else if (w >= 'W' && w <= 'Z') ans += 10;
        }

        System.out.println(ans);
    }
}
