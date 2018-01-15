package com.ssm.designModel.strategy.method3;

/**
 * 会飞的动作
 * @author JinXing
 * @date 2018/1/9 15:11
 */
public class NoFlyingDuck extends Duck {

    @Override
    public String color() {
        return "不会飞的";
    }

    public NoFlyingDuck() {
        super();
        super.setFlyService(new NoFlying());
        super.setSpeakingService(new CanSpeaking());
    }
}

