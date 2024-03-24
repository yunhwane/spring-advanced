package hello.advanced.treadlocal.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    private ThreadLocal<String> nameStore = new ThreadLocal<>();


    public String logic(String name) {
        log.info("저장 name = {} -> nameStore = {}",name, nameStore.get());
        nameStore.set(name);
        sleep(1000);
        log.info("조회 nameStore = {}",nameStore.get());
        return nameStore.get();
    }

    public void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
