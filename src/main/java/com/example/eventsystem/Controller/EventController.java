package com.example.eventsystem.Controller;

import com.example.eventsystem.ApiResponse.ApiResponse;
import com.example.eventsystem.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    ArrayList<Event> events = new ArrayList<>();


    public EventController() {

        events.add( new Event("EV4156","Boxing event",20,LocalDateTime.of(
                2024, Month.MARCH, 10, 14, 33, 48) ,LocalDateTime.of(
                2024, Month.AUGUST, 10, 14, 33, 48) ));

        events.add( new Event("EV2343","Sing event",20,LocalDateTime.of(
                2024, Month.JANUARY, 24, 14, 33, 48) ,LocalDateTime.of(
                2024, Month.JULY, 24, 14, 33, 48) ));
        events.add( new Event("EV3455","Book Gathering event",20,LocalDateTime.of(
                2024, Month.APRIL, 15, 14, 33, 48) ,LocalDateTime.of(
                2024, Month.DECEMBER, 15, 14, 33, 48) ));

        events.add( new Event("EV7657","Leap event",20,LocalDateTime.of(
                2024, Month.MAY, 24, 14, 33, 48) ,LocalDateTime.of(
                2024, Month.JUNE, 24, 14, 33, 48) ));
        events.add( new Event("EV7688","Football World Cup event",20,LocalDateTime.of(
                2024, Month.APRIL, 21, 14, 33, 48) ,LocalDateTime.of(
                2024, Month.DECEMBER, 21,14, 33, 48) ));
    }

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Event added successfully");
    }
    @GetMapping("/get")
    public ArrayList<Event> getEvents() {
        return events;
    }
    @GetMapping("/get/{id}")
    public ArrayList<Event> getEvents(@PathVariable String id) {

        return events.stream().filter(event -> event.getId().equals(id)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody Event event) {

        if (index >= events.size() || index < 0)return new ApiResponse("Event not found");

        events.set(index,event);
        return new ApiResponse("Event updated successfully");
    }

    @PutMapping("/update-capacity/{index}/{capacity}")
    public ApiResponse updateEventCapacity(@PathVariable int index ,@PathVariable int capacity) {

        if (index >= events.size() || index < 0)return new ApiResponse("Event not found");

        Event event = events.get(index);

        if(capacity <= 0 || capacity > event.getCapacity())return new ApiResponse("the Capacity entered is great then event capacity or capacity entered is zero or less");

        event.setCapacity(event.getCapacity()- capacity);

        return new ApiResponse("Event updated capacity successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index) {
        if (index >= events.size() || index < 0)return new ApiResponse("Event not found");
        events.remove(index);
        return new ApiResponse("Event deleted successfully");
    }




}
