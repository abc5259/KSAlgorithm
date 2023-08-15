package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dist = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] speed = {1,4,8};

        boolean isOk = false;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<3; i++) {
            if(dist % speed[i] == 0) {
                int time = dist / speed[i];
                if(T >= time) {
                    sb.append("1\n");
                    int pressTime = T - time;
                    sb.append(pressTime + " " + speed[i]);
                    System.out.println(sb);
                    return;
                }
            }
        }

        for(int i=0; i<2; i++) {
            for (int j=i+1; j<3; j++) {
                int time = dist / speed[j];
                int restDist = dist % speed[j];
                if(restDist % speed[i] == 0) {
                    time += restDist / speed[i];
                    if(T >= time) {
                        sb.append("2\n");
                        int pressTime = T - time;
                        sb.append(pressTime + " " + speed[j] + "\n");
                        int nextPressTime = pressTime +  dist / speed[j];
                        sb.append(nextPressTime + " " + speed[i]);
                        System.out.println(sb);
                        return;
                    }
                }
            }
        }

        int time = dist / 8;
        int restDist = dist % 8;

        time += restDist / 4;
        restDist = restDist % 4;

        time += restDist / 1;
        if(T >= time) {
            sb.append("3\n");
            int pressTime = T-time;
            sb.append(pressTime + " " + 8 + "\n");
            pressTime = pressTime +  dist / 8;
            sb.append(pressTime + " " + 4 + "\n");
            pressTime = pressTime +  dist % 8 / 4;
            sb.append(pressTime + " " + 1);
            System.out.println(sb);
        }else {
            System.out.println(-1);
        }
    }
}
