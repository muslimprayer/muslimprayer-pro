package com.muslim.prayer.pro.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.muslim.prayer.pro.dto.PrayerTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.muslim.prayer.pro.service.MuslimPrayerProService;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author : XXXX
 * @description : get muslim prayer time
 * @date : 2022/7/19 15:18
 */
@Service
@Slf4j
public class MuslimPrayerProServiceImpl implements MuslimPrayerProService {
    @Override
    public PrayerTime getPrayerTime(String city, TimeZone timeZone, String calculationMethod, long timestamp) {
        Date date = new Date(timestamp);
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        format.setTimeZone(timeZone);
        String dateFormat = format.format(date);

        URL url = this.getClass().getClassLoader().getResource("prayer-time");
        String path = url.getPath() + File.separator + city.replaceAll(" ", "") + File.separator + calculationMethod + ".txt";
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String text = null;
            while ((text = reader.readLine()) != null) {
                if (text.contains(dateFormat)) {
                    String[] datas = text.split(",");
                    PrayerTime prayerTime = PrayerTime.builder().fajr(datas[1]).sunrise(datas[2]).dhuhr(datas[3]).asr(datas[4]).maghrib(datas[5]).isha(datas[6]).build();
                    return prayerTime;
                }
            }
        } catch (IOException e) {
            log.error("get prayer time by {} city error,{}", city, e.getMessage());
        }
        return null;
    }
}
