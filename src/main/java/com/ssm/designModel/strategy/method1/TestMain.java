package com.ssm.designModel.strategy.method1;

/**
 * @author JinXing
 * 策略模式进阶1：超类包含鸭子共有的特性 (不灵活)
 * 1.Duck 为超类定义几种鸭子共有的特性：游泳、呱呱叫(公共方法)...
 * 2.BlueDuck、RedDuck、NoFlyingDuck为几种颜色不同的鸭子(自己方法)
 * 3.BlueDuck、RedDuck会飞,NoFlyingDuck不会飞(重写方法)
 *
 * @date 2018/1/9 15:03
 */
public class TestMain {

    public static void main(String[] args) {

        BlueDuck duck=new BlueDuck();
        System.out.println("我是"+duck.color()+duck.duckname());
        System.out.println("我会"+duck.swiming()+"、"+duck.speaking()+"、"+duck.flying());

        RedDuck duck2=new RedDuck();
        System.out.println("我是"+duck2.color()+duck2.duckname());
        System.out.println("我会"+duck2.swiming()+"、"+duck2.speaking()+"、"+duck2.flying());

        NoFlyingDuck duck3=new NoFlyingDuck();
        System.out.println("我是"+duck3.color()+duck3.duckname());
        System.out.println("我会"+duck3.swiming()+"、"+duck3.speaking()+"、"+duck3.flying());


    }

}
