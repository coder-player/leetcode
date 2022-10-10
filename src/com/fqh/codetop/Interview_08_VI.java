package com.fqh.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/11 23:15:42
 * 面试题 08.06. 汉诺塔问题
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <p>
 * 你需要原地修改栈。
 * <p>
 * 示例1:
 * 输入：A = [2, 1, 0], B = [], C = []
 * 输出：C = [2, 1, 0]
 */
public class Interview_08_VI {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        hanota(A, B, C);
        System.out.println(C);
    }

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size(); //盘子数量
        divideAndConquer(n, A, B, C);
    }

    //分治
    public static void divideAndConquer(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) { //A柱只剩一个盘
            C.add(A.remove(A.size() - 1)); //A--->C
            return;
        }
        //A--->C--->B 将A上面n-1个通过C移到B
        divideAndConquer(n - 1, A, C, B);
        //A--->C 这时，A只剩1个盘了
        C.add(A.remove(A.size() - 1));
        //B--->A--->C 将B上面n-1个通过空的A移到C
        divideAndConquer(n - 1, B, A, C);
    }
}
