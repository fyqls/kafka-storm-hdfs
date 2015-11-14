package lisong.qiu.kafkaTOstorm;

import backtype.storm.spout.Scheme;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by qls on 11/12/15.
 */
public class TestMessageScheme implements Scheme {

    private static final Log LOG = LogFactory.getLog(TestMessageScheme.class);

    @Override
    public List<Object> deserialize(byte[] bytes) {
        try {
            String msg = new String(bytes, "UTF-8");
            return new Values(msg);
        } catch (Exception e) {
            LOG.error("Cannot parse the provided message!");
        }

        //TODO: what happend if returns null?
        return null;
    }

    @Override
    public Fields getOutputFields() {
        return new Fields("msg");
    }

}
