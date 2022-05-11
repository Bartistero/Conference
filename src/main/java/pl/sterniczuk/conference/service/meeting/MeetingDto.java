package pl.sterniczuk.conference.service.meeting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sterniczuk.conference.model.Meeting;

@Getter
@Setter
@NoArgsConstructor
public class MeetingDto extends MeetingSaveDto {

    Long id;

    public static MeetingDto MeetingToMeetingDto(Meeting meeting) {
        MeetingDto meetingDto = new MeetingDto();
        MeetingSaveDto.meetingToMeetingDto(meeting, meetingDto);
        meetingDto.setId(meeting.getId());
        return meetingDto;
    }
}
