package pl.sterniczuk.conference.service;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LessonDto {

    String name;
    LocalDateTime begin;
    LocalDateTime end;
}
