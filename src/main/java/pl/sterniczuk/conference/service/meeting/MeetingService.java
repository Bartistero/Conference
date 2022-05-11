package pl.sterniczuk.conference.service.meeting;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sterniczuk.conference.model.Meeting;
import pl.sterniczuk.conference.model.User;
import pl.sterniczuk.conference.model.repository.MeetingRepository;
import pl.sterniczuk.conference.model.repository.UserRepository;
import pl.sterniczuk.conference.mail.Mail;
import pl.sterniczuk.conference.service.exception.AlreadyExistsException;
import pl.sterniczuk.conference.service.exception.LimitException;
import pl.sterniczuk.conference.service.exception.NotFoundException;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;
    private final UserRepository userRepository;
    private final Mail mail;

    @Transactional
    public MeetingSaveDto save(MeetingSaveDto meetingSaveDto) throws FileNotFoundException, AlreadyExistsException, LimitException {
        if(userRepository.findUserByLogin(meetingSaveDto.getUserDto().getLogin()).isPresent())
            throw new AlreadyExistsException("User with login: " + meetingSaveDto.getUserDto().getLogin() + " already exists");
        List<Meeting> meeting = meetingRepository.findAllByPathAndLecture(meetingSaveDto.getPath(),meetingSaveDto.getLecture());
        if(meeting.size() >=5) {
            throw new LimitException("the limit of students for this course has been exhausted");
        }
        meetingRepository.save(MeetingSaveDto.meetingDtoToMeeting(meetingSaveDto));
        mail.send(meetingSaveDto.getUserDto().getEmail(),meetingSaveDto.getUserDto().getLogin());
        return meetingSaveDto;
    }

    public List<MeetingDto> get(String login) throws NotFoundException {
        User user = userRepository.findAllByLogin(login).orElseThrow(() -> new NotFoundException("user with login : " + login + " not found"));
        return user.getMeetings().stream()
                .map(MeetingDto::MeetingToMeetingDto)
                .collect(Collectors.toList());
    }
}
