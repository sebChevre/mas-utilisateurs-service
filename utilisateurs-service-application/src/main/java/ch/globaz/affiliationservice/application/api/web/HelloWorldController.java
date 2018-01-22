package ch.globaz.affiliationservice.application.api.web;

import ch.globaz.affiliationservice.application.api.dto.HelloWorldDto;
import ch.globaz.affiliationservice.application.service.HelloWorldService;
import ch.globaz.affiliationservice.domain.model.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hellos")
public class HelloWorldController {

	@Autowired
	HelloWorldService helloWorldService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HelloWorldDto> persistHello(@RequestBody HelloWorldDto dto){

		HelloWorld hw = helloWorldService.sauve(HelloWorld.builder(dto.getHello(),dto.getWorld()));

		return new ResponseEntity<>(HelloWorldDto.fromEntity(hw), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<HelloWorldDto>> getHello(){

		List<HelloWorld> hws = helloWorldService.getAll();

		return new ResponseEntity<>(getAllAsDto(hws), HttpStatus.OK);
	}

	private List<HelloWorldDto> getAllAsDto (List<HelloWorld> helloList) {
		return helloList.stream().map(HelloWorldDto::fromEntity).collect(Collectors.toList());
	}


}
