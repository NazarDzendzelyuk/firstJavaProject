package ua.com.Bershka.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.Bershka.Classes.People;

public interface PeopleDao extends JpaRepository<People, Integer> {

}
