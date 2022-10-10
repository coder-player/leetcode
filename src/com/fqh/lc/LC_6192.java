package com.fqh.lc;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/2 11:18:28
 */
public class LC_6192 {

    public static void main(String[] args) {
        System.out.println(12 % 3);
        System.out.println(new LC_6192().commonFactors(25, 30));
    }

    //AC
    public int commonFactors(int a, int b) {

        int max = Math.max(a, b);
        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }
}
