package service;

import entities.Contact;
import entities.ContactEmail;
import entities.ContactTelephone;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
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
        return null;
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

    public void modifyContact(Contact contact, int opcao, String novoNome, String novoDado) {
        switch (opcao) {
            case 1:
                if (novoNome != null && !novoNome.trim().isEmpty()) {
                    contact.setName(novoNome);
                }
                break;
            case 2:
                if (contact instanceof ContactTelephone contactTelephone) {
                    contactTelephone.setTelephone(novoDado);
                } else if (contact instanceof ContactEmail contactEmail) {
                    contactEmail.setEmail(novoDado);
                }
                break;
            case 3:
                contact.setName(novoNome);

                if (contact instanceof ContactTelephone contactTelephone) {
                    contactTelephone.setTelephone(novoDado);
                } else if (contact instanceof ContactEmail contactEmail) {
                    contactEmail.setEmail(novoDado);
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

