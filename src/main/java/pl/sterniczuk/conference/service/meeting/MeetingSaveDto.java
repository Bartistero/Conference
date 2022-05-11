package pl.sterniczuk.conference.service.meeting;

import lombok.Getter;
import lombok.Setter;
import pl.sterniczuk.conference.model.Lecturer.Lecture;
import pl.sterniczuk.conference.model.Meeting;
import pl.sterniczuk.conference.model.Path.Path;
import pl.sterniczuk.conference.service.user.UserDto;

@Getter
@Setter
public class MeetingSaveDto {

    Lecture lecture;
    Path path;
    UserDto userDto;

    public static Meeting meetingDtoToMeeting(MeetingSaveDto meetingSaveDto) {
        Meeting meeting = new Meeting();
        meeting.setLecture(meetingSaveDto.getLecture());
        meeting.setPath(meetingSaveDto.getPath());
        meeting.setUser(UserDto.UserDtoToUser(meetingSaveDto.getUserDto()));
        return meeting;
    }

    public static MeetingSaveDto meetingToMeetingDto(Meeting meeting, MeetingSaveDto meetingSaveDto) {
        meetingSaveDto.setLecture(meeting.getLecture());
        meetingSaveDto.setPath(meeting.getPath());
        meetingSaveDto.setUserDto(UserDto.userToUserDro(meeting.getUser()));
        return meetingSaveDto;
    }
}
