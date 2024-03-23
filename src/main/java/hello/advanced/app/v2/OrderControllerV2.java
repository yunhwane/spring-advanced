package hello.advanced.app.v2;


import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    public String request(String itemId) throws InterruptedException {

        TraceStatus status = null;

        try{
            status = trace.begin("OrderController.request");
            orderService.orderItem(itemId, status.getTraceId());
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져 줘야 한다.
            /**
             * 정상 흐름으로 진행하기 때문에 무조건 예외를 던져줘야한다.
             */
        }


    }
}
