package pl.sterniczuk.conference.model.Path;

import lombok.Getter;

@Getter
public enum Path {
    FIRST_PATH(1L),
    SECOND_PATH(2L),
    THIRD_PATH(3L);

    private Long number;

    Path(Long number) {
        this.number = number;
    }
}
