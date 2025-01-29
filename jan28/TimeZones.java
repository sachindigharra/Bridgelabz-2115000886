package jan28;

import java.time.*;

public class TimeZones {

    public static void main(String[] args) {
        ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime ist = ZonedDateTime.now(ZoneId.of("Asia/Kolkata")); 
        ZonedDateTime pst = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        System.out.println("GMT: " + gmt);
        System.out.println("IST: " + ist);
        System.out.println("PST: " + pst);
    }
}