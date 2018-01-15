package com.ssm.designModel.strategy.method3;

/**
 * @author JinXing
 * 策略模式：
 * 总结：
 *  继承的好处:让共同部分,可以复用.避免重复编程.
 *  继承的不好:耦合性高.一旦超类添加一个新方法,子类都继承,拥有此方法,
 *  若子类相当部分不实现此方法,则要进行大批量修改.
 *  继承时,子类就不可继承其它类了.
 *  接口的好处:解决了继承耦合性高的问题.
 *  且可让实现类,继承或实现其它类或接口.
 *  接口的不好:不能真正实现代码的复用.可用以下的策略模式来解决.
 * ==============================================================
 * 我们有一个设计原则：
 * 找出应用中相同之处，且不容易发生变化的东西，把它们抽取到抽象类中，让子类去继承它们；
 * 找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起
 * ==============================================================
 * 1.FlyService、SpeakingService 为飞行类、会叫类的特性
 * 2.CanFlying、CanSpeaking表示会飞会叫类，NoFlying、NoSpeaking表示不会飞不会叫类
 * 3.Duck 为超类定义鸭子不变的特性：游泳、鸭子名称(公共方法)，定义了飞行类与会叫类的特性（FlyService、SpeakingService）
 * 4.BlueDuck、RedDuck、NoFlyingDuck为几种颜色不同的鸭子(自己方法)，每个鸭子都可以在自己的构造方法中设置自己的特性。
 * 比如：BlueDuck 中
 * super.setFlyService(new CanFlying());
 * super.setSpeakingService(new CanSpeaking());
 * 设置了鸭子会飞会叫的特性。
 *
 * @date 2018/1/9 15:03
 */
public class TestMain {

    public static void main(String[] args) {

        BlueDuck blueDuck=new BlueDuck();
        System.out.println("我是"+blueDuck.color()+blueDuck.duckname());
        System.out.println("我会"+blueDuck.swiming()+"、"+blueDuck.getSpeakingService().speaking()+"、"+blueDuck.getFlyService().flying());

        System.out.println(".....................................");

        RedDuck redDuck=new RedDuck();
        System.out.println("我是"+redDuck.color()+redDuck.duckname());
        System.out.println("我会"+redDuck.swiming()+"、"+redDuck.getSpeakingService().speaking()+"、"+redDuck.getFlyService().flying());

        System.out.println(".....................................");

        NoFlyingDuck noFlyingDuck=new NoFlyingDuck();
        System.out.println("我是"+noFlyingDuck.color()+noFlyingDuck.duckname());
        System.out.println("我会"+noFlyingDuck.swiming()+"、"+noFlyingDuck.getSpeakingService().speaking()+"、"+noFlyingDuck.getFlyService().flying());

        System.out.println(".....................................");

    }

}
