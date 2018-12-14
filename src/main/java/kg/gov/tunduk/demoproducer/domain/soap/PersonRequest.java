package kg.gov.tunduk.demoproducer.domain.soap;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonRequest", namespace = "http://tunduk.gov.kg")
@XmlRootElement(name = "personRequest", namespace = "http://tunduk.gov.kg")
public class PersonRequest {

    @XmlElement(name = "pin", namespace = "http://tunduk.gov.kg", required = true)
    private String pin;
}
