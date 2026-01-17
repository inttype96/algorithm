import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            // A 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            // B 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            // B 배열 정렬 (이분 탐색을 위함)
            Arrays.sort(B);

            long totalCount = 0;
            for (int a : A) {
                totalCount += countSmallerThan(B, a);
            }

            System.out.println(totalCount);
        }
    }

    // 이분 탐색: B 배열에서 target보다 작은 원소의 개수를 반환
    private static int countSmallerThan(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int count = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] < target) {
                // target보다 작은 값을 찾으면, 그 앞의 값들은 모두 작으므로
                // count를 현재 mid 위치 + 1로 업데이트하고 오른쪽 영역 탐색
                count = mid + 1;
                low = mid + 1;
            } else {
                // target보다 크거나 같으면 왼쪽 영역 탐색
                high = mid - 1;
            }
        }
        return count;
    }
}