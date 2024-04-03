package BOJ.JaeIk.practice.swea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class 암호생성기
{
    static Queue<Integer> crypt;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++) {
            br.readLine();

            crypt = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<8; i++) {
                crypt.add(Integer.parseInt(st.nextToken()));
            }

            boolean flag = true;
            while(flag) {
                for(int i=1; i<=5; i++) {
                    int now = crypt.poll();
                    int move = now-i;

                    if(move<=0) {
                        flag=false;
                        crypt.add(0);
                        break;
                    }

                    crypt.add(move);
                }
            }

            System.out.print("#"+(tc+1));
            for(int c : crypt) {
                System.out.print(" "+c);
            }
            System.out.println();
        }
    }
}