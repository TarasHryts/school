package com.thryts.school.controller;

import com.thryts.school.dto.ContactDto;
import com.thryts.school.dto.RoleDto;
import com.thryts.school.dto.util.ContactDtoUtil;
import com.thryts.school.dto.util.RoleDtoUtil;
import com.thryts.school.entity.Contact;
import com.thryts.school.entity.Role;
import com.thryts.school.services.ContactService;
import com.thryts.school.services.DayService;
import com.thryts.school.services.GenderService;
import com.thryts.school.services.GradeService;
import com.thryts.school.services.RoleService;
import com.thryts.school.services.ScheduleService;
import com.thryts.school.services.StudentService;
import com.thryts.school.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Random;
import java.util.Set;

@RestController
@RequestMapping("/init_test_data")
public class DataInitializerController {
    private static final String WAY_TO_FOLDER = "D:\\school_data\\";
    private static final String CONTACT = "people.csv";
    private static final String DAY = "day.csv";
    private static final String GENDER = "gender.csv";
    private static final String GRADE = "grades.csv";
    private static final String ROLE = "roles.csv";
    private static final String SCHEDULE = "schedule.csv";
    private static final String STUDENT = "st.csv";//"students.csv";
    private static final String SUBJECT = "subjects.csv";
    private final ContactService contactService;
    private final DayService dayService;
    private final GenderService genderService;
    private final GradeService gradeService;
    private final RoleService roleService;
    private final ScheduleService scheduleService;
    private final StudentService studentService;
    private final SubjectService subjectService;

    @Autowired
    public DataInitializerController(ContactService contactService,
                                     DayService dayService,
                                     GenderService genderService,
                                     GradeService gradeService,
                                     RoleService roleService,
                                     ScheduleService scheduleService,
                                     StudentService studentService,
                                     SubjectService subjectService) {
        this.contactService = contactService;
        this.dayService = dayService;
        this.genderService = genderService;
        this.gradeService = gradeService;
        this.roleService = roleService;
        this.scheduleService = scheduleService;
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    @PostMapping("/load_data")
    public void load() {
        if (dayService.getAllDays().size() == 0) {
            dayService.loadDays(WAY_TO_FOLDER + DAY);
        }
        if (genderService.getAllGenders().size() == 0) {
            genderService.loadGenders(WAY_TO_FOLDER + GENDER);
        }
        if (gradeService.getAllGrades().size() == 0) {
            gradeService.loadGrades(WAY_TO_FOLDER + GRADE);
        }
        if (roleService.getAllRoles().size() == 0) {
            roleService.loadRoles(WAY_TO_FOLDER + ROLE);
        }
        if (subjectService.getAllSubjects().size() == 0) {
            subjectService.loadSubjects(WAY_TO_FOLDER + SUBJECT);
        }
        if (studentService.getAllStudents().size() == 0) {
            studentService.loadStudents(WAY_TO_FOLDER + STUDENT);
        }
        if (contactService.getAllContacts().size() == 0) {
            contactService.loadContacts(WAY_TO_FOLDER + CONTACT);
        }
        if (scheduleService.getAllSchedule().size() == 0) {
            scheduleService.loadSchedule(WAY_TO_FOLDER + SCHEDULE);
        }
    }
}
