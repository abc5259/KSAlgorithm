package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_21608 {
    static Map<Integer, HashSet> preferences = new HashMap<>();
    static int[][] map;
    static int[] students;
    static int n, sum;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[n][n];
        students = new int[n*n];

        for(int i=0; i<n*n; i++){
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            students[i] = student;
            preferences.put(student, new HashSet<>());
            for(int j=0; j<4; j++){
                preferences.get(student).add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(solve());

    }

    static int solve(){
        for(int i=0; i<students.length; i++){
            Seat seat = findSeat(students[i]);
            map[seat.x][seat.y] = students[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 주변 학생 수에 따라 점수 합산
                int count = getPreferStudentNum(i, j, map[i][j]);
                if (count > 0) {
                    sum += (int) Math.pow(10, count - 1);
                }
            }
        }

        return sum;
    }

    static Seat findSeat(int student){
        Seat seat = null;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] > 0)continue;

                Seat cur = new Seat(i, j, getPreferStudentNum(i, j, student), getEmptySeatNum(i, j));

                //자리 비어있으면 cur을 seat으로 갱신
                if(seat == null){
                    seat = cur;
                    continue;
                }

                //3가지 기준에 따른 비교결과 갱신
                if(seat.compareTo(cur)>0)seat=cur;
            }
        }
        return seat;
    }

    static int getPreferStudentNum(int x, int y, int student){
        int count = 0;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=n || ny>=n)continue;

            if(preferences.get(student).contains(map[nx][ny])){
                count++;
            }
        }
        return count;
    }

    static int getEmptySeatNum(int x, int y){
        int count = 0;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=n || ny>=n)continue;

            if(map[nx][ny] == 0)count++;

        }
        return count;
    }


    static class Seat implements Comparable<Seat>{
        int x,y;
        int preferStudentNum;
        int emptySeatNum;

        public Seat(int x, int y, int preferStudentNum, int emptySeatNum){
            this.x = x;
            this.y = y;
            this.preferStudentNum = preferStudentNum;
            this.emptySeatNum = emptySeatNum;
        }

        @Override
        public int compareTo(Seat other) {
            //인접 좋아하는 친구 수
            if(preferStudentNum != other.preferStudentNum){
                return -(preferStudentNum-other.preferStudentNum);
            }
            //인접 빈칸 수
            if(emptySeatNum != other.emptySeatNum){
                return -(emptySeatNum-other.emptySeatNum);
            }
            //행
            if(x != other.x) return x-other.x;
            //열
            return y-other.y;
        }
    }
}
