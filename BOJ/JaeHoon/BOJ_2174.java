package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2174 {
  static Robot[] robots;
  static boolean[][] isLocated;
  static int A;
  static int B;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    robots = new Robot[N+1];
    isLocated = new boolean[B+1][A+1];
    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      char d = st.nextToken().charAt(0);
      isLocated[B-y+1][x] = true;
      robots[i] = new Robot(x, y, d);
    }
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int index = Integer.parseInt(st.nextToken());
      char command = st.nextToken().charAt(0);
      int repeat = Integer.parseInt(st.nextToken());
      solve(index, command, repeat);
    }
    System.out.println("OK");
  }
  public static void solve(int index, char command, int repeat) {
    Robot robot = robots[index];
    switch(command) {
      case 'R':
      case 'L':
        repeat = repeat % 4;
        for(int i=0; i<repeat; i++)
          robot.direction = changeDirection(command,robot.direction);
        break;
      case 'F':
        for(int i=0; i<repeat; i++)
          go(robot, index);
        break; 
    }
  }
  public static void go(Robot robot,int number) {
    int nextX = robot.x;
    int nextY = robot.y;
    switch(robot.direction) {
      case 'N':
        nextY += 1;
        break;
      case 'E':
        nextX += 1;
        break;
      case 'S':
        nextY -= 1;
        break;
      case 'W':
        nextX -= 1;
        break;
    }
    if(nextX < 1 || nextX > A || nextY < 1 || nextY > B ) {
      System.out.println("Robot " + number + " crashes into the wall");
      System.exit(0);
    }
    if(isLocated[B-nextY+1][nextX]) {
      for(int i=1; i<robots.length; i++) {
        if(robots[i].x == nextX && robots[i].y == nextY) {
          System.out.println("Robot " + number + " crashes into robot " + i);
          System.exit(0);
        }
      }
    }
    isLocated[B-nextY+1][nextX] = true;
    isLocated[B-robot.y+1][robot.x] = false;
    robot.x = nextX;
    robot.y = nextY;
  }
  public static char changeDirection(char command, char robotDirection) {
    if(command == 'L') {
      switch(robotDirection) {
        case 'N':
          return 'W';
        case 'E':
          return 'N';
        case 'S':
          return 'E';
        case 'W':
          return 'S';
        default:
          return ' ';
      }
    }else {
      switch(robotDirection) {
        case 'N':
          return 'E';
        case 'E':
          return 'S';
        case 'S':
          return 'W';
        case 'W':
          return 'N';
        default:
          return ' ';
      }
    }
  }
  static class Robot {
    int x,y;
    char direction;
    Robot(int x, int y, char direction) {
      this.x = x;
      this.y = y;
      this.direction = direction;
    }
  }
}
