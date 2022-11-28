package bstu.kruglik.jProjectV2.repository;

import bstu.kruglik.jProjectV2.exception.RepositoryException;
import bstu.kruglik.jProjectV2.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    @Modifying
    void deleteById(int id)throws RepositoryException;

    @Modifying
    void deleteByName(String name)throws RepositoryException;

    Phone getById(Long id);

    Phone getByName(String name)throws RepositoryException;

    boolean existsByName(String name)throws RepositoryException;

    @Modifying
    @Query("update Phone c set c.name=:name, c.description=:description, c.cost=:cost where c.id=:id")
    void updatePhoneById(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("description") String description,
            @Param("cost") int cost
    )throws RepositoryException;
}
