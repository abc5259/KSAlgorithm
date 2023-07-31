package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2016 {
    static int[][] boys;
    static int[][] girls;
    static boolean[] isUsed;

    static boolean init;
    static int maxGirl;
    static boolean isOk = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();

        for(int t=0; t<T; t++) {
            boys = new int[5][5];
            girls = new int[5][5];
            isUsed = new boolean[5];

            for(int i=1; i<=4; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<=4; j++) {
                    boys[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<5; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<5; j++) {
                    girls[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve(0);
            if(isOk) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");

            init = false;
            isOk = false;
        }
        System.out.println(sb);
    }

    public static void solve(int depth) {
        if(isOk) return;
        if(depth == 5) {
            int girl = check();
            if(!init) {
                maxGirl = girl;
                init = true;
                return;
            }

            int prevPrefer = 0;
            int curPrefer = 0;
            for(int i=0; i<5; i++) {
                if(i+6 == maxGirl) prevPrefer = i;
                if(i+6 == girl) curPrefer = i;
            }

            if(prevPrefer > curPrefer) {
                maxGirl = girl;
                isOk = true;
            }
            return;
        }

        for(int i=6; i<=10; i++) {
            if(!isUsed[i-6]) {
                boys[0][depth] = i;
                isUsed[i-6] = true;
                solve(depth+1);
                isUsed[i-6] = false;
            }
        }
    }

    public static int check() {
        int[] boyMath = new int[5];
        boolean[][] boySpurn = new boolean[5][5];

        boolean[] isSpurn = new boolean[5];
        boolean isStart = true;
        while (true) {
            ArrayList<Integer> girlList=  new ArrayList<>();
            for(int i=6; i<=10; i++) {
                if(isStart) girlList.add(i);
                else {
                    if(isSpurn[i-6]) girlList.add(i);
                }
            }

            for(int girl: girlList) {
                int i = girl;
                int curGirlIdx = i-6;

                //프로포즈 시작
                for(int j=0; j<5; j++) {
                    int preferBoy = girls[curGirlIdx][j];
                    int preferBoyIdx = preferBoy - 1;

                    //퇴짜를 놓은적 있다면 그 다음 순위의 남학생으로
                    if(boySpurn[preferBoyIdx][curGirlIdx]) continue;

                    //퇴짜를 놓은적 없다면
                    //해당 남학생이 이미 짝이 있다면
                    if(boyMath[preferBoyIdx] > 0) {
                        //두명에 대한 선호도 조사
                        int matchGirlPrefer = 0;
                        int curGirlPrefer = 0;
                        for(int l=0; l<5; l++) {
                            if(boys[preferBoyIdx][l] == i) {
                                curGirlPrefer = l;
                            }
                            if(boys[preferBoyIdx][l] == boyMath[preferBoyIdx]) {
                                matchGirlPrefer = l;
                            }
                        }

                        //매치된 짝보다 현재 여학생이 선호도가 놓다면
                        if(matchGirlPrefer > curGirlPrefer) {
                            //현재 여학생을 짝으로하고 매치된 짝에게 퇴짜
                            int mathGirIdx = boyMath[preferBoyIdx] - 6;
                            boySpurn[preferBoyIdx][mathGirIdx] = true;
                            boySpurn[preferBoyIdx][curGirlIdx] = false;
                            isSpurn[mathGirIdx] = true;
                            isSpurn[curGirlIdx] = false;
                            boyMath[preferBoyIdx] = i;
                        }else { //매치된 짝이 더 선호도가 높다면
                            //현재 여학생에게 퇴짜
                            boySpurn[preferBoyIdx][curGirlIdx] = true;
                            isSpurn[curGirlIdx] = true;
                        }
                    }else { //짝이 없다면
                        // 프로포즈 무조건 받음
                        isSpurn[curGirlIdx] = false;
                        boySpurn[preferBoyIdx][curGirlIdx] = false;
                        boyMath[preferBoyIdx] = i;
                    }

                    break;
                }
            }
            isStart = false;
            // 짝을 다 찾았는지
            boolean finish = true;
            for(int i=0; i<5; i++) {
                if(boyMath[i] == 0) finish = false;
            }
            if(finish) break;

        }

        return boyMath[0];
    }
}