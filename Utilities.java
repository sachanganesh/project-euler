class Utilities {

    public static void showAnswer(String context, long answer) {
        System.out.printf("\n%s\n%d", context, answer);
    }

    public static void showAnswer(String context, double answer) {
        System.out.printf("\n%s\n%f", context, answer);
    }

    public static boolean isPrime(long prime) {
        for(int i = 2; i <= Math.sqrt(prime); i++)
            if (prime % i == 0)
                return false;
        return true;
    }

    public static boolean isPalindrome(String palindrome) {
        String fragment1 = palindrome.substring(0, palindrome.length() / 2),
        fragment2 = palindrome.substring(palindrome.length() / 2),
        reverseFragment = "";
        for (int i = fragment2.length() - 1; i > -1; i--)
            reverseFragment += fragment2.charAt(i);
        return fragment1.equals(reverseFragment);
    }

    public static boolean isPalindrome(long palindrome) {
        return isPalindrome("" + palindrome);
    }

}
