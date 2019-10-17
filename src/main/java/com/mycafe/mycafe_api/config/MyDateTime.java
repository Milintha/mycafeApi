package com.mycafe.mycafe_api.config;

import com.mycafe.mycafe_api.payloads.DateDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Configuration
public class MyDateTime {
    private String offset="+05:30";
    private String offsetType="UTC";

    @Bean
    public DateDTO getCurrentDate(){

        ZoneOffset zoneOffset = ZoneOffset.of(offset);
        ZoneId zoneId= ZoneId.ofOffset(offsetType, zoneOffset);
        LocalTime offsetTime = LocalTime.now(zoneId);
        DateTimeFormatter tformatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime=offsetTime.format(tformatter);

        //yyyy-MM-dd
        DateTimeFormatter dformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate offsetDate=LocalDate.now(zoneId);
        String formatedDate = offsetDate.format(dformatter);


        return  new DateDTO(formatedDate,formattedTime);

    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public void setOffsetType(String offsetType) {
        this.offsetType = offsetType;
    }
}
