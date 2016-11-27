package rating.model;

import lombok.Data;

@Data
public class Response {

    private String message;
    private Rating rating;

    public Response(String message, Rating rating) {
        this.message = message;
        this.rating = rating;
    }

}
