package ua.kiev.foxgroups.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.foxgroups.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
