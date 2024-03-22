package edu.phystech.hw1;

import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SortTest {

    private static int[] sort(int[] nums) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        int step = newNums.length - 1;
        while (step > 0) {
            for (int i = 0; i + step < newNums.length; i++) {
                if (newNums[i] > newNums[i + step]) {
                    int tmp = newNums[i];
                    newNums[i] = newNums[i + step];
                    newNums[i + step] = tmp;
                }
            }
            --step;
        }
        return newNums;
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
