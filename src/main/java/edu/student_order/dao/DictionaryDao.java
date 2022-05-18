package edu.student_order.dao;

import edu.student_order.domain.Street;
import edu.student_order.exception.DaoException;

import java.util.List;

public interface DictionaryDao {
    List<Street> findStreets(String pattern) throws DaoException;
}
