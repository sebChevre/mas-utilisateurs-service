package ch.globaz.utilisateursservice.application.api.web;

import ch.globaz.utilisateursservice.application.api.dto.UtilisateurDTO;
import ch.globaz.utilisateursservice.application.api.exception.RessourceNotFoundException;
import ch.globaz.utilisateursservice.domain.service.UtilisateursService;
import ch.globaz.utilisateursservice.domain.model.Utilisateur;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/users")
@Api(value = "/users",
		description = "API pour les opérations sur les comptes utilisateurs",
		consumes="application/json")
public class UtilisateursController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateursController.class);

	@Autowired
	UtilisateursService utilisateursService;



	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtenir un utilisateur",
			response = UtilisateurDTO.class)
	public ResponseEntity<UtilisateurDTO> getUtilisateur(@PathVariable("id") Long id, HttpServletRequest request) throws RessourceNotFoundException {

		LOGGER.info("getUtilisateurs() by id: {}",id);

		Utilisateur newUtilisateur = utilisateursService.getByIdentifiant(id)
				.orElseThrow(() -> new RessourceNotFoundException("fail",id,request.getRequestURI()));

		UtilisateurDTO utilisateursRessources = UtilisateurDTO.fromEntity(newUtilisateur);

		utilisateursRessources.add(linkTo(methodOn(UtilisateursController.class).getUtilisateur(id,request)).withSelfRel());

		return new ResponseEntity<>(utilisateursRessources, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Créer un utilisateur",
			notes = "Multiple status values can be provided with comma seperated strings",
			response = UtilisateurDTO.class)
	public ResponseEntity<UtilisateurDTO> persistUtilisateur(@RequestBody UtilisateurDTO dto, HttpServletRequest request){

		LOGGER.info("persistUtilisateurs() : {}",dto);

		Utilisateur newUtilisateur = utilisateursService.creerNouvelUtilisateur(Utilisateur.from(dto.getNomUtilisateur(),dto.getMotDePasse(),dto.getPersonneId()));

		UtilisateurDTO utilisateursRessources = UtilisateurDTO.fromEntity(newUtilisateur);

		utilisateursRessources.add(linkTo(methodOn(UtilisateursController.class).getUtilisateur(newUtilisateur.id(),request)).withSelfRel());


		return new ResponseEntity<>(utilisateursRessources, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UtilisateurDTO>> getUtilisateurs(){

		List<Utilisateur> hws = utilisateursService.listeUtilisateurs();

		return new ResponseEntity<>(getAllAsDto(hws), HttpStatus.OK);
	}

	private List<UtilisateurDTO> getAllAsDto (List<Utilisateur> utilisateurs) {
		return utilisateurs.stream().map(UtilisateurDTO::fromEntity).collect(Collectors.toList());
	}


}
