package addendum.challenge.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.UUID;

@JsonDeserialize(builder = Beneficiary.BeneficiaryBuilder.class)
public class Beneficiary {
    private Integer id;
    private UUID uniqueCode;
    private String name;

    public static class BeneficiaryBuilder {
        private Integer id;
        private UUID uniqueCode;
        private String name;

        @JsonProperty("id")
        public BeneficiaryBuilder id(Integer id){
            this.id = id;
            return this;
        }
        @JsonProperty("uniqueCode")
        public BeneficiaryBuilder uniqueCode(UUID uniqueCode){
            this.uniqueCode = uniqueCode;
            return this;
        }
        @JsonProperty("name")
        public BeneficiaryBuilder name(String name){
            this.name = name;
            return this;
        }
        public Beneficiary build() {
            return new Beneficiary(this);
        }

    }
    private Beneficiary(BeneficiaryBuilder builder) {
        this.id = builder.id;
        this.uniqueCode = builder.uniqueCode;
        this.name = builder.name;
    }

    public Integer getId() {
        return id;
    }

    public UUID getUniqueCode() {
        return uniqueCode;
    }

    public String getName() {
        return name;
    }

    public String toJson(){
        return "{\"name\":" + this.name + "\",\"unique_code\":\"" + this.uniqueCode + "\"}";
    }
}
