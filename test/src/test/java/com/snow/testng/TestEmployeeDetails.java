package com.snow.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 14-6-23.
 */
public class TestEmployeeDetails {
    EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
    EmployeeDetails employee = new EmployeeDetails();

    @Test
    public void testCalculateAppriasal() {
        System.out.println("------------>testCalculateAppriasal");
        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);
        double appraisal = empBusinessLogic
                .calculateAppraisal(employee);
        Assert.assertEquals(500, appraisal, 0.0, "500");
    }

    // test to check yearly salary
    @Test
    public void testCalculateYearlySalary() {
        System.out.println("------------>testCalculateYearlySalary");
        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);
        double salary = empBusinessLogic
                .calculateYearlySalary(employee);
        Assert.assertEquals(96000, salary, 0.0, "8000");
    }
}
