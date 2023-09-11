package pe.sommesommee.example;

import java.util.*;

public class BurgerTime {

    /*만약 두개의 배열 int[] a 와 int[] b가 있는데 a엔 햄버거를 전자레인지에 데우는데에 걸리는 시간이 있고 b에는 햄버거를 먹는데 걸리는 시간이 있어 a 와 b의 크기는 같고 같은 인덱스는 같은 햄버거야 식당을 운영하는 김모씨는 두개의 배열정보를 기준으로 최소로 걸리는 시간을 찾고자 해 단 모든 햄버거는 전자레인지에 데운 후에만 먹을 수 있고 한번에 1개만 데울 수 있어 배열 a와 b가 2부터 시작해서 10000 사이의 자연수 일 때 어떻게 최적의 시간을 찾을까*/
    public static void main(String[] args) {
        int[] a = {5, 3, 7};
        int[] b = {4, 5, 6};

        int n = a.length;

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        //가장 먹는데에 시간이 오래걸리는 햄버거부터 먹는다.
        Arrays.sort(order, (o1, o2) -> b[o2] - b[o1]);

        int totalTime = 0;
        int microwaveTime = 0;

        for (int i = 0; i < n; i++) {
            //microwaveTime 은 총 전자레인지 시간의 누계
            //totalTime 은 누계된 전자레인지의 시간 + 먹는시간
            //totalTime 은 현재 햄버거를 먹는시간과 이전 totalTime을 비교해서 더 큰 값을 체택하므로써, 더 빠른 효율을 찾는다.

            microwaveTime += a[order[i]];
            totalTime = Math.max(totalTime, microwaveTime + b[order[i]]);
        }

        System.out.println("최소로 걸리는 시간: " + totalTime);
    }
}