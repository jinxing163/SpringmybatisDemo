package com.ssm.designModel.strategy.method3;

/**
 * @author JinXing
 * @date 2018/1/9 16:35
 */
public abstract class Duck {

    //飞行动作
    private FlyService flyService;
    //叫动作
    private SpeakingService speakingService;

    public String swiming() {
        return "游泳";
    }

    public String duckname(){
        return "鸭子";
    }

    //鸭子颜色自定义
    public abstract String color();

    public FlyService getFlyService() {
        return flyService;
    }

    public void setFlyService(FlyService flyService) {
        this.flyService = flyService;
    }

    public SpeakingService getSpeakingService() {
        return speakingService;
    }

    public void setSpeakingService(SpeakingService speakingService) {
        this.speakingService = speakingService;
    }
}
