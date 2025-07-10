package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Build {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("buildTypeId")
    private String buildTypeId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("state")
    private String state;

    @JsonProperty("number")
    private String number;

    @JsonProperty("branchName")
    private String branchName;
}
