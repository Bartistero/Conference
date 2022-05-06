package pl.sterniczuk.conference.service.meeting;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sterniczuk.conference.model.repository.MeetingRepository;

@Service
@AllArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;

    public MeetingSaveDto save(MeetingSaveDto meetingSaveDto){
        meetingRepository.save(MeetingSaveDto.MeetingDtoToMeeting(meetingSaveDto));
        return meetingSaveDto;
    }
}
