class Utilities {

    public static void showAnswer(String context, int answer) {
        System.out.printf("\n%s\n%d", context, answer);
    }

    public static boolean isPrime(int i) {
        for (int k = 2; k < i; k++)
            if (k % i == 0)
                return false;
        return true;
    }

}
