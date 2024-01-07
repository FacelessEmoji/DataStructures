package study.data.structures.CourseWork.CustomMap;

import java.util.Objects;

public class CustomKeyValue<Key, Value> {
    private Key key;
    private Value value;

    public CustomKeyValue(Key key, Value value) {
        this.setKey(key);
        this.setValue(value);
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return combineHashCodes(key.hashCode(), value.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomKeyValue<?, ?> CustomKeyValue = (CustomKeyValue<?, ?>) o;
        return Objects.equals(key, CustomKeyValue.key) &&
            Objects.equals(value, CustomKeyValue.value);
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", key, value);
    }

    private int combineHashCodes(int h1, int h2) {
        return ((h1 << 5) + h1) ^ h2;
    }
}
