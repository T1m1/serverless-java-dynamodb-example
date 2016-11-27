package rating.model;


import lombok.Data;

import java.util.List;

@Data
public class ListResponse {
    private String message;
    private List<Rating> ratings;

    public ListResponse(String message, List<Rating> ratings) {
        this.message = message;
        this.ratings = ratings;
    }
}
