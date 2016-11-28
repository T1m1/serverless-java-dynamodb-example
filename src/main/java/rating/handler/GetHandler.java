package rating.handler;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import rating.model.ListResponse;
import rating.model.Rating;
import rating.util.Constants;
import rating.util.DynamoDBHelper;
import rating.util.Util;

import java.util.HashMap;
import java.util.List;

public class GetHandler implements RequestHandler<Rating, ListResponse> {

    @Override
    public ListResponse handleRequest(Rating rating, Context context) {
        AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient().withRegion(Region.getRegion(Regions.US_EAST_1));
        if (rating.getChargeStationId() == null) {
            Util.throwMissingKeyException(Constants.CHARGE_STATION_ID);
        }
        Condition scanFilterCondition = new Condition()
                .withComparisonOperator(ComparisonOperator.EQ.toString())
                .withAttributeValueList(new AttributeValue().withS(rating.getChargeStationId()));

        HashMap<String, Condition> conditions = new HashMap<>();

        conditions.put(Constants.CHARGE_STATION_ID, scanFilterCondition);
        ScanRequest scanRequest = new ScanRequest().withTableName(Constants.DB_NAME).withScanFilter(conditions);

        List<Rating> result = DynamoDBHelper.convertResultToRating(dynamoDBClient.scan(scanRequest));

        return new ListResponse("GET result for chargeStationId: " + rating.getChargeStationId(), result);
    }

}
