package section03;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusyCalculating {

    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(10000000L, 335L, 232L, 326L, 23L, 444L);
        List<FactorialThread> threads = new ArrayList<>();
        for (Long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

        for (FactorialThread thread : threads) {
            thread.setDaemon(true);
            thread.start();
            thread.join(2000); // time limit 2sec
        }

        threads.forEach(thread -> {
            if (thread.isFinished) {
                System.out.println("Factorial of " + thread.getNumber() + " is " + thread.getResult());
            } else {
                System.out.println("The Calculation for " + thread.getNumber() + " is still in progress");
            }
        });
    }

    private static class FactorialThread extends Thread {

        final private long number;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(Long number) {
            this.number = number;
        }

        @Override
        public void run() {
            this.result = factorial(number);
            this.isFinished = true;
        }

        private BigInteger factorial(long number) {
            BigInteger tempResult = BigInteger.ONE;
            for (long i = number; i > 0; i--) {
                tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
            }
            return tempResult;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public Long getNumber() {
            return number;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
