package thinking.in.algorithms.sort;

/**
 * This {@link QuickSort} is an efficient sorting algorithm that selects a {@link Pivot}
 * and divides the array into two sub-arrays, then recursively sorts the sub-arrays before
 * sorting the full array.
 *
 * @author authoralankay
 * @see QuickSort#partition(int[], int, int, Pivot)
 * @since 1.0.0
 */
public class QuickSort {

    public static void sort(int[] nums) {
        sortThroughPivotLast(nums);
    }

    public static void sortThroughPivotFirst(int[] nums) {
        partition(nums, 0, nums.length - 1, Pivot.FIRST);
    }

    public static void sortThroughPivotMiddle(int[] nums) {
        partition(nums, 0, nums.length - 1, Pivot.MIDDLE);
    }

    public static void sortThroughPivotLast(int[] nums) {
        partition(nums, 0, nums.length - 1, Pivot.LAST);
    }

    public static void sortThroughPivotRandom(int[] nums) {
        partition(nums, 0, nums.length - 1, Pivot.RANDOM);
    }

    protected static void partition(int[] nums, int start, int end, Pivot pivot) {
        // Base Case
        if (start >= end) {
            return;
        }
        // Recursion Call
        // Considers various pivots.
        swap(nums, end, pivot.getPivot(start, end));
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (nums[j] <= nums[end]) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, end);
        // Problem Reduction
        partition(nums, start, i - 1, pivot);
        partition(nums, i + 1, end, pivot);
    }

    protected static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * This {@link Pivot} enum offers the abstract function of {@link Pivot#getPivot(int, int)}
     * for the method of {@link QuickSort#partition(int[], int, int, Pivot)}.
     * <p>
     * The abstract function of {@link Pivot#getPivot(int, int)} is implemented as follows:
     * <ul>
     *     <li>{@link Pivot#FIRST}</li>
     *     <li>{@link Pivot#MIDDLE}</li>
     *     <li>{@link Pivot#LAST}</li>
     *     <li>{@link Pivot#RANDOM}</li>
     * </ul>
     */
    protected enum Pivot {

        FIRST {
            @Override
            public int getPivot(int start, int end) {
                return start;
            }
        },

        MIDDLE {
            @Override
            public int getPivot(int start, int end) {
                return start + ((end - start) >> 1);
            }
        },

        LAST {
            @Override
            public int getPivot(int start, int end) {
                return end;
            }
        },

        RANDOM {
            @Override
            public int getPivot(int start, int end) {
                return start + (int) (Math.random() * (end - start + 1));
            }
        };

        public abstract int getPivot(int start, int end);
    }
}
