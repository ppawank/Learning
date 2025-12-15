package com.learning.dsa;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print("IsPalindrome: " + solution.isPalindrome("race a car"));

        System.out.print("\nInsertion Sort: ");
        solution.insertionSort(new int[]{23,12,4,5,3,6,7,9,8});

        System.out.print("\nMerge two sorted arrays: ");
        solution.mergeTowSortedArrays(new int[]{1,3,5,7}, new int[]{2,4,6,8});

        System.out.print("\nMerge Sort: ");
        int[] arr = {38, 27, 43, 3, 92, 10};
        solution.mergeSort(arr, 0, arr.length - 1);
        solution.printArray(arr);

    }

    public boolean isPalindrome(String x) {
        String str = String.valueOf(cleanString(x));
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev);
    }

    public String cleanString(String x) {
        char[] charArray = x.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('a' + c - 'A'));
            } else if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        printArray(arr);
    }

    private void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private void mergeTowSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] merged = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            }else  {
                merged[k++] = arr2[j++];
            }
        }
        while (i < n1) {
            merged[k++] = arr1[i++];
        }
        while (j < n2) {
            merged[k++] = arr2[j++];
        }


        printArray(merged);

    }


    private void mergeSort(int[] arr, int l, int r) {
            if(l>=r) {
                return;
            }
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);

            merge(arr,l,mid,r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        List<Integer> list = new ArrayList<>();
        int left = l;
        int right = mid+1;
        while (left <= mid && right <= r) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left++]);
            }else  {
                list.add(arr[right++]);
            }
        }
        while (left <= mid) {
            list.add(arr[left++]);
        }
        while (right <= r) {
            list.add(arr[right++]);
        }

        for (int i = 0; i < list.size(); i++) {
            arr[l + i] = list.get(i);
        }
    }
}
