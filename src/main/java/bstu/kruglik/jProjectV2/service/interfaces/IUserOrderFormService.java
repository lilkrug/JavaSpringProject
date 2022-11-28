package bstu.kruglik.jProjectV2.service.interfaces;

import bstu.kruglik.jProjectV2.models.OrderForm;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface IUserOrderFormService {
    @Transactional
    void deleteById(Long id)throws ServiceException;
    @Transactional
    void deleteByUserIdAndScooterId(Long user_id, Long computerStuff_id) throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;

    OrderForm create(OrderForm userOrderForm)throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;
    boolean existsByScooterId(Long computerStuff_id) throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;
    OrderForm getById(Long id)throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;

    List<OrderForm> getAllByUserId(Long user_id)throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;
    List<OrderForm> getAllByRent(boolean rent)throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;

    List<OrderForm> getAllPhones(Date computerStuff_expirationDate)throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;
    @Transactional
    void setUserRentFormById(Long id, boolean rent)throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;
}
