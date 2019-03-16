package com.company.indeed;

import java.util.BitSet;

public class JobList {
    // try to apply bloom filter
    private BitSet bitMap = new BitSet();

    void expire(int id) {
        bitMap.set(id);
    }

    boolean isExpired(int id) {
        return bitMap.get(id);
    }
}
