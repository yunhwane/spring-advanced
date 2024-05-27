package hello.advanced.app.v4;


import hello.advanced.logtrace.LogTrace;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

        public void save(String itemId) throws InterruptedException {

            AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
                @Override
                protected Void call() throws InterruptedException {
                    if(itemId.equals("ex")) {
                        throw new IllegalArgumentException("item is null");
                    }
                    sleep(1000);
                    return null;
                }
            };
            template.execute("OrderRepository.save()");
        }

        private void sleep(int i) throws InterruptedException {
            Thread.sleep(i);
        }
}
