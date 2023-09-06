package BOJ.JaeIk;

import java.io.*;

public class BOJ_4779 {
    static int n;
    static StringBuilder sb;
    static char[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;

        while((str = br.readLine()) != null){
            n = Integer.parseInt(str);
            sb = new StringBuilder();

            int size = (int)Math.pow(3, n);

            for(int i=0; i<size; i++){
                sb.append("-");
            }
            cantor(0, size);

            System.out.println(sb);

        }
    }

    static void cantor(int start, int size){
        if(size==1)return;

        for(int i=start+size/3; i<start+2*(size/3); i++){
            sb.setCharAt(i, ' ');
        }

        cantor(start, size/3);

        cantor(start+size/3*2, size/3);
    }
}
