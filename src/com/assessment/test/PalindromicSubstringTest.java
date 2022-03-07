package com.assessment.test;

import com.assessment.src.PalindromicSubString;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicSubstringTest {

    @org.junit.jupiter.api.Test
    void checkEmptyStringPalindrome() {
        PalindromicSubString ps = new PalindromicSubString();
        String result = ps.computeBestPalindrome(0, "");
        assertEquals(null, result, "computeBestPalindrome method should return null String");
    }

    @org.junit.jupiter.api.Test
    void checkNullPalindrome() {
        PalindromicSubString ps = new PalindromicSubString();
        String result = ps.computeBestPalindrome(0, null);
        assertEquals(null, result, "computeBestPalindrome method should return null String");
    }

    @org.junit.jupiter.api.Test
    void checkOutOfMemoryError() {
        PalindromicSubString ps = new PalindromicSubString();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ps.computeBestPalindrome(Integer.MAX_VALUE, "abcd");
        });
        String expectedMessage = "OutOfMemoryError";
        assertTrue(exception.getMessage().contains(expectedMessage), "computeBestPalindrome method should return OutOfMemoryError message");
    }

    @org.junit.jupiter.api.Test
    void checkLengthOnePalindrome() {
        PalindromicSubString ps = new PalindromicSubString();
        String result = ps.computeBestPalindrome(4, "abcd");
        assertEquals("a", result, "computeBestPalindrome method should return the first character");
    }

    @org.junit.jupiter.api.Test
    void checkOddPalindromeInMiddle() {
        PalindromicSubString ps = new PalindromicSubString();
        String result = ps.computeBestPalindrome(5, "abbbd");
        assertEquals("bbb", result, "computeBestPalindrome method should return length 3 palindrome");
    }

    @org.junit.jupiter.api.Test
    void checkEvenPalindromeInMiddle() {
        PalindromicSubString ps = new PalindromicSubString();
        String result = ps.computeBestPalindrome(4, "abbd");
        assertEquals("bb", result, "computeBestPalindrome method should return even length palindrome of length 2");
    }

    @org.junit.jupiter.api.Test
    void checkPalindromeInTheEnd() {
        PalindromicSubString ps = new PalindromicSubString();
        String result = ps.computeBestPalindrome(4, "abbb");
        assertEquals("bbb", result, "computeBestPalindrome method should return palindrome of length 3");
    }

    @org.junit.jupiter.api.Test
    void checkPalindromeEntireString() {
        PalindromicSubString ps = new PalindromicSubString();
        String result = ps.computeBestPalindrome(5, "abbba");
        assertEquals("abbba", result, "computeBestPalindrome method should return entire String");
    }


}