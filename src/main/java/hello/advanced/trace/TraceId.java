package hello.advanced.trace;

import java.util.UUID;

public class TraceId {
    private String id;
    private int level;

    private TraceId(String id, int level) {
        this.id = id;
        this.level =level;
    }

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8); // uuid에서 8자리만 잘라서 사용
    }

    public TraceId createNextId() {
        return new TraceId(this.id, this.level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(this.id, this.level - 1);
    }

    public boolean isRoot() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

}
