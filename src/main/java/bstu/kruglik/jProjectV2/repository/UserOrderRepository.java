package bstu.kruglik.jProjectV2.repository;

import bstu.kruglik.jProjectV2.exception.RepositoryException;
import bstu.kruglik.jProjectV2.models.OrderForm;
import bstu.kruglik.jProjectV2.exception.ServiceException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface UserOrderRepository extends JpaRepository<OrderForm, Long> {
    @Modifying
    void deleteById(Long id);
    @Modifying
    void deleteByUserIdAndPhoneId(Long user_id, Long computerStuff_id)throws RepositoryException;
    @Modifying
    @Transactional
    void deleteByUserName(String userName)throws RepositoryException;

    OrderForm getById(Long id);
    List<OrderForm> getAllByUserId(Long user_id)throws RepositoryException;
    boolean existsByPhoneId(Long computerStuff_id)throws RepositoryException;
    boolean existsByUserId(Long user_id)throws RepositoryException;
    List<OrderForm> getAllByRent(boolean rent)throws RepositoryException;
    List<OrderForm> getAllByPhoneOrderDateLessThan(Date computerStuff_expirationDate)throws RepositoryException;
    @Modifying
    @Query("update OrderForm urf set urf.rent =:rent  where urf.id =:id ")
    void setUserRentFormById(@Param("id") Long id, @Param("rent") boolean rent)throws RepositoryException, ServiceException;

}
