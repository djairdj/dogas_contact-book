package entities;

import util.Validation;

public class ContactEmail extends Contact {
    private String email;

    public ContactEmail(String nome, String email) {
        super(nome);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && Validation.isValidEmail(email)) {
            this.email = email;
        } else {
            System.out.println("Email inválido!");
        }
    }

    public String getType() {
        return "Email";
    }

    @Override
    public String toString() {
        return String.format(" %d | %s | %s: %s", getID(), getName(), getType(), getEmail());
    }
}
