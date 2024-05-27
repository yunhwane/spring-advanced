package hello.advanced.strategy.code.stragegy;

public class ContextV2 {
    /**
     * 전략을 파라미터로 받는 방식
     * @param strategy
     */
    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();
        strategy.call();
        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        System.out.println("result = " + result);
    }
}
