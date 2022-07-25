package com.muslim.prayer.pro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : pinghongju
 * @description : prayer time
 * @date : 2022/7/20 16:54
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrayerTime {
    private String fajr;
    private String sunrise;
    private String dhuhr;
    private String asr;
    private String maghrib;
    private String isha;
}
