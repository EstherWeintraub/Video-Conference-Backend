package services;

import entities.Meeting;
import enums.MeetingActionType;
import enums.Permissions;
import io.skai.template.dataaccess.entities.ParticipantPermissions;
import io.skai.template.dataaccess.entities.VideoConference;
import io.skai.template.enums.budgetoversight.Permissions;
import io.skai.template.enums.budgetoversight.VCActionType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class MutateAll implements MeetingActionHandler {

    @Autowired
    private List<ParticipantPermissions> permissions;

    @Override
    public void update(Meeting meeting, long participantId) {
        if (Permissions.ADMIN.equals(getParticipantsPermissions(participantId))){
            getJoinedParticipantsIds(meeting_id).filter(p-> !p.getParticipant(participantId)).forEach(p-> meeting.mute(p));
        }else {
            throw new RuntimeException("User is not allowed to mute all other users");
        }
    }

    private Permissions getParticipantsPermissions(long participantId) {
        return permissions.stream()
                .filter(p-> p.getRole().equals(getParticipant(participantId).getRole()))
                .findFirst()
                .map(ParticipantPermissions::getPermissions)
                .orElse(Permissions.STANDARD);
    }

    @Override
    public MeetingActionType getType() {
        return MeetingActionType.MUTE_ALL;
    }

}