package kg.gov.tunduk.demoproducer.endpoint;

import kg.gov.tunduk.demoproducer.domain.entity.Person;
import kg.gov.tunduk.demoproducer.domain.soap.GetPersonByPinRequest;
import kg.gov.tunduk.demoproducer.domain.soap.GetPersonByPinResponse;
import kg.gov.tunduk.demoproducer.repository.PersonRepository;
import kg.gov.tunduk.xroad.XRoadEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBException;
import java.util.Optional;

@Endpoint
public class PersonEndpoint extends XRoadEndpoint {

    private final PersonRepository personRepository;

    @Autowired
    public PersonEndpoint(PersonRepository personRepository) throws JAXBException {
        this.personRepository = personRepository;
    }

    @ResponsePayload
    @PayloadRoot(localPart = "getPersonByPinRequest", namespace = "http://tunduk.gov.kg")
    public GetPersonByPinResponse getPersonByPin(@RequestPayload GetPersonByPinRequest request) {
        Optional<Person> personOptional = personRepository.findByPin(request.getPin());
        if (personOptional.isPresent()) {
            return createResponse(personOptional.get());
        } else {
            throw new IllegalArgumentException("No person found");
        }
    }


    private GetPersonByPinResponse createResponse(Person person) {
        GetPersonByPinResponse response = new GetPersonByPinResponse();
        response.setPin(person.getPin());
        response.setName(person.getName());
        response.setBirthDate(person.getBirthDate());
        response.setGender(person.getGender());
        return response;
    }
}
