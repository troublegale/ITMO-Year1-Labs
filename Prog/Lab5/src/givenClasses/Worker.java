package givenClasses;

import givenClasses.enums.*;

import java.time.ZonedDateTime;
import java.util.Date;

public class Worker {

    public int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long salary; //Поле может быть null, Значение поля должно быть больше 0
    private ZonedDateTime startDate; //Поле не может быть null
    private Position position; //Поле может быть null
    private Status status; //Поле не может быть null
    private Organization organization; //Поле может быть null

    {
        id++;
    }

}
