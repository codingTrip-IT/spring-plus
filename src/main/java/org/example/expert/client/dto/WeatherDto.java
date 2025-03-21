package org.example.expert.client.dto;

import lombok.Getter;

/**
 * WeatherDto : 날씨 DTO
 * 필드명 : 날짜, 날씨
 * */
@Getter
public class WeatherDto {

    private final String date;
    private final String weather;

    public WeatherDto(String date, String weather) {
        this.date = date;
        this.weather = weather;
    }
}
