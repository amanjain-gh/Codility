package org.codility.exercises.codingSkills;

/**
 * Author: Aman Jain
 * Problem:  Given two integers A, B (within the range of 1 - 100) as an input
 * and prints out exactly A a's and B b's with no three consecutive letters being the same.
 */
public class ThreeLetters {

    public static void main(String[] args) {
        System.out.println(generateOutputString(10, 4));
    }

    public static String generateOutputString(int a, int b) {
        int aCount = a, bCount = b;
        StringBuilder result = new StringBuilder();
        int len = result.length();
        boolean addA = false;

        while(aCount > 0 || bCount > 0) {
            len = result.length();

            if(aCount > bCount) {
                // Adding 'a' if there are no violations
                addA = !(len >= 2 && result.charAt(len-1) == 'a' && result.charAt(len-2) == 'a');
            } else if (bCount > aCount) {
                // // Adding 'b' if there are no violations
                addA = (len >= 2 && result.charAt(len-1) == 'b' && result.charAt(len-2) == 'b');
            } else {
                // if the counts are equals, prevent 2 consecutive letters
                if(len >= 2 && result.charAt(len-1) == result.charAt(len-2))
                    addA = result.charAt(len-1) == 'b';
                else
                    addA = true;
            }

            if(addA && aCount > 0) {
                result.append('a');
                aCount--;
            } else if(!addA && bCount > 0) {
                result.append('b');
                bCount--;
            } else if(aCount > 0) {
                if(!isValidString(result, 'a'))
                    return "Invalid string is generated with provided inputs";

                result.append('a');
                aCount--;
            } else if(bCount > 0) {
                if(!isValidString(result, 'b'))
                    return "Invalid string is generated with provided inputs";

                result.append('b');
                bCount--;
            }
        }
        return result.toString();
    }

    private static boolean isValidString(StringBuilder result, char nextChar) {
        int length = result.length();
        return !(result.charAt(length-1) == nextChar && result.charAt(length-2) == nextChar);
    }
}
