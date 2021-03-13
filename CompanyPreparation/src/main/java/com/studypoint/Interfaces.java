package com.studypoint;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Interfaces {
    public static void main(String[] args) {
        // given employeeList
        List<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee(1, null, "Jhon H"));
        employeeList.add(new Employee(2, null, "Samual S"));
        employeeList.add(new Employee(3, 1, "Jane Austin"));
        employeeList.add(new Employee(4, 1, "Dallas Worthin"));
        employeeList.add(new Employee(5, 2, "Elvis William"));
        employeeList.add(new Employee(6, 2, "Tabith tobias"));
        employeeList.add(new Employee(7, 3, "Brandy Wine"));
        employeeList.add(new Employee(8, 3, "Sheila Jackson"));
        employeeList.add(new Employee(9, 4, "Kyle Cunningh"));
        employeeList.add(new Employee(10, 4, "Derrick Solomon"));
        employeeList.add(new Employee(11, 5, "Daren Allexandra"));
        employeeList.add(new Employee(12, 5, "June Andrew"));
        employeeList.add(new Employee(13, 6, "Chrestian lewis"));
        employeeList.add(new Employee(14, 6, "Julie Brown"));


        Map<Integer, List<Employee>> levelWiseEmployee = new HashMap<>();
        int level = 0;
        while (!employeeList.isEmpty()) {
            List<Employee> tempList = new LinkedList<>();
            tempList.addAll(employeeList);
            Set<Integer> empIds = employeeList.stream().map(e->e.getEmpId()).collect(Collectors.toSet());
            List<Employee> employees=new ArrayList<>();
            for (Employee e : tempList) {
                if (!empIds.contains(e.getMid())) {
                    employees.add(e);
                    employeeList.remove(e);
                }
            }
            levelWiseEmployee.put(level, employees);
            level++;
        }

        // levelWiseEmployee this will give answer
        for (Map.Entry<Integer, List<Employee>> e: levelWiseEmployee.entrySet()){
            System.out.println("Level:: "+e.getKey());
            for (Employee employee:e.getValue()){
                System.out.println(employee.getEmpId()+" "+employee.getEmpName());
            }
        }
    }
}

class Employee {
    private Integer empId;
    private Integer mid;
    private String empName;

    Employee(Integer empId, Integer mid, String empName) {
        this.empId=empId;
        this.mid=mid;
        this.empName=empName;
    }
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}

