package sk.mrtn.pixi.client.filters;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by klaun on 22/08/16.
 */

public enum FilterType {
    GRAY(0),SEPIA(1);

    private final Integer type;
    private static Map<Integer,FilterType> map = new HashMap<>();

    static {
        for (FilterType filterType : FilterType.values()) {
            map.put(filterType.type,filterType);
        }

    }

    FilterType(Integer type) {

        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static FilterType valueOf(Integer type) {
        if (type == null) {
            return null;
        }
        return map.get(type);
    }
}
