package edu.phystech.hw1;

import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SortTest {

    private static int[] sort(int[] nums) {
        int[] new_nums = Arrays.copyOf(nums, nums.length);
        int step = new_nums.length - 1;
        while (step > 0) {
            for (int i = 0; i + step < new_nums.length; i++) {
                if (new_nums[i] > new_nums[i + step]) {
                    int tmp = new_nums[i];
                    new_nums[i] = new_nums[i + step];
                    new_nums[i + step] = tmp;
                }
            }
            --step;
        }
        return new_nums;
    }

    @Test
    public void sortWorks() {
        Assertions.assertArrayEquals(new int[]{1}, sort(new int[]{1}));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sort(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void sortReturnsNewArray() {
        int[] input = {9, 1, 3, 11, 45, 499};
        int[] copy = Arrays.copyOf(input, input.length);

        int[] sorted = sort(input);

        Assertions.assertArrayEquals(new int[]{1, 3, 9, 11, 45, 499}, sorted);
        Assertions.assertArrayEquals(copy, input);
    }
}
