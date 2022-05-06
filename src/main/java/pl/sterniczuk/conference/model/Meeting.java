package pl.sterniczuk.conference.model;

import lombok.Getter;
import lombok.Setter;
import pl.sterniczuk.conference.model.Lecturer.Lecture;
import pl.sterniczuk.conference.model.Lecturer.LectureConverter;
import pl.sterniczuk.conference.model.Path.Path;
import pl.sterniczuk.conference.model.Path.PathConverter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Meeting extends IdModel {

    @Column(name = "idPath")
    @Convert(converter = PathConverter.class)
    Path path;

    @Column(name = "idLecture")
    @Convert(converter = LectureConverter.class)
    Lecture lecture;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser", nullable = false)
    private User user;
}
