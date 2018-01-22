package ch.globaz.affiliationservice.application.service;

import ch.globaz.affiliationservice.domain.model.HelloWorld;

import java.util.List;

public interface HelloWorldService {

	HelloWorld sauve(HelloWorld helloWorld);

	List<HelloWorld> getAll();
}
