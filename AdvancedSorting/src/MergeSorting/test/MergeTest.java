package MergeSorting.test;

import MergeSorting.sort.Merge;

public class MergeTest {
    public static void main(String[] args) {
        Integer[] a = {8,4,5,7,1,3,6,2,5};
        Merge.sort(a);
        System.out.println(java.util.Arrays.toString(a));
    }
}
