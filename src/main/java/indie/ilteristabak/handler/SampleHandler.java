package indie.ilteristabak.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.KinesisFirehoseEvent;
import indie.ilteristabak.enumeration.transformedState;
import indie.ilteristabak.model.FireHoseRecord;
import indie.ilteristabak.model.KinesisFireHoseResponse;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SampleHandler implements RequestHandler<KinesisFirehoseEvent,KinesisFireHoseResponse> {

    public KinesisFireHoseResponse handleRequest(KinesisFirehoseEvent kinesisFirehoseEvent, Context context) {
        List<FireHoseRecord> fireHoseRecordList = new ArrayList();
        for(KinesisFirehoseEvent.Record record: kinesisFirehoseEvent.getRecords()){
            String recorId = record.getRecordId();
            FireHoseRecord fireHoseRecord;
            try {
                String data = new String(record.getData().array(),"UTF-8");
                if(data.isEmpty()){
                    fireHoseRecord =
                            new FireHoseRecord(recorId)
                                    .withResult(FireHoseRecord.transformationState(transformedState.DROPPED));
                } else{
                    /*
                    * Transformation on data
                    * */
                    String transformedData = data;

                    fireHoseRecord =
                            new FireHoseRecord(recorId)
                                    .withResult(FireHoseRecord.transformationState(transformedState.OK))
                                    .withData(FireHoseRecord.encodeData(transformedData));
                }
            } catch (UnsupportedEncodingException e) {
                fireHoseRecord = new FireHoseRecord(recorId)
                        .withResult(FireHoseRecord.transformationState(transformedState.PROCESSING_FAILED));
            }
            fireHoseRecordList.add(fireHoseRecord);
        }
        return new KinesisFireHoseResponse(fireHoseRecordList);
    }
}