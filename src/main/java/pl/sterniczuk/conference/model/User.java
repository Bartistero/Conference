package pl.sterniczuk.conference.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class User extends IdModel {

    String login;
    String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Meeting> meetings;

}
