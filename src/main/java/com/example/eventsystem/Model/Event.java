package com.example.eventsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Event {
    private String id;
    private String description;
    private int capacity;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Event(){

    }
    public Event(String id, String description, int capacity , String startDate, String endDate){
        this.id = id;
        this.description = description;
        this.capacity = capacity;
        setStartDate(startDate);
        setEndDate(endDate);
    }
    public Event(String id, String description, int capacity , LocalDateTime startDate, LocalDateTime endDate){
        this.id = id;
        this.description = description;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setStartDate(String startDate){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        this.startDate = LocalDateTime.parse(startDate+"T00:00:00", formatter);
    }
    public void setEndDate(String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        this.endDate = LocalDateTime.parse(endDate+"T00:00:00",formatter);
    }
}



