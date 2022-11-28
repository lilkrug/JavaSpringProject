package bstu.kruglik.jProjectV2.repository;


import bstu.kruglik.jProjectV2.models.Role;
import bstu.kruglik.jProjectV2.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByName(Role name);
}
