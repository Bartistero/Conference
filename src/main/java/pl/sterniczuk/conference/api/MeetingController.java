package pl.sterniczuk.conference.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sterniczuk.conference.service.exception.AlreadyExistsException;
import pl.sterniczuk.conference.service.exception.NotFoundException;
import pl.sterniczuk.conference.service.meeting.MeetingDto;
import pl.sterniczuk.conference.service.meeting.MeetingSaveDto;
import pl.sterniczuk.conference.service.meeting.MeetingService;

import java.io.FileNotFoundException;
import java.util.List;

@RestController()
@RequestMapping("/meeting")
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;

    @PostMapping
    public MeetingSaveDto save(MeetingSaveDto meetingSaveDto) throws FileNotFoundException, AlreadyExistsException {
        return meetingService.save(meetingSaveDto);
    }

    @GetMapping
    public List<MeetingDto> get(String login) throws NotFoundException {
        return meetingService.get(login);
    }
}
