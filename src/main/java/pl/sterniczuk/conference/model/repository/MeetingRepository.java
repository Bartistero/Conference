package pl.sterniczuk.conference.model.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sterniczuk.conference.model.Lecture.Lecture;
import pl.sterniczuk.conference.model.Meeting;
import pl.sterniczuk.conference.model.Path.Path;

import java.util.List;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {
    List<Meeting> findAllByPathAndLecture(Path Path, Lecture Lecture);
    List<Meeting> findAll();
    List<Meeting> findAllByPath(Path path);
    List<Meeting> findAllByLecture(Lecture lecture);

}
