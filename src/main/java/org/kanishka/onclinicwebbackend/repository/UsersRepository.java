package org.kanishka.onclinicwebbackend.repository;

import org.bson.types.ObjectId;
import org.kanishka.onclinicwebbackend.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<Users, ObjectId> {
    Users findBy_id(ObjectId _id);
    Optional<Users> findByEmail(String email);
}
