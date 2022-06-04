package fis.java.core.topic01.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilTest {
    @Test
    public void findMinMax(){
        int data[] = {1, 3, 2};
        ArrayUtil.MinMax minMax = ArrayUtil.findMinMax(data);
        assertEquals(1, minMax.min);
        assertEquals(3, minMax.max);
    }

}