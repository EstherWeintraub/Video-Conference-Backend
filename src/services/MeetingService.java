package services;

import entities.Meeting;
import io.skai.template.dataaccess.dto.budgetoversight.MeetingDto;
import io.skai.template.dataaccess.entities.VideoConference;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MeetingService {

    public static Integer createMeetingAndReceiveMeetingId(String fileNumber){
        final var meetingId = dao.insertMeeting(fileNumber);
        return meetingId;
    }
    public static MeetingDto getMeetingDtoByMeetingId(Long meetingId) {
        return MeetingDto.builder()
                .participants()
                .hearingDetails()
                .build();
    }

    public static Meeting getMeetingById(Long meetingId) {
        //should fetch from all tables with information about specific file of this meeting
        return dao.fetchMeeting();
    }

}
