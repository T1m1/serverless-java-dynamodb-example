package rating.handler;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import rating.model.Rating;
import rating.model.Response;
import rating.util.Constants;
import rating.util.DynamoDBHelper;
import rating.util.Util;

public class CreateHandler implements RequestHandler<Rating, Response> {

    public Response handleRequest(Rating rating, Context context) {
        AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient().withRegion(Region.getRegion(Regions.US_EAST_1));
        DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
        Table table = dynamoDB.getTable(Constants.DB_NAME);

        Util.checkParameter(rating);

        try {
            PutItemSpec putItemSpec = new PutItemSpec().withItem(DynamoDBHelper.ratingToDBItem((Rating) rating));
            table.putItem(putItemSpec);
        } catch (ConditionalCheckFailedException e) {
            throw new IllegalArgumentException("400 Bad Rating");

        }
        return new Response("Rating for charge station created!", rating);
    }


}
