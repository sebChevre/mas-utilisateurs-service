package ch.globaz.utilisateursservice.infrastructure.repository.utilisateurs;

import ch.globaz.utilisateursservice.domain.model.Utilisateur;
import ch.globaz.utilisateursservice.domain.repository.UtilisateursRepository;
import ch.globaz.utilisateursservice.infrastructure.repository.HibernateRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UtilisateursHibernateRepository extends HibernateRepository implements UtilisateursRepository{

    @Transactional
    @Override
    public Utilisateur sauve(Utilisateur utilisateur) {
        getSession().save(utilisateur);
        return utilisateur;
    }

    @Transactional
    @Override
    public Optional<Utilisateur> getById(Long id) {

        Utilisateur r= getSession().get(Utilisateur.class,id);

        Optional<Utilisateur> o = Optional.ofNullable(r);

        return o;
    }

    @Transactional
    @Override
    public List<Utilisateur> getAll() {
        return getSession().createQuery("FROM " + Utilisateur.class.getSimpleName()).list();
    }
}
