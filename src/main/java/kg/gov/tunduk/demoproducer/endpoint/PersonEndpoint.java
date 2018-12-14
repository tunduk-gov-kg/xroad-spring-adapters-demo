package kg.gov.tunduk.demoproducer.endpoint;

import kg.gov.tunduk.demoproducer.domain.soap.Gender;
import kg.gov.tunduk.demoproducer.domain.soap.PersonRequest;
import kg.gov.tunduk.demoproducer.domain.soap.PersonResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Endpoint
public class PersonEndpoint {

    private static List<PersonResponse> people = new ArrayList<>();

    static {
        PersonResponse samplePerson = new PersonResponse();
        samplePerson.setPin("1");
        samplePerson.setName("John Doe");
        samplePerson.setBirthDate(LocalDate.of(1970, Month.APRIL, 1));
        samplePerson.setGender(Gender.MALE);
        people.add(samplePerson);
    }

    @ResponsePayload
    @PayloadRoot(localPart = "personRequest", namespace = "http://tunduk.gov.kg")
    public PersonResponse getPerson(@RequestPayload PersonRequest request) {
        Optional<PersonResponse> personResponse = people.stream().filter(person -> person.getPin().equals(request.getPin())).findFirst();
        if (personResponse.isPresent()) {
            return personResponse.get();
        } else {
            throw new IllegalArgumentException("No person found");
        }
    }
}
