package pl.sterniczuk.conference.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sterniczuk.conference.service.exception.AlreadyExistsException;
import pl.sterniczuk.conference.service.exception.LimitException;
import pl.sterniczuk.conference.service.exception.NotFoundException;
import pl.sterniczuk.conference.service.meeting.MeetingDto;
import pl.sterniczuk.conference.service.meeting.MeetingSaveDto;
import pl.sterniczuk.conference.service.meeting.MeetingService;
import pl.sterniczuk.conference.service.user.UserDto;

import java.io.FileNotFoundException;
import java.util.List;

@RestController()
@RequestMapping("/meeting")
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;

    @PostMapping
    public MeetingSaveDto save(MeetingSaveDto meetingSaveDto) throws FileNotFoundException, AlreadyExistsException, LimitException {
        return meetingService.save(meetingSaveDto);
    }

    @GetMapping
    public List<MeetingDto> get(String login) throws NotFoundException {
        return meetingService.get(login);
    }

    @PutMapping
    public UserDto put(String login, String email) throws NotFoundException {
        return meetingService.put(login, email);
    }

    @DeleteMapping
    public Long delete(Long id) throws NotFoundException {
        return meetingService.delete(id);
    }
}
