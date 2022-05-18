package edu.student_order.dao;

import edu.student_order.domain.PassportOffice;
import edu.student_order.domain.RegisterOffice;
import edu.student_order.domain.Street;
import edu.student_order.exception.DaoException;

import java.util.List;

public interface DictionaryDao {
    List<Street> findStreets(String pattern) throws DaoException;
    List<PassportOffice> findPassportOffice(String areaId) throws DaoException;
    List<RegisterOffice> findRegisterOffice(String areaId) throws DaoException;
}
