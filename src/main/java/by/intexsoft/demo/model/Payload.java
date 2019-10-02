package by.intexsoft.demo.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Payload {
    private Map<String, Object> fields = new LinkedHashMap<>();

    @JsonAnySetter
    void setField(String key, Object value) {
        fields.put(key, value);
    }

    public Object getField(String key) {
        return fields.get(key);
    }
}
