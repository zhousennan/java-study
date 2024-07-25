package com.zsn.test202108;

/**
 * @Author : zhou sen nan
 * @Date : 2021/9/7  11:10
 *
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class test20210907 {
    public int[] sortedSquares(int[] nums) {

        for(int i=0;i<nums.length;i++){
            nums[i] =nums[i]*nums[i];
        }

        for (int n=0;n<nums.length  ;n++){
            int min=nums[n];
            for(int m=n+1;m<nums.length;m++){
                if(min>nums[m]){
                    int b=min;
                    min = nums[m];
                    nums[m]=b;
                }
            }
            nums[n]=min;
        }
        return  nums; }
}
