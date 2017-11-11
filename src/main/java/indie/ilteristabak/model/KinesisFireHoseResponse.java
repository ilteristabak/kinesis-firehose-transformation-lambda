package indie.ilteristabak.model;

import java.io.Serializable;
import java.util.List;

public class KinesisFireHoseResponse implements Serializable, Cloneable {
    private List<FireHoseRecord> records;

    public KinesisFireHoseResponse(List<FireHoseRecord> records) {
        this.records = records;
    }

    public KinesisFireHoseResponse() {
    }

    public List<FireHoseRecord> getRecords() {
        return records;
    }

    public void setRecords(List<FireHoseRecord> records) {
        this.records = records;
    }
}
