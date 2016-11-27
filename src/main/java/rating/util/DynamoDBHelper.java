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
        ArrayList<Rating> result = new ArrayList<Rating>();
        for (Map item : scan.getItems()) {
            Rating rating = new Rating();
            rating.setChargeStationId(((AttributeValue) item.get("chargeStationId")).getS());
            rating.setFunctionality(Util.getIntegerValue(item, "functionality"));
            rating.setAccessibility(Util.getIntegerValue(item, "accessibility"));
            rating.setPrice(Util.getIntegerValue(item, "price"));
            result.add(rating);
        }
        return result;
    }

    public static Item ratingToDBItem(Rating rating) {
        Item item = new Item();
        item.withString("id", UUID.randomUUID().toString());
        item.withString("chargeStationId", rating.getChargeStationId());
        item.withInt("functionality", rating.getFunctionality());
        item.withInt("accessibility", rating.getAccessibility());
        item.withInt("price", rating.getPrice());
        if (rating.getComment() != null) {
            item.withString("comment", rating.getComment());
        }
        return item;
    }
}