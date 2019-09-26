package com.rimi.Hospitals.dao.impl;


import com.rimi.Hospitals.entity.Doctortable;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author chenjin
 * @date 2019/9/25 17:30
 */

public class DoctortableDaoImplTest {


    @Test
    public void selectDoctortables() {
        DoctortableDaoImpl doctortableDao = new DoctortableDaoImpl();
        List<Doctortable> doctortables = doctortableDao.selectDoctortables();
        System.out.println(doctortables);
        System.out.println(doctortables.size()+"个");
    }
}
