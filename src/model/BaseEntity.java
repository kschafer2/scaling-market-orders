package model;

public abstract class BaseEntity {

    Long id = (long)hashCode();

    public Long getId() {
        return id;
    }
}
