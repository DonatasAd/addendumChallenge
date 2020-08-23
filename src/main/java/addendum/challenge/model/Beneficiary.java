package addendum.challenge.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Beneficiary {
    private final Integer id;
    private final UUID unique_code;
    private final String name;

    public Beneficiary(
            Integer id,
            UUID unique_code,
            @JsonProperty("name") String name
    ) {
        this.id = id;
        this.unique_code = unique_code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public UUID getUnique_code() {
        return unique_code;
    }

    public String getName() {
        return name;
    }

    public String toJson(){
        return "{\"name\":" + this.name + "\",\"unique_code\":\"" + this.unique_code + "\"}";
    }
}
