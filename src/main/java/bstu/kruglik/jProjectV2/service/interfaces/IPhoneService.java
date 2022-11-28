package bstu.kruglik.jProjectV2.service.interfaces;

import bstu.kruglik.jProjectV2.models.Phone;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface IPhoneService {
    @Transactional
    void deleteById(Long id) throws ServiceException;

    Phone create(Phone computerStuff)throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;
    boolean existsByName(String name) throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;

    List<Phone> getAll()throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;
    @Transactional
    void deleteByName(String name)throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;

    Phone getById(Long id)throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;

    Phone getByName(String name)throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;

    @Transactional
    void updatePhoneById(
            Long id,
            String name,
            String description,
            int cost)throws ServiceException, bstu.kruglik.jProjectV2.exception.ServiceException;
}
