package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 암호문3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++){
            int originalNumber = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            LinkedList<Integer> original = new LinkedList<>();
            for(int i=0; i<originalNumber; i++){
                original.add(Integer.parseInt(st.nextToken()));
            }

            int commandNumber = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<commandNumber; i++){
                String input = st.nextToken();

                if(input.equals("I")){
                    int idx = Integer.parseInt(st.nextToken());
                    int number = Integer.parseInt(st.nextToken());

                    //System.out.print(i+"번쩨 명령 I 실행 결과 : ");
                    for(int j=0; j<number; j++){
                        original.add(idx++, Integer.parseInt(st.nextToken()));
                      //  System.out.print(original.get(idx-1)+" ");
                    }
                }

                if(input.equals("D")){
                    int idx = Integer.parseInt(st.nextToken());
                    int number = Integer.parseInt(st.nextToken());

                    //System.out.print(i+"번쩨 명령 D 실행 결과 : ");
                    for(int j=0; j<number; j++){
                        original.remove(idx++);
                    }

                }

                if(input.equals("A")){
                    int number = Integer.parseInt(st.nextToken());

                    for(int j=0; j<number; j++){
                        original.add(Integer.parseInt(st.nextToken()));
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
