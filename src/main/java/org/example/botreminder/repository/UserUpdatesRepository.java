package org.example.botreminder.repository;

import org.example.botreminder.model.UserResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserUpdatesRepository extends JpaRepository<UserResponseEntity, Long> {

}
