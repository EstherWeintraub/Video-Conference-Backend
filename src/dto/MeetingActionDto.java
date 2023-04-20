package dto;

import lombok.Builder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
@Builder(toBuilder = true)
public record MeetingActionDto(@JsonProperty("participant_id") Long participantId,
                          @JsonProperty("action_type")
                          VCActionType actionType){
}