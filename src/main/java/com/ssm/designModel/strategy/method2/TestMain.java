package com.ssm.designModel.strategy.method2;

/**
 * @author JinXing
 * 策略模式进阶2：超类包含共有特性、会变化的特性用接口分离 （代码无法复用）
 * 1.FlyService、SpeakingService 为飞行、鸭子叫的特性
 * 2.Duck 为超类定义鸭子不变的特性：游泳、鸭子名称(公共方法)...
 * 3.BlueDuck、RedDuck、NoFlyingDuck为几种颜色不同的鸭子(自己方法)
 * 4.BlueDuck、RedDuck会飞,NoFlyingDuck不会飞
 * 5.会飞的实现FlyService接口、会叫的实现SpeakingService接口
 *
 * @date 2018/1/9 15:03
 */
public class TestMain {

    public static void main(String[] args) {

        BlueDuck duck=new BlueDuck();
        System.out.println("我是"+duck.color()+duck.duckname());
        System.out.println("我会"+duck.swiming()+"、"+duck.speaking()+"、"+duck.flying());

        System.out.println(".....................................");

        RedDuck duck2=new RedDuck();
        System.out.println("我是"+duck2.color()+duck2.duckname());
        System.out.println("我会"+duck2.swiming()+"、"+duck2.speaking()+"、"+duck2.flying());

        System.out.println(".....................................");

        NoFlyingDuck duck3=new NoFlyingDuck();
        System.out.println("我是"+duck3.color()+duck3.duckname());
        System.out.println("我会"+duck3.swiming()+"、"+duck3.speaking());


    }

}
