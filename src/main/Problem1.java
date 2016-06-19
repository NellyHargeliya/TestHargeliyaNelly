package main;
/**
 * Created by Nelly on 17.06.2016.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1 implements BestFile {

    @Override
    public String fitPlusMinus(String digits, long expectedResult) {
        try {
            checkFallPast(digits);
            List<Long> nums = parseString(digits);
            Map<Long, String> res = calcResults(nums, 0, nums.size() - 1, CalcType.FitPlusMinus);
            return processRes(res, expectedResult);
        } catch (Exception e) {
            return "String digits " + digits + " is not Number!";
        }
    }

    @Override
    public String fit(String digits, long expectedResult) {
        try {
            checkFallPast(digits);
            List<Long> nums = parseString(digits);
            Map<Long, String> res = calcResults(nums, 0, nums.size() - 1, CalcType.Fit);
            return processRes(res, expectedResult);
        } catch (Exception e) {
            return "String digits " + digits + " is not Number!";
        }
    }

    @Override
    public String fitBraces(String digits, long expectedResult) {
        try {
            checkFallPast(digits);
            List<Long> nums = parseString(digits);
            Map<Long, String> res = calcResults(nums, 0, nums.size() - 1, CalcType.FitBraces);
            return processRes(res, expectedResult);
        } catch (Exception e) {
            return "String digits " + digits + " is not Number!";
        }
    }

    private Map<Long, String> calcResults(List<Long> list, int left, int right, CalcType calcType) {
        Map<Long, String> resList = new HashMap<>();
        if (left > right)
            return resList;
        else if (left == right) {
            resList.put(list.get(left), list.get(left).toString());
            return resList;
        }
        for (int i = left; i < right; i++) {
            Map<Long, String> result1 = calcResults(list, left, i, calcType);
            Map<Long, String> result2 = calcResults(list, i + 1, right, calcType);

            for (long x : result1.keySet()) {
                for (long y : result2.keySet()) {

                    if (calcType == CalcType.FitPlusMinus) {
                        resList.put(x + y, result1.get(x) + "+" + result2.get(y));
                        resList.put(x - y, result1.get(x) + "-" + result2.get(y));
                    } else {
                        resList.put(x + y, "(" + result1.get(x) + "+" + result2.get(y) + ")");
                        resList.put(x - y, "(" + result1.get(x) + "-" + result2.get(y) + ")");
                    }

                    if (calcType == CalcType.Fit) {
                        resList.put(x * y, result1.get(x) + "*" + result2.get(y));
                        if (y != 0) {
                            double d = x / y;
                            if (d == Math.floor(d))
                                resList.put(x / y, result1.get(x) + "/" + result2.get(y));
                        }
                    } else if (calcType == CalcType.FitBraces) {
                        resList.put(x * y, "(" + result1.get(x) + "*" + result2.get(y) + ")");
                        if (y != 0) {
                            double d = x / y;
                            if (d == Math.floor(d))
                                resList.put(x / y, "(" + result1.get(x) + "/" + result2.get(y) + ")");
                        }
                    }

                    resList.put(10 * x + y, Long.valueOf(10 * x + y).toString());
                }
            }
        }

        return resList;
    }

    private List<Long> parseString(String digits) {
        char[] chars = digits.toCharArray();
        List<Long> nums = new ArrayList<>();

        for (char c : chars) {
            nums.add(Long.valueOf(String.valueOf(c)));
        }
        return nums;
    }

    private String processRes(Map<Long, String> res, long expectedResult) {
        String result = res.get(expectedResult);
        return result == null ? "" : result;
    }

    private enum CalcType {
        FitPlusMinus, Fit, FitBraces,
    }

    private boolean checkFallPast(String digits) {
        char[] chars = digits.toCharArray();
        for (char ch : chars) {
            if (!(ch >= '0' && ch <= '9')) {
                return false;
            }
        }
        return true;
    }
}