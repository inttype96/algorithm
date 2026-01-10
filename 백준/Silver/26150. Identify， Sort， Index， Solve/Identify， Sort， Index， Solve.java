import java.util.*;

public class Main {
    // 문제를 관리할 클래스 정의
    static class Problem implements Comparable<Problem> {
        String title;
        int id;
        int difficulty;

        public Problem(String title, int id, int difficulty) {
            this.title = title;
            this.id = id;
            this.difficulty = difficulty;
        }

        // 번호(id) 기준 오름차순 정렬 설정
        @Override
        public int compareTo(Problem o) {
            return Integer.compare(this.id, o.id);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        List<Problem> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int id = sc.nextInt();
            int d = sc.nextInt();
            list.add(new Problem(s, id, d));
        }

        // 1. Sort: 문제 번호 순서대로 정렬
        Collections.sort(list);

        // 2. Index & Solve: 글자 추출 및 변환
        StringBuilder sb = new StringBuilder();
        for (Problem p : list) {
            // D번째 글자 추출 (인덱스는 0부터이므로 D-1)
            char target = p.title.charAt(p.difficulty - 1);
            
            // 소문자라면 대문자로 변환
            if (Character.isLowerCase(target)) {
                target = Character.toUpperCase(target);
            }
            sb.append(target);
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}