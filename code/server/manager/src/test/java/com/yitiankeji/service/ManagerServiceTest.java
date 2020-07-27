package com.yitiankeji.service;

import com.unitils.boot.util.UnitilsBootBlockJUnit4ClassRunner;
import org.dbunit.Assertion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.Arrays;

@RunWith(UnitilsBootBlockJUnit4ClassRunner.class)
@SpringBootTest
@Transactional(value = TransactionMode.ROLLBACK)
public class ManagerServiceTest {

    @SpringBeanByType
    private ManagerService managerService;

    @Test
    @DataSet("ManagerServiceTest.saveRoles.xml")
    @ExpectedDataSet("ManagerServiceTest.saveRoles-result.xml")
    public void saveRoles() {
        managerService.saveRoles(100001, Arrays.asList(1, 2));
    }
}
