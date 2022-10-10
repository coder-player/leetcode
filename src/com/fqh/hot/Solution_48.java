package com.fqh.hot;

import java.util.Arrays;

/**
 * @author 海盗狗
 * @version 1.0
 * 48. 旋转图像
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class Solution_48 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    public static void rotate(int[][] matrix) {
        int temp = 0;
//        先对角线反转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
//        将每一行前后反转
        for (int[] link : matrix) {
            reverse(link);
        }
    }

    public static void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int temp = 0;
        while (j > i) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
