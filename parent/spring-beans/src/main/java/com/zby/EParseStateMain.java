package com.zby;

import org.springframework.beans.factory.parsing.BeanEntry;
import org.springframework.beans.factory.parsing.ParseState;

public class EParseStateMain {

	public static void main(String[] args) {
		ParseState parseState = new ParseState();
		parseState.push(new BeanEntry("beanA"));
		parseState.push(new BeanEntry("beanB"));
		parseState.push(new BeanEntry("beanC"));
		parseState.push(new BeanEntry("beanD"));
		System.out.println(parseState);
	}

}
