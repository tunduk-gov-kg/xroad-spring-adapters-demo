package kg.gov.tunduk.demoproducer.domain.soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlEnum
@XmlType(name = "Gender", namespace = "http://tunduk.gov.kg")
@XmlRootElement(name = "gender", namespace = "http://tunduk.gov.kg")
public enum Gender {
    MALE, FEMALE;

    public String value() {
        return name();
    }

    public static Gender fromValue(String value) {
        return valueOf(value);
    }
}
