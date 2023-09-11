package pe.sommesommee.java8;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Test {
    /*
    형변환
    */
    public void typeCasting(){

        //int -> String
        int num1 = 1;
        String str1 = Integer.toString(num1);
        System.out.println(str1);

        //String -> int
        String str2 = "2";
        int num2 = Integer.parseInt(str2);
        System.out.println(num2);

        //String -> char[]
        String str3 = "hello world";
        char[] charArr1 = str3.toCharArray();

        //char[] -> String
        char[] charArr2 = {'a', 'b', 'c'};
        String str4 = new String(charArr2);
    }

    /*
    배열 더하기
    */
    public void sumArr(){

        //int[] sum
        int[] intArr = {1, 5, 3};
        int sum = IntStream.of(intArr).sum();
        System.out.println(sum);
    }

    /*
    배열 중복 제거 하기
     */
    public void distinctArr(){
        int[] intArr = {1, 1, 5, 5, 3};
        int[] intArrDistinct = IntStream.of(intArr).distinct().toArray();
        System.out.println(Arrays.toString(intArrDistinct));
    }



    /*
    배열 정렬
    */
    public void arraySort(){
        int[] intArr = {3, 1, 2, 6, 7, 5};

        //Arrays 정방향 정렬
        Arrays.sort(intArr);
        for(int num : intArr){
            System.out.print(num);
        }

        //스트림 : 정방향 정렬
        intArr = IntStream.of(intArr)
                .sorted()
                .toArray();
        for(int num : intArr){
            System.out.print(num);
        }

        //스트림 : 역방향 정렬 (boxing 처리 및 복구 과정 필요)
        intArr = IntStream.of(intArr)
                .boxed()
                .sorted((a,b) -> b.compareTo(a))
                .mapToInt(Integer::intValue)
                .toArray();
        for(int num : intArr){
            System.out.print(num);
        }

    }

    /*
    인덱스가 같은 두개의 배열을 합하는 커스텀 튜플 클래스 작성
     */
    static class Tuple{
        int a;
        int b;

        Tuple(int a, int b){
            a = a;
            b = b;
        }
    }

    /*
    특정 키 기준 튜플 정렬하기
     */
    public void sortTuple(){

        Tuple[] tupleArr = {new Tuple(1, 3), new Tuple(1, 2)};

        //stream 방식 정렬
        Tuple[] sortedTupleArr = (Tuple[]) Stream.of(tupleArr).sorted((t1, t2) -> t2.b - t1.b).toArray();

        //Arrays 정렬 (메모리, 성능 이점)
        Arrays.sort(tupleArr, (t1, t2) -> t2.b - t1.b);

    }
}
