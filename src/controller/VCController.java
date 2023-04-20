package controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import services.MeetingActionHandler;
import services.MeetingService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "api/vc")
@RequiredArgsConstructor
public class VCController {
    @Autowired
    private List<MeetingActionHandler> actionHandlers;

    @PostMapping("/create_meeting")
    public ResponseEntity<MeetingDto> createMeeting(@RequestBody String fileNumber) {
        try {
            final var meetingId = MeetingService.createMeetingAndReceiveMeetingId(fileNumber);
            final var meeting = MeetingService.getMeetingDtoByMeetingId(meetingId);
            return new ResponseEntity<>(successResponse(meeting), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Failed to create meeting", e);
            return new ResponseEntity<>(failedResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{meeting_id}")
    public ResponseEntity<MeetingDto> getMeetingDetails(@PathVariable("meeting_id") Long meeting_id) {
        try {
            final var meeting = MeetingService.getMeetingDtoByMeetingId(meeting_id);
            return new ResponseEntity<>(successResponse(meeting), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Failed to fetch video conference", e);
            return new ResponseEntity<>(failedResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("{meeting_id}")
    public ResponseEntity<Integer> setMeetingAction(@PathVariable("meeting_id") Long meeting_id,
                                                    @RequestBody MeetingActionDto meetingActionDto) {
        try {
            actionHandlers.stream()
                    .filter(h -> h.getType().equals(meetingActionDto.actionType())).findFirst().get()
                    .update(MeetingService.getMeetingById(meeting_id), meetingActionDto.participantId());

            return new ResponseEntity<>(successResponse(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Failed to fetch video conference", e);
            return new ResponseEntity<>(failedResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}