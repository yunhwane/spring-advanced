package hello.advanced.strategy.code.stragegy;


import lombok.extern.slf4j.Slf4j;

/**
 * 필드에 전략을 보관 하는 방식
 * 문맥 안에서 strategy 를 통한 일부 전략만 사용하는 경우
 *
 */
@Slf4j
public class ContextV1 {
    private final Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();
        strategy.call();
        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        log.info("result = {}", result);
    }
}
