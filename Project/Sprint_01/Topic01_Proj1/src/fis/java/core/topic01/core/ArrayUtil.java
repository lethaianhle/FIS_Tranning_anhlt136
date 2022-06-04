package fis.java.core.topic01.core;

public class ArrayUtil {
    static class MinMax {
        public int min;
        public int max;
    }

    public static MinMax findMinMax(int[] data){
        MinMax minMax = new MinMax();
        minMax.min = data[0];
        minMax.max = data[1];

        return minMax;
    }
}


