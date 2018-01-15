package com.ssm.designModel.strategy.method2;

/**
 * @author JinXing
 * @date 2018/1/9 14:53
 */
public class RedDuck extends Duck implements FlyService,SpeakingService{

    public String color() {
        return "红色的";
    }

    @Override
    public String flying() {
        return "飞";
    }

    @Override
    public String speaking() {
        return "呱呱叫";
    }
}
