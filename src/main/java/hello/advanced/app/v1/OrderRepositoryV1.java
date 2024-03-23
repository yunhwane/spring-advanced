package hello.advanced.app.v1;


import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 trace;

        public void save(String itemId) throws InterruptedException {

            TraceStatus status = null;

            try{
                status = trace.begin("OrderRepository.request");
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
