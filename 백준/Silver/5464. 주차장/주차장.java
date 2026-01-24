import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 주차 공간 수
        int M = Integer.parseInt(st.nextToken()); // 차량 수

        int[] parkingFee = new int[N + 1]; // 주차 공간 단위 요금
        for (int i = 1; i <= N; i++) {
            parkingFee[i] = Integer.parseInt(br.readLine());
        }

        int[] carWeight = new int[M + 1]; // 차량 무게
        for (int i = 1; i <= M; i++) {
            carWeight[i] = Integer.parseInt(br.readLine());
        }

        // 빈 주차 공간을 관리 (가장 작은 번호부터 나오도록 우선순위 큐 사용)
        PriorityQueue<Integer> emptySpaces = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            emptySpaces.add(i);
        }

        // 각 차량이 현재 어느 주차 공간에 있는지 저장
        int[] carLocation = new int[M + 1];
        // 대기 차량 큐
        Queue<Integer> waitingQueue = new LinkedList<>();

        long totalRevenue = 0;

        // 2*M 개의 출입 기록 처리
        for (int i = 0; i < 2 * M; i++) {
            int action = Integer.parseInt(br.readLine());

            if (action > 0) { // 입차
                int carNum = action;
                if (emptySpaces.isEmpty()) {
                    // 빈 자리가 없으면 대기열로
                    waitingQueue.add(carNum);
                } else {
                    // 빈 자리 중 가장 작은 번호 선택
                    int spaceNum = emptySpaces.poll();
                    carLocation[carNum] = spaceNum;
                    totalRevenue += (long) carWeight[carNum] * parkingFee[spaceNum];
                }
            } else { // 출차
                int carNum = -action;
                int releasedSpace = carLocation[carNum];
                emptySpaces.add(releasedSpace);

                // 자리가 비었으니 대기열 확인
                if (!waitingQueue.isEmpty()) {
                    int waitingCar = waitingQueue.poll();
                    int nextSpace = emptySpaces.poll();
                    carLocation[waitingCar] = nextSpace;
                    totalRevenue += (long) carWeight[waitingCar] * parkingFee[nextSpace];
                }
            }
        }

        System.out.println(totalRevenue);
    }
}