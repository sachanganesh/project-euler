class Utilities {

    /*
    * Displays context for the problem and the corresponding answer to the problem.
    */
    public static void showAnswer(String context, Number answer) {
        System.out.printf("\n%s\n%d", context, answer);
    }

    /*
    * Determines if a number is prime.
    * Returns true if it is prime; false if it is not prime.
    */
    public static boolean isPrime(long prime) {
        for(int i = 2; i <= Math.sqrt(prime); i++)
            if (prime % i == 0)
                return false;
        return true;
    }

    /*
    * Determines root prime factor of a number/square.
    * Returns root prime factor of a number/square.
    */
    public static long rootPrime(long square) {
        long multiple = square,
        base = 1;
        if (isPrime(multiple))
            return multiple;
        return rootPrime((long)Math.sqrt(multiple));
    }

    /*
    * Determines if a String value of a number is palindromic.
    * Returns true if it is palindromic; false if it is not palindromic.
    */
    public static boolean isPalindrome(String palindrome) {
        String fragment1 = palindrome.substring(0, palindrome.length() / 2),
        fragment2 = palindrome.substring(palindrome.length() / 2),
        reverseFragment = "";
        for (int i = fragment2.length() - 1; i > -1; i--)
            reverseFragment += fragment2.charAt(i);
        return fragment1.equals(reverseFragment);
    }


    /*
    * Determines if a String value of a number is palindromic
    * by calling overloaded method with String param.
    */
    public static boolean isPalindrome(Number palindrome) {
        return isPalindrome(Long.toString(palindrome));
    }

}
