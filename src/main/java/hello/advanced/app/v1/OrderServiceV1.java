package hello.advanced.app.v1;


import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepositoryV1;
    private final HelloTraceV1 trace;
    public void orderItem(String itemId) throws InterruptedException {

        TraceStatus status = null;

        try{
            status = trace.begin("OrderService.request");
            orderRepositoryV1.save(itemId);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져 줘야 한다.
            /**
             * 정상 흐름으로 진행하기 때문에 무조건 예외를 던져줘야한다.
             */
        }
    }

}
