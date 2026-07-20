package com.learning.dsa;

import java.util.*;

/**
 * Simple runner for the Keys and Rooms problem (LeetCode 841).
 * Each room may contain keys to other rooms; starting from room 0, determine if every room is reachable.
 */
class LeetCode841 {
    /**
     * Example entry point to exercise the reachability check with a fixed input.
     * Prints a boolean indicating whether all rooms can be visited.
     */
    public static void main(String[] args) {
        LeetCode841 leetCode841 = new LeetCode841();
        System.out.println("Can visit all rooms: " + leetCode841.canVisitAllRooms(List.of(List.of(1,3), List.of(3,0,1), List.of(2), List.of(1))));
    }

    /**
     * Determines whether every room can be visited starting from room 0 using the keys found along the way.
     *
     * @param rooms list of rooms, where rooms[i] contains keys to other rooms
     * @return true if all rooms are reachable from room 0; false otherwise
     */
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
