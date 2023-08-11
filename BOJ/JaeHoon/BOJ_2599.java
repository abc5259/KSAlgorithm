package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2599 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] studentArr = new int[3][2];

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                studentArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[3][3];

        boolean isOk = true;
        for(int i=0; i<3; i++) {
            int men = studentArr[i][0];

            if(i == 0) {
                if(studentArr[i+1][1] + studentArr[i+2][1] < men) {
                    isOk = false;
                    break;
                }

                int bCnt = 0;
                while (studentArr[i+1][1] > 0 && men > bCnt) {
                    if(studentArr[i][1] + studentArr[i+1][1] - 1>= studentArr[i+2][0]) {
                        studentArr[i+1][1]--;
                        bCnt++;
                    }else {
                        break;
                    }
                }

                result[0][1] = bCnt;
                if(men == bCnt) continue;
                men -= bCnt;
                int cCnt = 0;
                while (studentArr[i+2][1] > 0 && men > cCnt) {
                    if(studentArr[i][1] + studentArr[i+2][1] - 1>= studentArr[i+1][0]) {
                        studentArr[i+2][1]--;
                        cCnt++;
                    }else {
                        break;
                    }
                }

                if(men != cCnt) {
                    isOk = false;
                    break;
                }

                result[0][2] = cCnt;
            }
            else if(i == 1) {
                if(studentArr[0][1] + studentArr[2][1] < men) {
                    isOk = false;
                    break;
                }

                int aCnt = 0;
                while (studentArr[0][1] > 0 && men > aCnt) {
                    if(studentArr[0][1] + studentArr[1][1] - 1>= studentArr[2][0]) {
                        studentArr[0][1]--;
                        aCnt++;
                    }else {
                        break;
                    }
                }

                result[1][0] = aCnt;
                if(men == aCnt) continue;
                men -= aCnt;
                int cCnt = men;

                if(studentArr[2][1] < cCnt) {
                    isOk = false;
                    break;
                }

                studentArr[2][1] -= cCnt;

                result[1][2] = cCnt;
            }else {
                if(studentArr[0][1] + studentArr[1][1] < men) {
                    isOk = false;
                    break;
                }

                result[2][0] = studentArr[0][1];
                result[2][1] = studentArr[1][1];
            }
        }

        if(!isOk) {
            System.out.println(0);
        }else {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    if(i == j) continue;
                    sb.append(result[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(1);
            System.out.println(sb);
        }
    }
}

//6
//1 1
//1 3
//4 2
