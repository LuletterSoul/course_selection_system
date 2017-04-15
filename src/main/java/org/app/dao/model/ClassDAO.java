package org.app.dao.model;


import org.app.entity.AdministrationClass;
import org.app.entity.Student;

import java.io.Serializable;
import java.util.List;


/**
 * Created by 31370 on 2017/4/8.
 */
public interface ClassDAO
{

//    Serializable establishAdministrationClass(AdministrationClass adminClass);
//
//    void logoutClassByClassId(String classId);
//
//    AdministrationClass getClassByClassId(String classId);

    List getAllStudentsInChargeById(String classId);

    int getClassStudentNumber(String classId);


}
