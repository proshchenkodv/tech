package ru.itconsulting.tech.rest.utils;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TimeToHumanSight {
    public String millisToShortDHMS(long duration) {
        String res = "";
        long days = TimeUnit.MILLISECONDS.toDays(duration);
        long hours = TimeUnit.MILLISECONDS.toHours(duration)
                - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
        long millisecond = duration
                - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(duration));
        if (days == 0) {
            res = String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, millisecond);
        } else {
            res = String.format("%dd%02d:%02d:%02d:%03d", days, hours, minutes, seconds, millisecond);
        }
        return res;
    }
}
