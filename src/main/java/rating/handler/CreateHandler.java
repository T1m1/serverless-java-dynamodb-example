package rating.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import rating.model.Rating;
import rating.model.Response;

public class CreateHandler implements RequestHandler<Rating, Response> {

	@Override
	public Response handleRequest(Rating input, Context context) {
		return new Response("Go Serverless v1.0! Your function executed successfully!", input);
	}

}
