package hello.advanced.app.v2;


import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;
    private final HelloTraceV2 trace;
    public void orderItem(String itemId, TraceId traceId) throws InterruptedException {

        TraceStatus status = null;

        try{
            status = trace.beginSync(traceId,"OrderService.orderItem");
            orderRepositoryV2.save(itemId, status.getTraceId());
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져 줘야 한다.
            /**
             * 정상 흐름으로 진행하기 때문에 무조건 예외를 던져줘야한다.
             */
        }
    }

}
