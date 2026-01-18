import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 정보의 개수 n 입력
        int n = Integer.parseInt(br.readLine());
        
        // 학생들을 관리할 큐 (Java에서는 Deque/ArrayDeque가 속도가 빠릅니다)
        Deque<Integer> queue = new ArrayDeque<>();
        
        int maxCount = 0;      // 최대 대기 학생 수
        int lastStudentId = 0; // 그때의 맨 뒤 학생 번호
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            
            if (type == 1) {
                // 유형 1: 학생이 줄을 섬
                int studentId = Integer.parseInt(st.nextToken());
                queue.addLast(studentId);
                
                // 현재 대기 학생 수 확인
                int currentSize = queue.size();
                
                // 최대 학생 수 갱신 조건 확인
                if (currentSize > maxCount) {
                    maxCount = currentSize;
                    lastStudentId = studentId;
                } else if (currentSize == maxCount) {
                    // 학생 수가 같은 경우, 번호가 더 작은 경우를 선택
                    if (studentId < lastStudentId) {
                        lastStudentId = studentId;
                    }
                }
            } else {
                // 유형 2: 맨 앞 학생이 식사 시작
                if (!queue.isEmpty()) {
                    queue.removeFirst();
                }
            }
        }
        
        // 결과 출력
        System.out.println(maxCount + " " + lastStudentId);
    }
}