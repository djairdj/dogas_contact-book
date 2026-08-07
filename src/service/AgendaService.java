package service;

import entities.Contact;
import entities.ContactEmail;
import entities.ContactTelephone;
import util.Validation;

import java.util.ArrayList;
import java.util.List;

public class AgendaService {
    private final List<Contact> contactList = new ArrayList<>();

    public List<Contact> getContactList() {
        return contactList;
    }

    public void reportContacts() {
        int totalTelephone = 0;
        int totalEmail = 0;

        for (Contact contact : contactList) {
            if (contact instanceof ContactTelephone) {
                totalTelephone++;
            }
            if (contact instanceof ContactEmail) {
                totalEmail++;
            }
        }
        System.out.println("=== RELATÓRIO DE CONTATOS ===");
        System.out.println("Total de Contatos: " + contactList.size());
        System.out.println("Total de contatos com telefone: " + totalTelephone);
        System.out.println("Total de contatos com email: " + totalEmail);
    }

    public void registerContact(Contact contact) {
        contactList.add(contact);
    }

    public void listContacts() {
        if (!contactList.isEmpty()) {
            for (Contact contact : contactList) {
                System.out.println(contact);
            }
        } else {
            System.out.println("Nenhum contato cadastrado!");
        }
    }

    public List<Contact> findContactsByName(List<Contact> contactList, String nome) {
        if (!contactList.isEmpty()) {
            List<Contact> contactsFound = new ArrayList<>();
            for (Contact contact : contactList) {
                if (contact.getName() != null && contact.getName().equalsIgnoreCase(nome)) {
                    contactsFound.add(contact);
                }
            }
            return contactsFound;
        }
        return List.of();
    }


    public Contact findContactFoundById(List<Contact> contatosEncontrados, int id) {
        if (!contatosEncontrados.isEmpty()) {
            for (Contact contact : contatosEncontrados) {
                if (contact.getID() == id) {
                    return contact;
                }
            }
        }
        return null;
    }

    public void updateEmail(ContactEmail contactEmail, int opcao, String novoNome, String newEmail){
        contactEmail.setEmail(newEmail);
    }

    public void updatePhone(ContactTelephone contactPhone, int opcao, String novoNome, String newPhone){
        contactPhone.setTelephone(newPhone);
    }

    public void updateName(String name){

    }
    public void updateContact(Contact contact, int opcao, String newName, String newData) {
        switch (opcao) {
            case 1:
                if(Validation.validateName(newName)){
                    contact.setName(newName);
                }
            case 2:
                if(contact instanceof ContactTelephone contactTelephone){
                    updatePhone(contactTelephone, opcao, newName, newData);
                }

                if (contact instanceof ContactTelephone contactTelephone) {
                    contactTelephone.setTelephone(newData);
                } else if (contact instanceof ContactEmail contactEmail) {
                    contactEmail.setEmail(newData);
                }
                break;
            case 3:
                contact.setName(newData);

                if (contact instanceof ContactTelephone contactTelephone) {
                    contactTelephone.setTelephone(newData);
                } else if (contact instanceof ContactEmail contactEmail) {
                    contactEmail.setEmail(newData);
                }
                break;
            default:
                System.out.println("Opção inválida, tente novamente!");
        }
    }

    public boolean deleteContact(int id) {
        return contactList.removeIf(contato -> contato.getID() == id);
    }
}

