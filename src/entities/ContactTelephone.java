package entities;

import util.Validation;

public class ContactTelephone extends Contact {
    private String telephone;

    public ContactTelephone(String nome, String telephone) {
        super(nome);
        this.telephone = telephone;
    }

    public String getTelephone() {
        return Validation.formatTelephone(this.telephone);
    }

    public void setTelephone(String telephone) {
        if (telephone != null && Validation.validatePhone(telephone)) {
            this.telephone = telephone;
        }
        System.out.println("Telefone inválido!");
    }

    public String getType() {
        return "Telefone";
    }

    @Override
    public String toString() {
        return String.format(" %d | %s | %s: %s", getID(), getName(), getType(), getTelephone());
    }

}
