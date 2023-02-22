package org.example;

public class BinarySearch {

    public static int binarySearch(int[] numbers, int numberToFind) {
        int pointerLow = 0;
        int pointerHigh = numbers.length -1;

        while(pointerLow <= pointerHigh) {
            int middlePosition = (pointerLow +pointerHigh) / 2;
            int valueMiddle = numbers[middlePosition];
            
            if (numberToFind == valueMiddle) {
                return middlePosition;
            } else if (numberToFind < valueMiddle) {
                pointerHigh = middlePosition - 1;
            } else {
                pointerLow = middlePosition + 1;
            }
        }
        return -1;
    }

}