package BOJ.JaeIk.practice.swea;

import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;


class 간단한압축풀기
{
    static int[] prime = {2, 3, 5, 7, 11};
    static BufferedReader br;
    public static void main(String args[]) throws Exception
    {

        br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        for(int tc=0; tc<input; tc++) {
            int fileAmount = Integer.parseInt(br.readLine());

            List<String> data_list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<fileAmount; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String data = st.nextToken();
                int amount = Integer.parseInt(st.nextToken());

                for(int j=0; j<amount; j++) {
                    data_list.add(data);
                }
            }

            System.out.print("#"+(tc+1));
            System.out.println(unzip(data_list));
        }
    }

    static String unzip(List<String> data_list) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<data_list.size(); i++) {
            if(i%10 == 0)sb.append("\n");
            sb.append(data_list.get(i));
        }

        return sb.toString();
    }
}

