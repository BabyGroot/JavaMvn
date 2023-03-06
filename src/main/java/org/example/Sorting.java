package org.example;

import java.util.Random;

public class Sorting {
    public static void quickSort() {
        Random rand = new Random();
        int[] array = new int[10];

        for(int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }
        System.out.println("Array before sort: ");
        printArray(array);

        quickSort(array);

        System.out.println("Array after sort: ");
        printArray(array);
    }

    public static void bubbleSort () {
        Random rand = new Random();
        int[] array = new int[10];

        for(int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }
        System.out.println("Array before sort: ");
        printArray(array);
        boolean swappedSomething = true;

        while (swappedSomething == true) {
            swappedSomething = false; // reset swapped something
            for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        int temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        swappedSomething = true;
                    }
            }
        }
        System.out.println("Array after sort: ");
        printArray(array);
    }

    private static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    private static void sort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex){
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        arraySwap(array, pivotIndex, highIndex);

        int leftPointer = partitionArray(array, lowIndex, highIndex, pivot);

        // recursively sort left partition
        sort(array, lowIndex, leftPointer - 1);

        // recursively sort right partition
        sort(array, leftPointer + 1, highIndex);
    }

    private static int partitionArray(int[] array, int lowIndex, int highIndex, int pivot){
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer) {
            while(array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer ++;
            }
            while(array[rightPointer] >= pivot &&  leftPointer < rightPointer){
                rightPointer --;
            }

            arraySwap(array, leftPointer, rightPointer);
        }
        if(array[leftPointer] > array[highIndex]) {
            arraySwap(array, leftPointer, highIndex);
        }
        else {
            leftPointer = highIndex;
        }

        return leftPointer;
    }
    private static void arraySwap(int[] array, int index1, int index2){
        int placeHolderValue = array[index1];

        array[index1] = array[index2];
        array[index2] = placeHolderValue;
    }
}
