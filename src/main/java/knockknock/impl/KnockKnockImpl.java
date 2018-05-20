package knockknock.impl;

import knockknock.model.TriangleTypes;

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

    public TriangleTypes triangleType(int a, int b, int c) {
        if (!isTriangle(a, b, c)) {
            return TriangleTypes.Error;
        }

        return  determineTriangleType(a, b, c);
    }

    private boolean isTriangle(int a, int b, int c) {
        boolean isTriangle = true;

        //validate
        if (a+b <= c) {
            isTriangle = false;
        }

        if (b+c <= a) {
            isTriangle = false;
        }

        if (c+a <= b) {
            isTriangle = false;
        }

        return isTriangle;
    }

    private TriangleTypes determineTriangleType(int a, int b, int c) {
        TriangleTypes type;

        if((a == b) && (b == c)){
            type = TriangleTypes.Equilateral;
        }
        else if ((a == b) || (b == c)) {
            type = TriangleTypes.Isosceles;
        }
        else {
            type = TriangleTypes.Scalene;
        }

        return type;
    }
}
