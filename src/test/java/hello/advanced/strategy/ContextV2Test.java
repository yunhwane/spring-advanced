package hello.advanced.strategy;


import hello.advanced.strategy.code.stragegy.ContextV2;
import hello.advanced.strategy.code.stragegy.StrategyLogic1;
import hello.advanced.strategy.code.stragegy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV2() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }

    @Test
    void strategyV3() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(() -> log.info("logic1"));
        contextV2.execute(() -> log.info("logic2"));
    }

}
