package com.bloodbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.entity.Events;
import com.bloodbank.service.EventsService;

@RestController
public class EventsController {

	@Autowired
	private EventsService eventsService;
	
	@GetMapping("/events")
	public List<Events> getAllEvents() {
		return eventsService.getAllEvents();
	}
	
}
