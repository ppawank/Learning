package com.learning.dsa;

import java.util.*;

class LeetCode841 {
    public static void main(String[] args) {
        LeetCode841 leetCode841 = new LeetCode841();
        System.out.println("Can visit all rooms: " + leetCode841.canVisitAllRooms(List.of(List.of(1,3), List.of(3,0,1), List.of(2), List.of(1))));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keyStore = new HashSet<>(rooms.get(0));

        for (int i = 1; i < rooms.size(); i++) {
            if (keyStore.contains(i)) {
                keyStore.addAll(rooms.get(i));
            }else {
                return false;
            }
        }
        return true;
    }
}
