package com.thryts.school.controller;

import com.thryts.school.dto.ContactDto;
import com.thryts.school.dto.util.ContactDtoUtil;
import com.thryts.school.entity.Contact;
import com.thryts.school.services.ContactService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/add")
    @ApiOperation(value = "contactId", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successfully retrieved list"),
            @ApiResponse(code = 401,
                    message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403,
                    message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404,
                    message = "The resource you were trying to reach is not found")
    })
    public void add(@RequestBody ContactDto contactDto) {
        contactService.create(ContactDtoUtil.createContactFromDto(contactDto));
    }

    @PostMapping("/load_contact")
    public void load(@RequestBody String fileName) {
        contactService.loadContacts(fileName);
    }

    @GetMapping("/all")
    @ApiOperation(value = "all", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successfully retrieved list"),
            @ApiResponse(code = 401,
                    message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403,
                    message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404,
                    message = "The resource you were trying to reach is not found")
    })
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{contactId}")
    @ApiOperation(value = "contactId", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successfully retrieved list"),
            @ApiResponse(code = 401,
                    message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403,
                    message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404,
                    message = "The resource you were trying to reach is not found")
    })
    public Contact getById(@PathVariable("contactId") Long contactId) throws Exception {
        return contactService.getContactById(contactId).orElseThrow(
                () -> new Exception("Contact with ID " + contactId + " not found."));
    }

    @DeleteMapping("/{contactId}")
    @ApiOperation(value = "contactId", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successfully retrieved list"),
            @ApiResponse(code = 401,
                    message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403,
                    message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404,
                    message = "The resource you were trying to reach is not found")
    })
    public void delete(@PathVariable("contactId") Long contactId) throws Exception {
        contactService.delete(getById(contactId));
    }

    @PutMapping("/{contactId}")
    @ApiOperation(value = "contactId", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Successfully retrieved list"),
            @ApiResponse(code = 401,
                    message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403,
                    message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404,
                    message = "The resource you were trying to reach is not found")
    })
    public Contact update(@PathVariable("contactId") Long contactId, @RequestBody ContactDto contactDto) throws Exception {
        return contactService.update(contactId, contactDto).orElseThrow(
                () -> new Exception("Contact with ID " + contactId + " not found."));
    }

    @PostMapping("/testData")
    public void addTestData() {
        Contact contact = new Contact();
        contact.setFirstName("fd");
        contact.setLastName("lasdkd");
        contact.setSurName("suljklj");
        contact.setAge(2);
        contact.setPassword("dfdd");
        contact.setEmail("kjkl sdmail");
        contact.setBirthDayDate(LocalDate.parse("2012-05-05"));
        contact.setIsActive(true);
        contactService.create(contact);
//        contactService.create(new Contact("first", "last", "sur", 5, "kjkl@lk.lj"));
//        contactService.create(new Contact("first1", "last1", "sur1", 1, "kjkl@lk.lj"));
//        contactService.create(new Contact("first2", "last2", "sur2", 5, "k2jkl@lk.lj"));
//        contactService.create(new Contact("first3", "last3", "sur3", 33, "k3l@lk.lj"));
//        contactService.create(new Contact("first4", "last4", "sur4", 4, "k4@lk.lj"));
    }
}
