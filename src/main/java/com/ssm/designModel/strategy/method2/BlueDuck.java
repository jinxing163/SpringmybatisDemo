package com.ssm.designModel.strategy.method2;

/**
 * @author JinXing
 * @date 2018/1/9 14:57
 */
public class BlueDuck extends Duck implements FlyService,SpeakingService{

    public String color() {
        return "蓝色的";
    }


    @Override
    public String flying() {
        return "飞的很高";
    }

    @Override
    public String speaking() {
        return "呱呱呱呱呱...";
    }
}
