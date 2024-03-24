package hello.advanced.app.v3;


import hello.advanced.logtrace.LogTrace;
import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

        public void save(String itemId) throws InterruptedException {

            TraceStatus status = null;

            try{
                status = trace.begin("OrderRepository.save()");
                if(itemId.equals("ex")) {
                    throw new IllegalArgumentException("item is null");
                }
                sleep(1000);
                trace.end(status);

            } catch (Exception e) {
                trace.exception(status, e);
                throw e; // 예외를 꼭 다시 던져 줘야 한다.
                /**
                 * 정상 흐름으로 진행하기 때문에 무조건 예외를 던져줘야한다.
                 */
            }

        }

        private void sleep(int i) throws InterruptedException {
            Thread.sleep(i);
        }
}
