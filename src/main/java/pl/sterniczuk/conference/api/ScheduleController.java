package pl.sterniczuk.conference.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sterniczuk.conference.service.PathDto;
import pl.sterniczuk.conference.service.ScheduleService;

import java.util.List;

@RestController()
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping
    public List<PathDto> get() {
        return scheduleService.getPlan();
    }
}
