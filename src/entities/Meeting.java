package entities;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Meeting {
    long meetingId;
    Long fileNumber;
    List<Participant> joinedParticipants;

    public void join(long participantId) {

    }

    public void mute(long participantId) {

    }
}
