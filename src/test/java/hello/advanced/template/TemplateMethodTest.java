package hello.advanced.template;


import hello.advanced.template.code.AbstractTemplate;
import hello.advanced.template.code.SubClassLogic1;
import hello.advanced.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

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
     * 템플릿 메서드 패턴 적용
     */
    @Test
    void templateMethodV1() {
        AbstractTemplate logic1 = new SubClassLogic1();
        logic1.execute();

        AbstractTemplate logic2 = new SubClassLogic2();
        logic2.execute();
    }

}
