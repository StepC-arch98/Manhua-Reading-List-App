package persistence;

import org.json.JSONObject;

// Citation: Code sourced and modified from JsonSerializationDemo - Writable Interface
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject manhuaToJson();
}
