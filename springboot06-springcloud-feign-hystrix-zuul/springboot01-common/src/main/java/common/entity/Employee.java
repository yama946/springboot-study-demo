package common.entity;

import lombok.*;

/**
 * 实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Employee {
    //员工id
    private Integer empId;
    //员工姓名
    private String empName;
    //员工工资
    private Double empSalary;
}
