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

## Bidirectional One-to-One Mapping with `mappedBy`

This is an enhanced bidirectional mapping where the `mappedBy` attribute is used to indicate which side is the non-owning (inverse) side. The `mappedBy` attribute refers to the field in the owning side.

### Example

```java
@Entity
public class Person {
    @Id
    private int personId;
    private String personName;

    @OneToOne(mappedBy = "person")
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
- `App.java`: Contains the main method to run the application.

## How to Run

1. Configure your database settings in `hibernate.cfg.xml`.
2. Run the application to see the different types of One-to-One mappings in action.

## Conclusion

This project covers the basics of One-to-One mappings in Hibernate, including unidirectional and bidirectional mappings. The examples provided should help you understand how to implement these mappings in your own projects.

# Hibernate FetchType Strategies

This project demonstrates the use of FetchType strategies in Hibernate.

## FetchType in Hibernate

FetchType in Hibernate is an enum that defines the fetching strategy for associations between entities. It can be added to any kind of mapping. It determines how mapped/associated entities should be loaded from the database. By using FetchType, developers can control the loading behavior of associated entities and improve the efficiency of their applications. There are two types of fetching strategies:

1. `FetchType.EAGER`
2. `FetchType.LAZY`

## FetchType.EAGER

It is a fetching strategy that indicates that the associated entities should be fetched immediately along with their owner entity. Hibernate will retrieve the related entities in the same query. It is used when the associated entities are always needed along with the owner entity. `@OneToOne` and `@ManyToOne` are eager loaders by default.

### Example

```java
@Entity
public class Person {
    @Id
    private int personId;
    private String personName;

    @OneToOne(fetch = FetchType.EAGER)
    private Aadhar aadhar;

    // getters and setters
}
```

## FetchType.LAZY

It is a fetching strategy that indicates that the associated entities are not loaded from the database immediately when the owner entity is fetched. In other words, the associated entities' data will not be fetched unless it is requested. Using this, we can improve the performance of the application, especially when dealing with large datasets. `@OneToMany` and `@ManyToMany` are lazy loaders by default.

### Example

```java
@Entity
public class Person {
    @Id
    private int personId;
    private String personName;

    @OneToOne(fetch = FetchType.LAZY)
    private Aadhar aadhar;

    // getters and setters
}
```

## Project Structure

- `Person.java`: Represents the Person entity with FetchType strategies.
- `Aadhar.java`: Represents the Aadhar entity.

## How to Run

1. Configure your database settings in `hibernate.cfg.xml`.
2. Run the application to see the different FetchType strategies in action.

## Conclusion

This project covers the basics of FetchType strategies in Hibernate, including `FetchType.EAGER` and `FetchType.LAZY`. The examples provided should help you understand how to implement these strategies in your own projects.
