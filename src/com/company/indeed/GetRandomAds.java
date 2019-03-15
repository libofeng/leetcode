package com.company.indeed;

import java.util.List;
import java.util.Random;

public class GetRandomAds {
    private Random rnd = new Random();

    public int getRandomAds(List<Integer> ads) {
        int size = ads.size();
        int index = rnd.nextInt(size);

        // swap
        int value = ads.get(index);
        ads.set(index, ads.get(size - 1));
        ads.remove(size - 1);
        return value;
    }
}
