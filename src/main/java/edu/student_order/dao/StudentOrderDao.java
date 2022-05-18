package edu.student_order.dao;

import edu.student_order.domain.StudentOrder;
import edu.student_order.exception.DaoException;

public interface StudentOrderDao {
    Long saveStudentOrder(StudentOrder studentOrder) throws DaoException;
}
