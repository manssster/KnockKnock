package knockknock.impl;

import java.util.UUID;

public class KnockKnockImpl {

    private static final String MY_TOKEN = "00000000-0000-0000-0000-000000000000";

    public long getFibonacciSequence(long n) {
        long fibonacci;
        long num1 = 0, num2 = 1;

        for (long i=0; i<n; i++)
        {
            fibonacci = num1 + num2;
            num1 = num2;
            num2 = fibonacci;
        }

        return num1;
    }

    public String reverseWords(String sentence) {
        StringBuilder reverse = new StringBuilder();

        if (sentence != null) {
            String[] words = sentence.split(" ");
            for (String word : words) {
                reverse.append(new StringBuilder(word).reverse().toString() + " ");
            }
        }

        return String.format("\"%s\"",reverse.toString().trim());
    }

    public UUID getToken () {
        return UUID.fromString(MY_TOKEN);
    }

    public String triangleType(int a, int b, int c) {
        return "";
    }
}
