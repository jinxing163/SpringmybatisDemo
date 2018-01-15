package com.ssm.designModel.strategy.method3;

/**
 * 会叫的动作
 * @author JinXing
 * @date 2018/1/9 16:32
 */
public class CanSpeaking implements SpeakingService {

    @Override
    public String speaking() {
        return "呱呱叫";
    }
}
