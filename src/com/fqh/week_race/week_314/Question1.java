package com.fqh.week_race.week_314;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/10 15:32:56
 */

/**
 * 1.处理用时最长的那个任务的员工
 */
public class Question1 {

    public static void main(String[] args) {

    }

    public int hardestWorker(int n, int[][] logs) {
        // [[0, 3], [2, 5], [0, 9], [1, 15]]
        //  任务0     任务1   任务2   任务3
        int maxx = logs[0][1];
        int id = logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            int pre_time = logs[i - 1][1];
            int cur_time = logs[i][1];
            int cur_id = logs[i][0];
            int cost_time = cur_time - pre_time;
            if (cost_time > maxx) {
                maxx = cost_time;
                id = cur_id;
            } else if (cost_time == maxx) {
                id = Math.min(id, cur_id);
            }
        }
        return id;
    }
}
