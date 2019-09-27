package com.rimi.Hospitals.dao.impl;


import com.rimi.Hospitals.entity.Doctortable;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author chenjin
 * @date 2019/9/25 17:30
 */

public class DoctortableDaoImplTest {


    @Test
    public void selectDoctortables() {
        DoctortableDaoImpl doctortableDao = new DoctortableDaoImpl();
        Map<String, String[]> stringMap = new HashMap<>();
        String[] strings = new String[2];
        strings[0]="35";
        stringMap.put("employeescard",strings);
        stringMap.put("doctorname",strings);
        stringMap.put("gender",strings);
        stringMap.put("age",strings);
        stringMap.put("subordinatedepartments",strings);
        stringMap.put("educationbackground",strings);
        doctortableDao.updateHospitals(stringMap);
    }
}
