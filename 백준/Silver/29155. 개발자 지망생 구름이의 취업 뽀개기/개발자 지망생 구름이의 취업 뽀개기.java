import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] pCount = new int[6]; // 난이도별 풀어야 하는 문제 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 5; i++) {
            pCount[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer>[] levels = new ArrayList[6];
        for (int i = 1; i <= 5; i++) {
            levels[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            levels[k].add(t);
        }

        long totalTime = 0;
        Integer lastTime = null; // 직전에 푼 문제의 시간

        for (int i = 1; i <= 5; i++) {
            // 1. 해당 난이도의 문제들을 오름차순 정렬
            Collections.sort(levels[i]);
            
            // 2. 난이도가 바뀔 때의 휴식 시간 (난이도 1 시작 시 제외)
            if (i > 1) {
                totalTime += 60;
            }

            // 3. 해당 난이도에서 pCount[i]개만큼 문제 풀기
            for (int j = 0; j < pCount[i]; j++) {
                int currentTime = levels[i].get(j);
                
                // 문제 푸는 시간 더하기
                totalTime += currentTime;
                
                // 같은 난이도 내에서의 휴식 시간 (해당 난이도의 첫 문제가 아닐 때)
                if (j > 0) {
                    totalTime += Math.abs(currentTime - levels[i].get(j - 1));
                }
                
                lastTime = currentTime;
            }
        }

        System.out.println(totalTime);
    }
}