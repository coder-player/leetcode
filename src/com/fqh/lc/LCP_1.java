package com.fqh.lc;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/9/24 15:04:35
 */
public class LCP_1 {

    public static void main(String[] args) {

        int[] temperatureA = {5, 10, 16, -6, 15, 11, 3};
        int[] temperatureB = {16, 22, 23, 23, 25, 3, -16};
        System.out.println(new LCP_1().temperatureTrend(temperatureA, temperatureB));

    }

    //AC
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int ans = 0;
        int len = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (i + 1 < n) {
                if (temperatureA[i + 1] - temperatureA[i] > 0 && temperatureB[i + 1] - temperatureB[i] > 0) {
                    len++;
                } else if (temperatureA[i + 1] - temperatureA[i] < 0 && temperatureB[i + 1] - temperatureB[i] < 0) {
                    len++;
                } else if (temperatureA[i + 1] - temperatureA[i] == 0 && temperatureB[i + 1] - temperatureB[i] == 0) {
                    len++;
                } else {
                    len = 0;
                }
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
