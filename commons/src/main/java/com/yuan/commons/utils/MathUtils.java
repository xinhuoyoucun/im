package com.yuan.commons.utils;

import java.util.Random;

/**
 * @author by laiyuan
 * @Date 2019/9/20 10:37
 * @Description: TODO
 * @Version 1.0
 */
public class MathUtils {
    /**
     * @Description: 生成指定数量的随机码
     * @Author: laiyuan
     * @Date: 2017/8/7 上午9:32
     */
    public static int getRandCode(int size) {
        Random random = new Random();
        int randCode = 0;
        for (int i = 0; i < size; i++) {
            randCode = random.nextInt(10)+randCode*10;
        }
        return randCode;
    }

    public static void main(String[] args) {
        System.out.println(MathUtils.getRandCode(6));

    }
}
