package hello.advanced.app.v0;


import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV0 {

        public void save(String itemId) throws InterruptedException {
            if(itemId.equals("ex")) {
                throw new IllegalArgumentException("item is null");
            }

            sleep(1000);
        }

        private void sleep(int i) throws InterruptedException {
            Thread.sleep(i);
        }
}
