import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] snow = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        
        // 시뮬레이션 시작
        while (true) {
            // 1. 눈이 많이 쌓인 순서대로 정렬
            Arrays.sort(snow);
            
            // 가장 눈이 많은 집이 0이면 모든 눈이 치워진 것
            if (snow[N - 1] == 0) break;
            
            // 2. 1440분이 넘어가면 실패
            if (time > 1440) {
                time = -1;
                break;
            }

            // 3. 가장 눈 많은 두 집 선택 (집이 하나뿐이면 한 집만)
            if (N >= 2 && snow[N - 2] > 0) {
                snow[N - 1]--;
                snow[N - 2]--;
            } else {
                snow[N - 1]--;
            }
            
            time++;
        }
        
        // 최종 결과 출력 (마지막에 time++이 된 후 1440을 넘었는지 확인)
        System.out.println(time > 1440 ? -1 : time);
    }
}