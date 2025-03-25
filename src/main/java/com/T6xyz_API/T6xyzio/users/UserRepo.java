package com.T6xyz_API.T6xyzio.users;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, UUID> {
    public User findByUsername(String username);
}
