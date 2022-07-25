package com.muslim.prayer.pro.service;


import com.muslim.prayer.pro.constants.CalculationMethod;
import com.muslim.prayer.pro.dto.PrayerTime;

import java.util.TimeZone;

/**
 * @author : pinghongju
 * @description : query muslim prayer time
 * @date : 2022/7/19 15:16
 */
public interface MuslimPrayerProService {
    String DEFAULT_CALCULATIONMETHOD = CalculationMethod.MWL;

    String PARENT_PATH = "prayer-time";

    /**
     * get prayer time,just support indonesia country
     *
     * @param city city name
     * @param timeZone time zone
     * @param calculationMethod prayer time calculation method
     * @param timestamp timestamp
     * @return prayer time
     */
    PrayerTime getPrayerTime(String city, TimeZone timeZone, String calculationMethod, long timestamp);

}
