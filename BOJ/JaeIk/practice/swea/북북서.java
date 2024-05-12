package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 북북서 {
    static Stack<Integer> dir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            String input = br.readLine();

            dir = new Stack<>();

            int idx = 0;
            while(idx < input.length()){
                switch (input.charAt(idx)){
                    case 'n':
                        dir.add(0);
                        idx += 5;
                        break;
                    case 'w':
                        dir.add(90);
                        idx += 4;
                        break;
                }
            }

            double up = 0;
            double down = 0;
            int length = dir.size();
            for(int i=0; i<length; i++){
                int now = dir.pop();

                switch (now){
                    case 90 :
                        if(i==0) up = 90;
                        else{
                            up = up*2 + 90;
                            down = Math.pow(2, i);
                        }
                        break;

                    case 0 :
                        if(i==0) up = 0;
                        else{
                            up = up*2 - 90;
                            down = Math.pow(2, i);
                        }
                        break;
                }
            }

            while(up!=0 && down!=0 && up%2==0 && down%2==0){
                up /= 2;
                down /= 2;
            }

            String answer = (up>0 && down>1)? (int)up+"/"+(int)down: (int)up+"";

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }


}
