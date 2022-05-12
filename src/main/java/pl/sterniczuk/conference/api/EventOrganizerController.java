package pl.sterniczuk.conference.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sterniczuk.conference.service.eventOrganizer.EventOrganizerService;
import pl.sterniczuk.conference.service.eventOrganizer.Statistics;
import pl.sterniczuk.conference.service.eventOrganizer.StatisticsDto;
import pl.sterniczuk.conference.service.user.UserDto;

import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/admin")
public class EventOrganizerController {

    private final EventOrganizerService eventOrganizerService;

    @GetMapping
    public List<UserDto> getUser(){
        return eventOrganizerService.getUser();
    }

    @GetMapping("/statistics")
    public List<StatisticsDto> getStatistics(Statistics statistics){
        return eventOrganizerService.getStatistics(statistics);
    }
}
