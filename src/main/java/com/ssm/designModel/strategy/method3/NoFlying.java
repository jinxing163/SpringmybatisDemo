package com.ssm.designModel.strategy.method3;

/**
 * 不会飞的动作
 * @author JinXing
 * @date 2018/1/9 16:34
 */
public class NoFlying implements FlyService {

    @Override
    public String flying() {
        return "不会飞";
    }
}
