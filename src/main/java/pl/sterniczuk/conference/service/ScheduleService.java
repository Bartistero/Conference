package pl.sterniczuk.conference.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    public List<PathDto> getPlan() {

        List<PathDto> paths = new ArrayList<>();
        List<LessonDto> lessons = setLessons();

        PathDto firstPath = new PathDto();
        firstPath.setPathName("First Path");
        firstPath.setLessons(lessons);
        paths.add(firstPath);

        PathDto secondPath = new PathDto();
        secondPath.setPathName("second Path");
        secondPath.setLessons(lessons);
        paths.add(secondPath);

        PathDto thirdPath = new PathDto();
        thirdPath.setPathName("third Path");
        thirdPath.setLessons(lessons);
        paths.add(thirdPath);

        return paths;
    }

    private List<LessonDto> setLessons() {

        List<LessonDto> lessons = new ArrayList<>();

        LessonDto firstLesson = new LessonDto();
        firstLesson.setName("First lesson");
        firstLesson.setBegin(LocalDateTime.of(2022, 06, 01, 10, 00));
        firstLesson.setEnd(LocalDateTime.of(2022, 06, 01, 11, 45));
        lessons.add(firstLesson);

        LessonDto secondLesson = new LessonDto();
        secondLesson.setName("Second lesson");
        secondLesson.setBegin(LocalDateTime.of(2022, 06, 01, 12, 00));
        secondLesson.setEnd(LocalDateTime.of(2022, 06, 01, 13, 45));
        lessons.add(secondLesson);

        LessonDto thirdLesson = new LessonDto();
        thirdLesson.setName("Third Lesson");
        thirdLesson.setBegin(LocalDateTime.of(2022, 06, 01, 14, 00));
        thirdLesson.setEnd(LocalDateTime.of(2022, 06, 01, 15, 45));
        lessons.add(thirdLesson);

        return lessons;
    }
}
