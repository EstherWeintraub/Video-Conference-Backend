package dto;

import lombok.Builder;

//This dto is for ui to display meeting details
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
@Builder
public record HearingDTO(@JsonProperty
                         Long meeting_id,
                         @JsonProperty
                         Long file_number,
                         @JsonProperty
                         String file_subject,
                         @JsonProperty
                         String hearing_details) {
}
