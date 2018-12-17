package kg.gov.tunduk.demoproducer.domain.soap;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPersonByPinRequest", namespace = "http://tunduk.gov.kg")
@XmlRootElement(name = "getPersonByPinRequest", namespace = "http://tunduk.gov.kg")
public class GetPersonByPinRequest {

    @XmlElement(name = "pin", namespace = "http://tunduk.gov.kg", required = true)
    private String pin;
}
