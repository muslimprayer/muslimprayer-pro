package com.muslim.prayer.pro;

import com.muslim.prayer.pro.dto.PrayerTime;
import com.muslim.prayer.pro.dto.Response;
import com.muslim.prayer.pro.service.MuslimPrayerProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.TimeZone;

/**
 * @author : pinghongju
 * @description : query muslim prayer time
 * @date : 2022/7/19 15:16
 */
@Service
public class MuslimPrayerProApp {
    @Autowired
    private MuslimPrayerProService muslimPrayerProService;

    /**
     * get today prayer time by city,time zone is system default,prayer time calculation is MWL (Muslim World League)
     *
     * @param city city name
     * @return prayer time response
     */
    public Response<PrayerTime> getPrayerTime(String city) {
        return getPrayerTime(city, TimeZone.getDefault(), MuslimPrayerProService.DEFAULT_CALCULATIONMETHOD,new Date().getTime());
    }

    /**
     * get today prayer time by city,prayer time calculation is MWL (Muslim World League)
     *
     * @param city     city name
     * @param timeZone time zone
     * @return prayer time response
     */
    public Response<PrayerTime> getPrayerTime(String city, TimeZone timeZone) {
        return getPrayerTime(city, timeZone, MuslimPrayerProService.DEFAULT_CALCULATIONMETHOD,new Date().getTime());
    }

    /**
     * get today prayer time by city,time zone is system default
     *
     * @param city              city name
     * @param calculationMethod calculation method
     * @return prayer time response
     */
    public Response<PrayerTime> getPrayerTime(String city, String calculationMethod) {
        return getPrayerTime(city, TimeZone.getDefault(), calculationMethod,new Date().getTime());
    }

    /**
     * get today prayer time by city,time zone,calculation method
     *
     * @param city              city name
     * @param timeZone          time zone
     * @param calculationMethod calculation method
     * @return prayer time response
     */
    public Response<PrayerTime> getPrayerTime(String city, TimeZone timeZone, String calculationMethod) {
        return getPrayerTime(city, timeZone, calculationMethod, new Date().getTime());
    }

    /**
     * get prayer time by city,timestamp,time zone is system default,prayer time calculation is MWL (Muslim World League)
     *
     * @param city      city name
     * @param timestamp timestamp
     * @return prayer time response
     */
    public Response<PrayerTime> getPrayerTime(String city, long timestamp) {
        return getPrayerTime(city, TimeZone.getDefault(), MuslimPrayerProService.DEFAULT_CALCULATIONMETHOD, timestamp);
    }

    /**
     * get prayer time by city,time zone,timestamp,prayer time calculation is MWL (Muslim World League)
     *
     * @param city      city name
     * @param timeZone  time zone
     * @param timestamp timestamp
     * @return prayer time response
     */
    public Response<PrayerTime> getPrayerTime(String city, TimeZone timeZone, long timestamp) {
        return getPrayerTime(city, timeZone, MuslimPrayerProService.DEFAULT_CALCULATIONMETHOD, timestamp);
    }

    /**
     * get prayer time by city,time zone,calculation method,timestamp
     *
     * @param city              city name
     * @param timeZone          time zone
     * @param calculationMethod calculation method
     * @param timestamp         timestamp
     * @return prayer time response
     */
    public Response<PrayerTime> getPrayerTime(String city, TimeZone timeZone, String calculationMethod, long timestamp) {
        PrayerTime prayerTime = muslimPrayerProService.getPrayerTime(city, timeZone, calculationMethod, timestamp);
        Response<PrayerTime> response = new Response<>();
        if (prayerTime != null) {
            return response.getSuccess(prayerTime);

        }

        return response.getNotExistFail("not find " + city + "city prayer time data");
    }
}
