package persistence;

import org.json.JSONObject;

// Code sourced from JsonSerializationDemo - Writable
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
