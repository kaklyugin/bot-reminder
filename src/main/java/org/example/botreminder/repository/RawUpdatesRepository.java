package org.example.botreminder.repository;

import org.example.botreminder.model.RawUpdateEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RawUpdatesRepository extends JpaRepository<RawUpdateEntity, Long> {

}
