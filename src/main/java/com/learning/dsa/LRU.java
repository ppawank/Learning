package com.learning.dsa;

import java.util.HashMap;
import java.util.Map;

//** Least Recently Used (LRU) Cache implementation
public class LRU {
    //LRU Cache implementation here
    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> cache;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            insertAtFront(node);
        } else {
            if(cache.size() == capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insertAtFront(newNode);
            cache.put(key, newNode);
        }
    }

    public int get(int key){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            removeNode(node);
            insertAtFront(node);
            return node.value;
        }else {
            return -1;
        }
    }

    void removeNode(Node node) {
        //delete a node from doubly linked list
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insertAtFront(Node node) {
        //insert a node at the front of doubly linked list
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

}
