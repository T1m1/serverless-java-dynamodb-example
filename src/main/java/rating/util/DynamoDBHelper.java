package rating.util;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import rating.model.Rating;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DynamoDBHelper {


    public static List<Rating> convertResultToRating(ScanResult scan) {
        ArrayList<Rating> result = new ArrayList<>();
        for (Map<String, AttributeValue> item : scan.getItems()) {
            Rating rating = new Rating();
            rating.setChargeStationId(item.get(Constants.CHARGE_STATION_ID).getS());
            rating.setFunctionality(Util.getIntegerValue(item, Constants.FUNCTIONALITY));
            rating.setAccessibility(Util.getIntegerValue(item, Constants.ACCESSIBILITY));
            rating.setPrice(Util.getIntegerValue(item, Constants.PRICE));
            result.add(rating);
        }
        return result;
    }

    public static Item ratingToDBItem(Rating rating) {
        Item item = new Item();
        item.withString("id", UUID.randomUUID().toString());
        item.withString(Constants.CHARGE_STATION_ID, rating.getChargeStationId());
        item.withInt(Constants.FUNCTIONALITY, rating.getFunctionality());
        item.withInt(Constants.ACCESSIBILITY, rating.getAccessibility());
        item.withInt(Constants.PRICE, rating.getPrice());
        if (rating.getComment() != null) {
            item.withString(Constants.COMMENT, rating.getComment());
        }
        return item;
    }
}