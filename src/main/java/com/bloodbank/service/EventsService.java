package com.bloodbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bloodbank.entity.Events;
import com.bloodbank.repository.EventsRepository;

@Service
public class EventsService {

	@Autowired
	private EventsRepository eventsRepository;
	
	public List<Events> getAllEvents() {
		return eventsRepository.findAll(Sort.by("name"));
	}
	
}
