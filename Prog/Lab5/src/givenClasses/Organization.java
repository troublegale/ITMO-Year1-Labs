package givenClasses;

import givenClasses.enums.OrganizationType;

public class Organization {

    private String fullName; //Длина строки не должна быть больше 1576, Значение этого поля должно быть уникальным, Поле не может быть null
    private Double annualTurnover; //Поле не может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле не может быть null

}
