package indie.ilteristabak.model;

import indie.ilteristabak.enumeration.transformedState;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class FireHoseRecord implements Serializable, Cloneable  {
    private String recordId;
    private String result;
    private String data;

    public FireHoseRecord(String recordId) {
        this.recordId = recordId;
    }
    public FireHoseRecord() {
    }

    public FireHoseRecord withRecordId(String recordId){
        this.recordId = recordId;
        return this;
    }
    public FireHoseRecord withResult(String result){
        this.result = result;
        return this;
    }
    public FireHoseRecord withData(String data){
        this.data = data;
        return this;
    }
    public static String transformationState(transformedState transformed_state){
        return transformed_state.text();
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static String encodeData(String data) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8.name()));
    }
    public static String decodeData(String data){
        return Base64.getDecoder().decode(data).toString();
    }
}
