package ch.globaz.affiliationservice.domain.repository;

import ch.globaz.affiliationservice.domain.model.HelloWorld;

import java.util.List;

public interface HelloWorldRepository {

	HelloWorld store (HelloWorld hw);


	List<HelloWorld> getAll();
}
