package com.muslim.prayer.pro;


import com.alibaba.fastjson.JSONObject;
import com.muslim.prayer.pro.dto.PrayerTime;
import com.muslim.prayer.pro.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author : pinghongju 1460
 * @description : [描述说明该类的功能]
 * @date : 2022/7/21 10:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MuslimPrayerProAppTest {
    @Autowired
    MuslimPrayerProApp muslimPrayerProApp;

    @Test
    public void getPrayerTimeByCity() {
        try {
            URL url = this.getClass().getClassLoader().getResource("muslim_ID_city_name.txt");
            File file = new File(url.getPath());
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String city = null;
            while ((city = reader.readLine()) != null) {
                Response<PrayerTime> response = muslimPrayerProApp.getPrayerTime(city);
                if(response.getCode() == 200){
                    log.info("query success,data:{}",JSONObject.toJSONString(response.getData()));
                } else{
                    log.warn("query fail,msg:{}",response.getMsg());
                }
            }
        } catch (Exception e){
            e.getStackTrace();

        }

    }

}