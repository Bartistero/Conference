package pl.sterniczuk.conference.model.Path;


import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

public class PathConverter implements AttributeConverter<Path, Long> {
    @Override
    public Long convertToDatabaseColumn(Path path) {
        if (path == null) {
            return null;
        }
        return path.getNumber();
    }

    @Override
    public Path convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(Path.values())
                .filter(f -> f.getNumber().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
