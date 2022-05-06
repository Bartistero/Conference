package pl.sterniczuk.conference.model.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sterniczuk.conference.model.Meeting;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {
}
