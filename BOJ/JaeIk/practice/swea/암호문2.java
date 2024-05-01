package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class 암호문2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++){
            //암호문 길이
            int n = Integer.parseInt(br.readLine());

            //원본 암호문
            List<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<n; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }

            //명령어 개수
            int cmd_length = Integer.parseInt(br.readLine());

            //명령어
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<cmd_length; i++){
                String cmd = st.nextToken();

                //삽입
                if(Objects.equals(cmd, "I")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int j=0; j<y; j++){
                        int add = Integer.parseInt(st.nextToken());
                        list.add(x+j, add);
                    }
                }

                //삭제
                else if(Objects.equals(cmd, "D")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int j=0; j<y; j++){
                        list.remove(x);
                    }
                }
            }

            System.out.print("#"+(tc+1)+" ");
            for(int i=0; i<10; i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
}
