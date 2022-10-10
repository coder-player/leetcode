package com.fqh.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/1 22:52:06
 */
public class LC_6179 {

    public static void main(String[] args) {

        LUPrefix server = new LUPrefix(4);
        server.upload(3);
        System.out.println(server.longest());
        server.upload(1);
        System.out.println(server.longest());
        server.upload(2);
        System.out.println(server.longest());
    }

    //AC
    static class LUPrefix {

        private int[] arr;

        private int ans = 0;

        public LUPrefix(int n) {
            arr = new int[n];
        }

        public void upload(int video) {
            arr[video - 1] = 1;
            int len = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 1) {
                    break;
                }
                len++;
            }
            ans = len;
        }

        public int longest() {
            if (arr[0] == 0) {
                return ans;
            }
            return ans;
        }
    }
}
