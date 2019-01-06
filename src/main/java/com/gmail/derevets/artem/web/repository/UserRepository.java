package com.gmail.derevets.artem.web.repository;


import com.gmail.derevets.artem.web.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/*@Repository*/
public interface UserRepository extends MongoRepository<User,String> {


    User findByEmail(String email);


}
