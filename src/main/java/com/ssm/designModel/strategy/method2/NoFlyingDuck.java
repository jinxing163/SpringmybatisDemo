package com.ssm.designModel.strategy.method2;

/**
 * @author JinXing
 * @date 2018/1/9 15:11
 */
public class NoFlyingDuck extends Duck implements SpeakingService{

    public String color() {
        return "不会飞的";
    }


    @Override
    public String speaking() {
        return "呱呱叫";
    }
}

