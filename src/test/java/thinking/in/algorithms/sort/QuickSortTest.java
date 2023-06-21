package thinking.in.algorithms.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *
 * @author authoralankay
 * @since TODO
 */
class QuickSortTest {

    Set<int[]> testSet = new HashSet<>();

    @BeforeEach
    void initTestSet() {

        testSet.clear();

        // 空数组
        testSet.add(new int[0]);

        // 单个元素的数组
        testSet.add(new int[]{5});

        // 有序数组
        testSet.add(new int[]{1, 2, 3, 4, 5});

        // 逆序数组
        testSet.add(new int[]{5, 4, 3, 2, 1});

        // 随机顺序的数组
        testSet.add(new int[]{3, 1, 4, 2, 5});

        // 重复元素的数组
        testSet.add(new int[]{2, 4, 2, 1, 4, 3, 1, 5});

        // 大规模数组
        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = largeArray.length - i;
        }
        testSet.add(largeArray);
    }

    @Test
    void partitionTest() {
        
        for (int[] nums : testSet) {
            int[] sorted = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sorted);
            
            int[] first = Arrays.copyOf(nums, nums.length);
            QuickSort.partition(first, 0, first.length - 1, QuickSort.Pivot.FIRST);
            assertArrayEquals(sorted, first);

            int[] middle = Arrays.copyOf(nums, nums.length);
            QuickSort.partition(middle, 0, middle.length - 1, QuickSort.Pivot.MIDDLE);
            assertArrayEquals(sorted, middle);

            int[] last = Arrays.copyOf(nums, nums.length);
            QuickSort.partition(last, 0, last.length - 1, QuickSort.Pivot.LAST);
            assertArrayEquals(sorted, last);

            int[] random = Arrays.copyOf(nums, nums.length);
            QuickSort.partition(random, 0, random.length - 1, QuickSort.Pivot.RANDOM);
            assertArrayEquals(sorted, random);
        }
    }
}