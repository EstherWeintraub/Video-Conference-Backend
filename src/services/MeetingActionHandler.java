package services;

import entities.Meeting;
import enums.MeetingActionType;
import io.skai.template.dataaccess.entities.VideoConference;
import io.skai.template.enums.budgetoversight.VCActionType;

public interface MeetingActionHandler {
     void update(Meeting videoConference, long participantId);
     MeetingActionType getType();
}
