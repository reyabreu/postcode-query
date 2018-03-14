package org.reyabreu.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

	@Override
	public void run(String... args) throws Exception {
		logger.info("hello world!");
	}

}
