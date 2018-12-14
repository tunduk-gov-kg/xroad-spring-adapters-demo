package kg.gov.tunduk.demoproducer.domain.soap;

import kg.gov.tunduk.demoproducer.configuration.LocalDateXmlAdapter;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonResponse", namespace = "http://tunduk.gov.kg")
@XmlRootElement(name = "personResponse", namespace = "http://tunduk.gov.kg")
public class PersonResponse {

    @XmlElement(name = "pin", namespace = "http://tunduk.gov.kg", required = true)
    private String pin;

    @XmlElement(name = "name", namespace = "http://tunduk.gov.kg", required = true)
    private String name;

    @XmlElement(name = "gender", namespace = "http://tunduk.gov.kg", required = true)
    private Gender gender;

    @XmlJavaTypeAdapter(value = LocalDateXmlAdapter.class)
    @XmlElement(name = "birthDate", namespace = "http://tunduk.gov.kg", required = true)
    private LocalDate birthDate;
}
