# Hibernate One-to-One Mapping

This project demonstrates different types of One-to-One mappings in Hibernate.

## Unidirectional One-to-One Mapping

In this approach, only one entity knows about the relationship. The owning entity has a reference to the related entity, and the relationship is defined in this entity only. Typically, a `@OneToOne` annotation is used to specify the relationship.

### Example

```java
@Entity
public class Person {
    @Id
    private int personId;
    private String personName;

    @OneToOne
    private Aadhar aadhar;

    // getters and setters
}
```

## Bidirectional One-to-One Mapping

Both entities are aware of the relationship. Each entity has a reference to the other, creating a bidirectional link. The foreign key is still maintained in one entity, known as the owning side.

### Example

```java
@Entity
public class Person {
    @Id
    private int personId;
    private String personName;

    @OneToOne
    private Aadhar aadhar;

    // getters and setters
}

@Entity
public class Aadhar {
    @Id
    private int aadharId;
    private long aadharNo;

    @OneToOne
    private Person person;

    // getters and setters
}
```

## Project Structure

- `Person.java`: Represents the Person entity.
- `Aadhar.java`: Represents the Aadhar entity.

## How to Run

1. Configure your database settings in `hibernate.cfg.xml`.
2. Run the application to see the different types of One-to-One mappings in action.

## Conclusion

This project covers the basics of One-to-One mappings in Hibernate, including unidirectional and bidirectional mappings. The examples provided should help you understand how to implement these mappings in your own projects.
