package com.ssm.designModel.strategy.method3;

/**
 * 不会叫的动作
 * @author JinXing
 * @date 2018/1/9 16:33
 */
public class NoSpeaking implements SpeakingService {

    @Override
    public String speaking() {
        return "不会叫";
    }
}
