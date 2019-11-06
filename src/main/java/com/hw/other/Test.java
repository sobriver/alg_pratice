package com.hw.other;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class Test {

    public static void main(String[] args) {

        Map<String, Object> map = new ConcurrentSkipListMap<>();
        map.put("aaa", 123);
        map.put("bbb", 2323);
        map.put("ccc", 2323);
        map.put("aba", 2323);
        map.get("122");

        for (Map.Entry entry: map.entrySet()){
            System.out.println(entry.getKey());
        }

    }
}
