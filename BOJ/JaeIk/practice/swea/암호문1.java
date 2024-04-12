package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 암호문1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++){
            //암호문 길이
            int length = Integer.parseInt(br.readLine());

            //원본 암호문
            List<Integer> original = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<length; i++){
                original.add(Integer.parseInt(st.nextToken()));
            }

            //명령어 개수
            int number = Integer.parseInt(br.readLine());

            //명령어
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<number; i++){
                if(st.nextToken().equals("I")){
                    int location = Integer.parseInt(st.nextToken());
                    int numberToAdd = Integer.parseInt(st.nextToken());

                    for(int j=0; j<numberToAdd; j++){
                        int change = Integer.parseInt(st.nextToken());
                        original.add(location++, change);
                    }
                }
            }
            System.out.print("#"+(tc+1)+" ");
            for(int i=0; i<10; i++){
                System.out.print(original.get(i)+" ");
            }
            System.out.println();
        }
    }
}
