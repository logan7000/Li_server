package org.li.L002;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println(30 % 8);
        //ListNode l9 = new ListNode(9);
        //ListNode l8 = new ListNode(9);
        //ListNode list1 = new ListNode(9, l9);
        //ListNode list2 = new ListNode(9, l8);
        //solution(list1, list2);
    }

    private static ListNode solution(ListNode l1, ListNode l2) {

        // 十进制位数
        int carry = 0;
        // 最终的结果链表
        ListNode resultList = null;
        // 辅助指针：尾部
        ListNode tail = null;
        // 只要有一个l有值，就继续走下去
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            // 计算和
            int summary = n1 + n2 + carry;
            // 第一次的话，就初始两个变量
            if (resultList == null) {
                // 取余数 23/10 余3
                resultList = tail = new ListNode(summary % 10);
            } else {
                //因为tail一直没有变化，所以这个tail还是上一次的循环中的对象
                //为tail的next指针赋值
                tail.next = new ListNode(summary % 10);
                // 把tail
                tail = tail.next;
            }
            // 求一下进制
            carry = summary / 10;
            // 切换到下一个函数中去
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return resultList;
    }

}
