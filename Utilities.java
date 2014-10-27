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

}
