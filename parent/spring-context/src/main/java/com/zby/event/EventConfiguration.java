package com.zby.event;

import java.util.Date;

import org.springframework.context.event.EventListener;

public class EventConfiguration {
	@EventListener
	public void process(Date date) {
		System.out.println("date-->" + date);
	}
}
