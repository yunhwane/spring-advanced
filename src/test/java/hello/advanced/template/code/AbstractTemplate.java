package hello.advanced.template.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        // 부가 기능
        long startTime = System.currentTimeMillis();
        //로직 시작

        call(); // 추상 메서드

        //로직 종료
        long endTime = System.currentTimeMillis();

        long result = endTime - startTime;
        log.info("result = {}", result);
    }

    protected abstract void call();
}
