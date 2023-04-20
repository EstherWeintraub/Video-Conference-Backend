package dto;

import lombok.Builder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
@Builder(toBuilder = true)
public record MeetingDto(@JsonProperty("id") Long id,
                    @JsonProperty("participants_list")
                    List<ParticipantDTO> participants,
                    @JsonProperty("hearing_details")
                    HearingDTO hearingDetails){
}