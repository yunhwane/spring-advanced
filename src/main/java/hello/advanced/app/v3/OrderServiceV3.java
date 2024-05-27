package hello.advanced.app.v3;


import hello.advanced.logtrace.LogTrace;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepositoryV3;
    private final LogTrace trace;
    public void orderItem(String itemId) throws InterruptedException {

        TraceStatus status = null;

        try{
            status = trace.begin("OrderService.orderItem");
            orderRepositoryV3.save(itemId);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져 줘야 한다.
            /**
             * 정상 흐름으로 진행하기 때문에 무조건 예외를 던져줘야한다.
             */
        }
    }

}
