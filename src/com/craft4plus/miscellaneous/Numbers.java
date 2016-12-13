package com.craft4plus.miscellaneous;

import java.util.Random;

public class Numbers {

	public static int getRandom(int lower, int upper) {
		Random random = new Random();
		return random.nextInt((upper - lower) + 1) + lower;
	}

	public static int getLowestInt(int[] integers) {
		if (integers.length == 0)
			return 0;
		int small = integers[0];
		int index = 0;
		for (int i = 0; i < integers.length; i++) {
			if (integers[i] < small) {
				small = integers[i];
				index = i;
			}
		}
		return index;
	}
}
