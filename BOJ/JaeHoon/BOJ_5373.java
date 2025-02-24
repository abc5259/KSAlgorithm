package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_5373 {
    static int N;
    static String[] rolling; //input
    static char[][] front = new char[3][3];
    static char[][] up = new char[3][3];
    static char[][] left = new char[3][3];
    static char[][] right = new char[3][3];
    static char[][] down = new char[3][3];
    static char[][] back = new char[3][3];

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            init(); //매번 큐브배열 초기화
            //input
            N = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            rolling = new String[N + 1];
            for (int i = 0; i < N; i++) {
                rolling[i] = stk.nextToken();
            }
            //run
            solve();
            //output
            for (int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    sb.append(up[i][j]);
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            String roll=rolling[i];
            if (roll.charAt(0) == 'U') {
                UPlus();
                //반시계 방향의 경우 "시계방향x3" 이므로 2번 더 돌려야 함
                if (roll.charAt(1) == '-') {
                    UPlus();
                    UPlus();
                }
            }else if (roll.charAt(0) == 'D') {
                DPlus();
                //반시계 방향의 경우 "시계방향x3" 이므로 2번 더 돌려야 함
                if (roll.charAt(1) == '-') {
                    DPlus();
                    DPlus();
                }
            }else if (roll.charAt(0) == 'F') {
                FPlus();
                //반시계 방향의 경우 "시계방향x3" 이므로 2번 더 돌려야 함
                if (roll.charAt(1) == '-') {
                    FPlus();
                    FPlus();
                }
            }else if (roll.charAt(0) == 'B') {
                BPlus();
                //반시계 방향의 경우 "시계방향x3" 이므로 2번 더 돌려야 함
                if (roll.charAt(1) == '-') {
                    BPlus();
                    BPlus();
                }
            }else if (roll.charAt(0) == 'L') {
                LPlus();
                //반시계 방향의 경우 "시계방향x3" 이므로 2번 더 돌려야 함
                if (roll.charAt(1) == '-') {
                    LPlus();
                    LPlus();
                }
            }else if (roll.charAt(0) == 'R') {
                RPlus();
                //반시계 방향의 경우 "시계방향x3" 이므로 2번 더 돌려야 함
                if (roll.charAt(1) == '-') {
                    RPlus();
                    RPlus();
                }
            }
            //debug 모든 면 출력
//      System.out.println(rolling[i]);
//      allPrint();
        }
    }

    private static void BPlus() {
        rotate(back);
        //up->right->down->left
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=up[0][i]; //copy
        }
        for (int i = 0; i < 3; i++) {
            up[0][i]=right[i][2];
        }
        for (int i = 0; i < 3; i++) {
            right[i][2]=down[2][2-i];
        }
        for (int i = 0; i < 3; i++) {
            down[2][i]=left[i][0];
        }
        for (int i = 0; i < 3; i++) {
            left[i][0]=temp[2-i];
        }
    }

    private static void LPlus() {
        rotate(left);
        //front->up->back->down
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = front[i][0]; //copy
        }
        for (int i = 0; i < 3; i++) {
            front[i][0]=up[i][0];
        }
        for (int i = 0; i < 3; i++) {
            up[i][0]=back[2-i][2];
        }
        for (int i = 0; i < 3; i++) {
            back[2-i][2]=down[i][0];
        }
        for (int i = 0; i < 3; i++) {
            down[i][0]=temp[i];
        }
    }

    private static void DPlus() {
        rotate(down);
        //front->left->back->right
        char[] temp = Arrays.copyOfRange(front[2],0,3); //copy
        for (int i = 0; i < 3; i++) {
            front[2][i]=left[2][i];
        }
        for (int i = 0; i < 3; i++) {
            left[2][i]=back[2][i];
        }
        for (int i = 0; i < 3; i++) {
            back[2][i]=right[2][i];
        }
        for (int i = 0; i < 3; i++) {
            right[2][i]=temp[i];
        }
    }

    private static void FPlus() {
        rotate(front);
        //up->left->down->right
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i]=up[2][i]; //copy
        }
        for (int i = 0; i < 3; i++) {
            up[2][i]=left[2-i][2];
        }
        for (int i = 0; i < 3; i++) {
            left[i][2]=down[0][i];
        }
        for (int i = 0; i < 3; i++) {
            down[0][i]=right[2-i][0];
        }
        for (int i = 0; i < 3; i++) {
            right[i][0]=temp[i]; //방향 주의
        }
    }

    private static void RPlus() {
        rotate(right);
        //front->down->back->up
        char[] temp = new char[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = front[i][2]; //copy
        }
        for (int i = 0; i < 3; i++) {
            front[i][2]=down[i][2];
        }
        for (int i = 0; i < 3; i++) {
            down[i][2]=back[2-i][0];
        }
        for (int i = 0; i < 3; i++) {
            back[2-i][0]=up[i][2];
        }
        for (int i = 0; i < 3; i++) {
            up[i][2]=temp[i];
        }
    }

    private static void UPlus() {
        rotate(up);
        //front->right->back->left
        char[] temp = Arrays.copyOfRange(front[0],0,3); //copy
        for (int i = 0; i < 3; i++) {
            front[0][i]=right[0][i];
        }
        for (int i = 0; i < 3; i++) {
            right[0][i]=back[0][i];
        }
        for (int i = 0; i < 3; i++) {
            back[0][i]=left[0][i];
        }
        for (int i = 0; i < 3; i++) {
            left[0][i]=temp[i];
        }
    }

    //회전로직은 시계방향: B[x][y]=A[N-1-y][x] 를 이용하면 된다.
    private static void rotate(char[][] value) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = value[i][j]; //copy
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                value[i][j] = temp[3-1-j][i];
            }
        }
    }

    private static void init() {
        int cnt=0; //debug
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                up[i][j]='w';
                down[i][j]='y';
                front[i][j]='r';
                back[i][j]='o';
                left[i][j]='g';
                right[i][j]='b';
            }
        }
    }
}
