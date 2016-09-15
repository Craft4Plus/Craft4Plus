package com.craft4plus.miscellaneous;

import java.util.Random;

public class RandomNumber {

    public static int getRandom(int lower, int upper) {
        Random random = new Random();
        return random.nextInt((upper - lower) + 1) + lower;
    }
	
}
