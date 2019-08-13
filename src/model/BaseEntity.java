package model;

public abstract class BaseEntity {

    Long id;

    {
        id = (long)hashCode();
    }

    public Long getId() {
        return id;
    }
}
