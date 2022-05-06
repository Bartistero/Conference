package pl.sterniczuk.conference.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sterniczuk.conference.service.meeting.MeetingSaveDto;
import pl.sterniczuk.conference.service.meeting.MeetingService;

@RestController()
@RequestMapping("/meeting")
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;

    @PostMapping
    public MeetingSaveDto save(MeetingSaveDto meetingSaveDto) {
        return meetingService.save(meetingSaveDto);
    }
}
