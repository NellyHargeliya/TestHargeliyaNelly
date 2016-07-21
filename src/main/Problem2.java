package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Task 2
 * #Created by Nelly#
 * Ticket Number consists of an even number of digits.
 * The lucky ticket is considered, in which the sum of the first digit
 * is the sum of the last digits.
 */
public class Problem2 implements LuckyTicket {
    @Override
    public boolean isLucky(String number) {
        char[] chars = number.toCharArray();
        int sumFirst = 0, sumSecond = 0;
        try {
            checkFallPast(chars);
            List<Long> numberArray = parseString(chars);
            int halfLength = numberArray.size() / 2;

            for (int i = 0; i < halfLength; i++) {
                sumFirst += numberArray.get(i);
                sumSecond += numberArray.get(i + halfLength);
            }
        } catch (Exception e) {
            return false;
        }
        return sumFirst == sumSecond ? true : false;
    }

    @Override
    public long countLucky(long min, long max) {
        int count = 0;
        for (long number = min; number <= max; number++) {
            if (isLucky(String.valueOf(number))) {
                count++;
            }
        }
        return count;
    }

    @Override
    public long countLucky(String min, String max) {
        long minLong, maxLong;
        try {
            minLong = Long.parseLong(min);
            maxLong = Long.parseLong(max);
        } catch (Exception e) {
            System.err.println("String number is not Number!");
            return 0;
        }
        return countLucky(minLong, maxLong);
    }

    private boolean checkFallPast(char[] chars) {
        for (char ch : chars) {
            if (!(ch >= '0' && ch <= '9')) {
                return false;
            }
        }
        return true;
    }

    private List<Long> parseString(char[] chars) {
        List<Long> nums = new ArrayList<>();
        for (char c : chars) {
            nums.add(Long.valueOf(String.valueOf(c)));
        }
        return nums;
    }

}
