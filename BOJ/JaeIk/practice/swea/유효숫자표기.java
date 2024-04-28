package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 유효숫자표기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            String n = br.readLine();

            int pow = n.length()-1;
            String foreStr = n.substring(0, 3);
            double foreNum = Double.parseDouble(foreStr)/100;

            if(Math.round(foreNum*10) >= 100){
                foreNum = foreNum/10;
                pow = pow+1;
            }

            System.out.printf("#%d %.1f*10^%d\n", (tc+1), foreNum, pow);
        }
    }
}
