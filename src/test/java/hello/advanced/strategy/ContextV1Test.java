package hello.advanced.strategy;

import hello.advanced.strategy.code.stragegy.ContextV1;
import hello.advanced.strategy.code.stragegy.StrategyLogic1;
import hello.advanced.strategy.code.stragegy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        // 부가 기능
        long startTime = System.currentTimeMillis();
        //로직 시작
        log.info("logic1");
        //로직 종료
        long endTime = System.currentTimeMillis();

        long result = endTime - startTime;
        log.info("result = {}", result);
    }

    private void logic2() {
        // 부가 기능
        long startTime = System.currentTimeMillis();
        //로직 시작
        log.info("logic2");
        //로직 종료
        long endTime = System.currentTimeMillis();

        long result = endTime - startTime;
        log.info("result = {}", result);
    }

    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    /**
     * 익명 내부 클래스를 사용한 전략 패턴
     */
    @Test
    void strategyV2() {
        ContextV1 contextV1 = new ContextV1(new StrategyLogic1() {
            @Override
            public void call() {
                log.info("logic1");
            }
        });
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new StrategyLogic2() {
            @Override
            public void call() {
                log.info("logic2");
            }
        });
        contextV2.execute();
    }

    /**
     * 람다를 사용한 전략 패턴
     */
    @Test
    void strategyV3() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("logic1"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(() -> log.info("logic2"));
        contextV2.execute();
    }


}
