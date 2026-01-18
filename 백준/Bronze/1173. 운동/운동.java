import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 목표 운동 시간
        int m = Integer.parseInt(st.nextToken()); // 최소 맥박
        int M = Integer.parseInt(st.nextToken()); // 최대 맥박
        int T = Integer.parseInt(st.nextToken()); // 운동 시 증가량
        int R = Integer.parseInt(st.nextToken()); // 휴식 시 감소량

        int totalTime = 0;    // 전체 걸린 시간
        int exerciseCount = 0; // 실제로 운동한 시간
        int currentPulse = m;  // 현재 맥박

        // 처음부터 운동이 불가능한 경우 체크
        if (m + T > M) {
            System.out.println("-1");
            return;
        }

        while (exerciseCount < N) {
            totalTime++; // 매 분 선택을 하므로 전체 시간은 항상 증가

            if (currentPulse + T <= M) {
                // 운동을 할 수 있는 경우
                currentPulse += T;
                exerciseCount++;
            } else {
                // 운동을 할 수 없어 휴식하는 경우
                currentPulse -= R;
                if (currentPulse < m) {
                    currentPulse = m;
                }
            }
        }

        System.out.println(totalTime);
    }
}