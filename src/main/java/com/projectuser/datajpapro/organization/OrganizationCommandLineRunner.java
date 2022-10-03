//package com.projectuser.datajpapro.organization;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OrganizationCommandLineRunner implements CommandLineRunner {
//
//    private OrganizationRepository org;
//
//    public OrganizationCommandLineRunner(OrganizationRepository org) {
//        this.org = org;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        org.save(new Organization(4, "Guidewire"));
//        org.save(new Organization(5, "Cyber"));
//
//
//    }
//}
