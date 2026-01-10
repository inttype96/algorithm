import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        int n = arr.length;

        int zeroCount = 0;
        int oneCount = 0;

        // 1. 전체 0과 1의 개수를 세어 제거해야 할 목표치 설정
        for (char c : arr) {
            if (c == '0') zeroCount++;
            else oneCount++;
        }
        
        int removeZero = zeroCount / 2;
        int removeOne = oneCount / 2;

        // 2. 앞에서부터 '1'을 찾아 제거 (사전순으로 작게 만들기 위함)
        for (int i = 0; i < n && removeOne > 0; i++) {
            if (arr[i] == '1') {
                arr[i] = 'X'; // 제거된 문자는 'X'로 표시
                removeOne--;
            }
        }

        // 3. 뒤에서부터 '0'을 찾아 제거 (0을 최대한 앞에 남기기 위함)
        for (int i = n - 1; i >= 0 && removeZero > 0; i--) {
            if (arr[i] == '0') {
                arr[i] = 'X';
                removeZero--;
            }
        }

        // 4. 'X'가 아닌 문자만 결과에 담아 출력
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != 'X') {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}