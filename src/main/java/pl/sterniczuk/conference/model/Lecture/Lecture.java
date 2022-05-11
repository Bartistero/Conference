package pl.sterniczuk.conference.model.Lecture;

import lombok.Getter;

@Getter
public enum Lecture {
    FIRST_LECTURE(1L),
    SECOND_LECTURE(2L),
    THIRD_LECTURE(3L);

    private Long number;

    Lecture(Long number) {
        this.number = number;
    }
}
