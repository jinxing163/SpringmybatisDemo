package com.ssm.designModel.strategy.method1;

/**
 * @author JinXing
 * @date 2018/1/9 15:11
 */
public class NoFlyingDuck extends Duck{

    public String color() {
        return "不会飞的";
    }

    @Override
    public String flying() {
        return "不会飞";
    }
}

