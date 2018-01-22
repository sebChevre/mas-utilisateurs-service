package ch.globaz.affiliationservice.infrastructure.repository;

import ch.globaz.affiliationservice.domain.model.HelloWorld;
import ch.globaz.affiliationservice.domain.repository.HelloWorldRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class HelloWorldHibernateRepository extends HibernateRepository implements HelloWorldRepository {

	@Transactional
	@Override
	public HelloWorld store(HelloWorld hw) {
		getSession().saveOrUpdate(hw);
		return hw;
	}

	@Transactional
	@Override
	public List<HelloWorld> getAll() {
		return getSession().createQuery("FROM " + HelloWorld.class.getSimpleName()).list();
	}


}
