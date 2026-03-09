import java.io.*;
import java.util.*;

class Main {
    static long t;
    static int n;
    static long[] prefixA;
    static int m;
    static long[] prefixB;
    static List<Long> subArrA;
    static List<Long> subArrB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Long.parseLong(br.readLine());
        n = Integer.parseInt(br.readLine());
        prefixA = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            sum += tmp;
            prefixA[i] = sum;
        }
        m = Integer.parseInt(br.readLine());
        prefixB = new long[m + 1];
        st = new StringTokenizer(br.readLine());

        sum = 0;
        for (int i = 1; i <= m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            sum += tmp;
            prefixB[i] = sum;
        }

        subArrA = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                subArrA.add(prefixA[j] - prefixA[i]);
            }
        }
        subArrB = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            for (int j = i + 1; j <= m; j++) {
                subArrB.add(prefixB[j] - prefixB[i]);
            }
        }
        subArrA.sort(Comparator.naturalOrder());
        subArrB.sort(Comparator.naturalOrder());

        int pointA = 0;
        int pointB = subArrB.size() - 1;

        long res = 0;
        while (true) {
            if (pointA >= subArrA.size() || pointB < 0) {
                break;
            }

            long tmp = subArrA.get(pointA) + subArrB.get(pointB);

            if (tmp == t) { // 같은 것을 찾을 필요
                long countA = 1;
                long countB = 1;
                while(true) {
                    if(pointA+1 >= subArrA.size()) break;
                    if(subArrA.get(pointA+1).equals(subArrA.get(pointA))) {
                        pointA +=1;
                        countA +=1;
                        continue;
                    }
                    break;
                }
                while(true) {
                    if(pointB-1 < 0) break;
                    if(subArrB.get(pointB-1).equals(subArrB.get(pointB))) {
                        pointB -=1;
                        countB +=1;
                        continue;
                    }
                    break;
                }

                res += countA * countB;
                pointA +=1;
                pointB -=1;
                continue;
            }
            if (tmp > t) {
                pointB -= 1;
                continue;
            }
            if (tmp < t) {
                pointA += 1;
                continue;
            }
        }

        System.out.println(res);
    }
}
// 하나의 배열에서 부 배열 개수 1000C2 = 500000;