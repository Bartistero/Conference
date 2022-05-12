package pl.sterniczuk.conference.service.eventOrganizer;

import org.springframework.stereotype.Service;
import pl.sterniczuk.conference.model.Lecture.Lecture;
import pl.sterniczuk.conference.model.Path.Path;
import pl.sterniczuk.conference.model.repository.MeetingRepository;
import pl.sterniczuk.conference.model.repository.UserRepository;
import pl.sterniczuk.conference.service.user.UserDto;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class EventOrganizerService {

    private final UserRepository userRepository;
    private final MeetingRepository meetingRepository;
    private final NumberFormat percentageFormat;

    public List<UserDto> getUser() {
        return userRepository.findAll().stream()
                .map(UserDto::userToUserDto)
                .collect(Collectors.toList());
    }

    public List<StatisticsDto> getStatistics(Statistics statistics) {

        if (statistics == Statistics.LESSON) {
            return lessonStatistics();
        } else {
            return pathStatistics();
        }
    }

    private List<StatisticsDto> lessonStatistics() {
        List<StatisticsDto> statisticsList = new ArrayList<>();
        double first = meetingRepository.findAllByLecture(Lecture.FIRST_LECTURE).size();
        double second = meetingRepository.findAllByLecture(Lecture.SECOND_LECTURE).size();
        double third = meetingRepository.findAllByLecture(Lecture.THIRD_LECTURE).size();
        double all = meetingRepository.findAll().size();
        if (all == 0) all = 1;

        StatisticsDto firstDto = new StatisticsDto(Lecture.FIRST_LECTURE.toString(), percentageFormat.format(first / all));
        statisticsList.add(firstDto);
        StatisticsDto secondDto = new StatisticsDto(Lecture.FIRST_LECTURE.toString(), percentageFormat.format(second / all));
        statisticsList.add(secondDto);
        StatisticsDto thirdDto = new StatisticsDto(Lecture.FIRST_LECTURE.toString(), percentageFormat.format(third / all));
        statisticsList.add(thirdDto);
        return statisticsList;
    }

    private List<StatisticsDto> pathStatistics() {
        List<StatisticsDto> statisticsList = new ArrayList<>();
        double first = meetingRepository.findAllByPath(Path.FIRST_PATH).size();
        double second = meetingRepository.findAllByPath(Path.SECOND_PATH).size();
        double third = meetingRepository.findAllByPath(Path.THIRD_PATH).size();
        double all = meetingRepository.findAll().size();
        if (all == 0) all = 1;

        StatisticsDto firstDto = new StatisticsDto(Path.FIRST_PATH.toString(), percentageFormat.format(first / all));
        statisticsList.add(firstDto);
        StatisticsDto secondDto = new StatisticsDto(Path.SECOND_PATH.toString(), percentageFormat.format(second / all));
        statisticsList.add(secondDto);
        StatisticsDto thirdDto = new StatisticsDto(Path.FIRST_PATH.toString(), percentageFormat.format(third / all));
        statisticsList.add(thirdDto);
        return statisticsList;
    }

    public EventOrganizerService(UserRepository userRepository, MeetingRepository meetingRepository) {
        this.userRepository = userRepository;
        this.meetingRepository = meetingRepository;
        Locale locale = new Locale("pl", "PL");
        percentageFormat = NumberFormat.getPercentInstance(locale);
    }
}
