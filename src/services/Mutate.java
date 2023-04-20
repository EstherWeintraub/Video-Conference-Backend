package services;

import entities.Meeting;
import enums.MeetingActionType;
import io.skai.template.dataaccess.entities.VideoConference;
import io.skai.template.enums.budgetoversight.VCActionType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class Mutate implements MeetingActionHandler {

    @Override
    public void update(Meeting meeting, long participantId) {
        meeting.mute(participantId);
    }

    @Override
    public MeetingActionType getType() {
        return MeetingActionType.MUTE;
    }

}