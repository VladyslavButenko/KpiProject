package ua.kiev.foxgroups;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.kiev.foxgroups.model.Contact;
import ua.kiev.foxgroups.model.Group;
import ua.kiev.foxgroups.service.ContactService;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(final ContactService contactService) {
        return strings -> {
            Group group = new Group("Test");
            Contact contact;

            contactService.addGroup(group);

            for (int i = 0; i < 13; i++) {
                contact = new Contact(null, "Name" + i, "Surname" + i, "1234567" + i, "user" + i + "@test.com");
                contactService.addContact(contact);
            }
            for (int i = 0; i < 10; i++) {
                contact = new Contact(group, "Other" + i, "OtherSurname" + i, "7654321" + i, "user" + i + "@other.com");
                contactService.addContact(contact);
            }
        };
    }
}