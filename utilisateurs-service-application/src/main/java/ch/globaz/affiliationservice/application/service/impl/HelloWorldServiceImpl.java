package ch.globaz.affiliationservice.application.service.impl;

import ch.globaz.affiliationservice.application.service.HelloWorldService;
import ch.globaz.affiliationservice.domain.model.HelloWorld;
import ch.globaz.affiliationservice.domain.repository.HelloWorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelloWorldServiceImpl implements HelloWorldService {

	@Autowired
	HelloWorldRepository repository;

	@Override
	public HelloWorld sauve(HelloWorld helloWorld) {

		return repository.store(helloWorld);
	}

	@Override
	public List<HelloWorld> getAll() {
		return repository.getAll();
	}
}
