package com.ssm.designModel.strategy.method1;

/**
 * 设计模式-策略模式
 * @author JinXing
 * @date 2018/1/9 14:46
 */
public abstract class Duck {

    public String duckname() {
        return "鸭子";
    }

    public String swiming() {
        return "游泳";
    }

    public String speaking() {
        return "呱呱叫";
    }

    public String flying() {
        return "飞";
    }



}
