package com.ssm.designModel.strategy.method3;

/**
 * 蓝色的鸭子：会飞、会叫
 * @author JinXing
 * @date 2018/1/9 14:57
 */
public class BlueDuck extends Duck {

    @Override
    public String color() {
        return "蓝色的";
    }

    public BlueDuck() {
        super();
        super.setFlyService(new CanFlying());
        super.setSpeakingService(new CanSpeaking());
    }

}
