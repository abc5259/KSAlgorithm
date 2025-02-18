package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 시물레이션
// 3 가지 큰 처리가 반복 ( 낚시왕이 이동해서 상어를 잡는다. => 상어들이 이동 => 겹치는 상어들 정리 )
// Shark 5개 필드를 가지는 클래스 정의
// 이차원 배열 + ArrayList  사용
// s (스피드) 에 따른 상어 각각의 이동시 s 만큼 움직이면 시간 손해
//      =>좌우 또는 상하 이동 과정에서 제자리로 복귀하는 count  미리 계산해서 s (스피드) 를 나는 나머지만 실제로 이동
public class BOJ_17143_1 {
    static int R, C, M, sum; // 잡은 상어크기의 합
    static Shark[][] map;
    static List<Shark> list = new ArrayList<>();

    // 상->하->우->좌 (순서 필요)
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        // 입력, 자료구조
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R + 1][C + 1]; // 0 dummy

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            Shark shark = new Shark(r, c, s, d - 1, z); // 문제의 상하우좌 가 1234로 된 부분 보정
            list.add(shark);
            map[r][c] = shark;
        }
        // 상저 잡기 시작
        // 반복횟수( 컬럼 길이 ) 고정 => for
        for (int i = 1; i <= C; i++) {
            catchShark(i); // col 전달
            moveShark();
            killShark();
        }

        System.out.println(sum);
    }

    // 현재 자리에서 상어 잡기
    static void catchShark(int col) {
        // 밑으로(row) 내려가면서 상어를 만나면 sum 추가, list 제거 (정제), 뒤에서 한꺼번에 list를 이용해서 map 정리한다.
        for (int i = 1; i <= R; i++) {
            if (map[i][col] != null) { // 상어를 발견하면
                sum += map[i][col].z;
                list.remove(map[i][col]);
                break;
            }
        }
    }

    // 상어들이 이동
    // map 이 아닌 ArrayList 에서 진행
    static void moveShark() {
        for (Shark shark : list) {
            int r = shark.r;
            int c = shark.c;
            int s = shark.s; // max 가 1000
            int d = shark.d;

            switch (d) {
                // 상하, 좌우 따로 나누어서 각 R, C 를 이용해서 제자리로 오는 계산을 이용한 보정

                // 상하(R 이용)
                case 0:
                case 1:
                    s = s % (R * 2 - 2); // shark 객체의 s 는 변화 X
                    for (int i = 0; i < s; i++) { // r 만 고려
                        if (r == 1) d = 1; // 꼭대기 : 상 => 하
                        else if (r == R) d = 0; // 바닥 : 하 => 상
                        r += dy[d];
                    }
                    shark.r = r;
                    shark.d = d;
                    break;

                // 우좌(C 이용)
                case 2:
                case 3:
                    s = s % (C * 2 - 2);
                    for (int i = 0; i < s; i++) { // c 만 고려
                        if (c == 1) d = 2; // 왼쪽끝 : 좌 => 우
                        else if (c == C) d = 3; // 오른쪽끝 : 우 => 좌
                        c += dx[d];
                    }
                    shark.c = c;
                    shark.d = d;
                    break;
            }
        }
    }

    // 같은 위치의 큰 상어가 작은 상어를 잡아 먹는다.
    // list (정제된) shark 데이터를 이용해서 map[][] 초기화
    static void killShark() {
        // map null 초기화
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                map[i][j] = null;
            }
        }

        // list 로부터 정제된(계산된) Shark 객체를 하나씩 처리
        // 겹치는 상어에 대한 처리 (삭제는 list에서 처리)
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            Shark s = list.get(i);

            if (map[s.r][s.c] == null) { // 초기화 후 빈 공간일 경우 처음 온 shark
                map[s.r][s.c] = s;
            } else if (s.z > map[s.r][s.c].z) { // // 초기화 후 먼저 자리잡은 shark 가 있다. 꺼낸 s.z 가 더 큰 경우
                // map[s.r][s.c] 를 삭제
                list.remove(map[s.r][s.c]);
                map[s.r][s.c] = s;
            } else { // 이미 자리잡은 상어를 그대로 두고 꺼낸 s 삭제
                list.remove(s);
            }
        }

    }

    static class Shark {
        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
