package pl.sterniczuk.conference.model.Lecturer;

import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

public class LectureConverter implements AttributeConverter<Lecture, Long> {

    @Override
    public Long convertToDatabaseColumn(Lecture lecture) {
        if (lecture == null) {
            return null;
        }
        return lecture.getNumber();
    }

    @Override
    public Lecture convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(Lecture.values())
                .filter(f -> f.getNumber().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
