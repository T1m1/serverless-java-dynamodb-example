package rating.model;

import lombok.Data;

@Data
public class Response {

    private String message;
    private Request request;

    public Response(String message, Request request) {
        this.message = message;
        this.request = request;
    }

    public Response() {
    }
}
