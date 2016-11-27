package rating.model;

import lombok.Data;

@Data
public class Rating {

    private String chargeStationId;
    private int functionality;
    private int accessibility;
    private int price;
    private String comment;
}
