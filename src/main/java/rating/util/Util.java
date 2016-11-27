package rating.util;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import rating.model.Rating;

import java.util.Map;

public class Util {
    public static void throwMissingKeyException(String key) {
        throw new IllegalArgumentException("400 Bad Rating -- key: '" + key + "' is required");
    }

    public static int getIntegerValue(Map<String, AttributeValue> item, String id) {
        if (item.get(id) != null) return Integer.parseInt(item.get(id).getN());
        return 0;
    }

    public static void checkParameter(Rating rating) {
        if (rating.getChargeStationId() == null) Util.throwMissingKeyException(Constants.CHARGE_STATION_ID);
        if (rating.getFunctionality() == 0) Util.throwMissingKeyException(Constants.FUNCTIONALITY);
        if (rating.getAccessibility() == 0) Util.throwMissingKeyException(Constants.ACCESSIBILITY);
        if (rating.getPrice() == 0) Util.throwMissingKeyException(Constants.PRICE);
    }
}