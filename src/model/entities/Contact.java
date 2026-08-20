package model.entities;

import model.exceptions.InvalidDataException;

import java.util.UUID;

abstract public class Contact {
    private String name;
    private final UUID id;

    public Contact(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public UUID getID() {
        return id;
    }

    public void setName(String newName) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = newName;
        }
    }

    public abstract void updateData(String newData) throws InvalidDataException;
}
