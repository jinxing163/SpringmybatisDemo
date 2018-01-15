package com.ssm.designModel.strategy.method3;

/**
 * 红色的鸭子：会飞、不会叫
 * @author JinXing
 * @date 2018/1/9 14:53
 */
public class RedDuck extends Duck {

    @Override
    public String color() {
        return "红色的";
    }

    public RedDuck() {
        super();
        super.setFlyService(new CanFlying());
        super.setSpeakingService(new NoSpeaking());
    }
}
