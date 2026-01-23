package com.Spring.Validation.Repository;

import com.Spring.Validation.Enitity.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<MyEntity,Integer> {

}
