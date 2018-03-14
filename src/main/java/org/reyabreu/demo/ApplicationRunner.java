package org.reyabreu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

	@Override
	public void run(String... args) throws Exception {

		if (args.length > 1) {
			logger.error("too many arguments supplied. Please use a valid postcode");
		}
	}

}
