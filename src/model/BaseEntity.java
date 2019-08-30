package model;

public abstract class BaseEntity {

    private Long id;

    {
        id = (long)hashCode();
    }

    public Long getId() {
        return id;
    }
}
