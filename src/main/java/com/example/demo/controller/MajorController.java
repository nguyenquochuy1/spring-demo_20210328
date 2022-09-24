package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MajorController {
    private final EntityManagerFactory entityManagerFactory;

    @GetMapping("/major")
    @Transactional
    public String list() {
        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
        String hql = "from Major";
        Query<Major> query = session.createQuery(hql);
        List<Major> list = query.list();

//        list.forEach(major -> System.out.println(major.getName()));
        for(Iterator iterator = list.iterator(); iterator.hasNext();){
            Major major = (Major) iterator.next();

            System.out.println("========== Name: " + major.getName());
        }
        return "list";
    }
}
