package com.leetcode;

/**
 *  使用位运算求
 * @author chaseshu
 * @date 2021/12/14 12:56
 * @apiNote
 */
public class 使用位运算求和 {
    
    // 连续n个数的和
    // 求 1 2 ... n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    // 示例 1：
    //
    // 输入: n = 3 输出: 6
    // 示例 2：
    //
    // 输入: n = 9 输出: 45
    // 限制： 1 <= n <= 10000
    // see https://github.com/geekxh/hello-algorithm/blob/master/PART_2_%E5%8A%9B%E6%89%A3%E5%9B%BE%E8%A7%A3/sourcefile/11.%E4%BD%8D%E8%BF%90%E7%AE%97%E7%B3%BB%E5%88%97/801.md
    public static void main(String[] args) {
        int n = 9;
        System.out.println(sumNums(n));
    }
    
    public static int sumNums(int n) {
        boolean b = n > 0 && ((n  += sumNums(n - 1)) > 0);
        return n;
    }
}
