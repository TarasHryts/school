package com.thryts.school.controller;

import com.thryts.school.dto.ContactDto;
import com.thryts.school.dto.RoleDto;
import com.thryts.school.dto.util.ContactDtoUtil;
import com.thryts.school.dto.util.RoleDtoUtil;
import com.thryts.school.entity.Contact;
import com.thryts.school.entity.Role;
import com.thryts.school.services.ContactService;
import com.thryts.school.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Random;
import java.util.Set;

@Component
public class DataInitializer {
    private ContactService contactService;
    private RoleService roleService;

    @Autowired
    public DataInitializer(ContactService contactService, RoleService roleService) {
        this.contactService = contactService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initializeData() {
        saveData();
    }

    private void saveData() {
        Role student = RoleDtoUtil.createRoleFromDto(new RoleDto(new Random(100) + "STUDENT"));
        Role admin = RoleDtoUtil.createRoleFromDto(new RoleDto(new Random(100) + "ADMIN"));
        Role user = RoleDtoUtil.createRoleFromDto(new RoleDto(new Random(100) + "USER"));
        Contact contact = ContactDtoUtil.createContactFromDto(
                new ContactDto("Firs" + new Random(100), "Last" + new Random(100), "Sur" + new Random(100), 12, LocalDate.parse("2003-11-11"), "k@l.k", true));
        Set roleSet = contact.getRoles();
        roleSet.add(admin);
        roleSet.add(student);
        roleSet.add(user);
        contact.setRoles(roleSet);
        contactService.create(contact);
        roleService.create(student);
        roleService.create(admin);
        roleService.create(user);
//
//        roleSet.add(student);
//        roleSet.add(admin);
//        Contact firstContact = ContactDtoUtil.createContactFromDto()

    }
}
/*
    private void saveData() {
        User userPetro = UserDtoUtil.createUserFromDto(new UserDto("Petro", "kjk@kj.jdd", "1", "1"));
        userService.create(userPetro);

        Account account = AccountDtoUtil.createAccountFromDto(new AccountDto(10000L, "1111"));
        Set<Account> userPetroAccountList = userPetro.getAccountList();
        userPetroAccountList.add(account);
        userPetro.setAccountList(userPetroAccountList);
        accountService.create(account);

        User userIvan = UserDtoUtil
                .createUserFromDto(new UserDto("Ivan", "iven@kj.jdd", "1", "1"));
        userService.create(userIvan);
        Banknotes banknotesOneHundred = BanknotesDtoUtil
                .createBanknotesFromDto(new BanknotesDto(100L, 50L));
        banknotesService.create(banknotesOneHundred);
        Banknotes banknotesTwoHundred = BanknotesDtoUtil
                .createBanknotesFromDto(new BanknotesDto(200L, 50L));
        banknotesService.create(banknotesTwoHundred);
        Banknotes banknotesFiveHundred = BanknotesDtoUtil
                .createBanknotesFromDto(new BanknotesDto(500L, 50L));
        banknotesService.create(banknotesFiveHundred);
        List<Banknotes> banknotesList = new ArrayList<>();
        banknotesList.add(banknotesOneHundred);
        banknotesList.add(banknotesTwoHundred);
        banknotesList.add(banknotesFiveHundred);
        Atm atm = AtmDtoUtil.createAtmFromDto(new AtmDto(banknotesList));
        atmService.create(atm);
    }
}

 */