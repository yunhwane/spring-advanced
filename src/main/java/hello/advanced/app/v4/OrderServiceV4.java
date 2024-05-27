package hello.advanced.app.v4;


import hello.advanced.logtrace.LogTrace;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepositoryV4;
    private final LogTrace trace;
    public void orderItem(String itemId) throws InterruptedException {


        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() throws InterruptedException {
                orderRepositoryV4.save(itemId);
                return null;
            }
        };

        template.execute("OrderService.orderItem");
    }

}
