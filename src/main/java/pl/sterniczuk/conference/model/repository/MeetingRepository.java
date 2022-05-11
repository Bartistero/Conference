package pl.sterniczuk.conference.model.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sterniczuk.conference.model.Meeting;

import java.util.List;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {

}
