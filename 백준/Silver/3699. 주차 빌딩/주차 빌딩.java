import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    // 차의 위치 정보를 저장할 클래스
    static class Car {
        int floor, pos;
        Car(int floor, int pos) {
            this.floor = floor;
            this.pos = pos;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            Car[] cars = new Car[H * L + 1];
            int totalCars = 0;

            // 주차 빌딩 정보 입력 및 차량 위치 저장
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < L; j++) {
                    int carNum = Integer.parseInt(st.nextToken());
                    if (carNum != -1) {
                        cars[carNum] = new Car(i, j);
                        totalCars = Math.max(totalCars, carNum);
                    }
                }
            }

            // 각 층의 컨베이어 벨트가 현재 얼마나 회전되어 있는지 저장 (offset)
            int[] floorOffset = new int[H];
            long totalTime = 0;

            // 1번 손님부터 순서대로 차를 찾음
            for (int i = 1; i <= totalCars; i++) {
                if (cars[i] == null) continue;

                int f = cars[i].floor;
                int p = cars[i].pos;

                // 1. 엘리베이터 왕복 시간 (층당 10초)
                totalTime += (long) f * 20;

                // 2. 컨베이어 벨트 회전 시간 계산
                // 현재 벨트의 0번 위치(엘리베이터 앞)를 기준으로 실제 상대 위치 계산
                int currentPos = (p - floorOffset[f] + L * 100) % L;
                
                // 최단 거리 (시계 vs 반시계)
                int dist = Math.min(currentPos, L - currentPos);
                totalTime += (long) dist * 5;

                // 3. 차를 꺼낸 후 벨트의 상태 업데이트 (offset 변경)
                // 차가 있던 p번 위치가 엘리베이터 앞(0번)으로 오도록 벨트가 돌아감
                floorOffset[f] = p;
            }

            System.out.println(totalTime);
        }
    }
}