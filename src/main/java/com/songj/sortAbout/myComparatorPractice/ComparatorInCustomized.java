package com.songj.sortAbout.myComparatorPractice;

import com.songj.model.po.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 自定义的Comparator排序
 */
public class ComparatorInCustomized   {

    public static void main(String[] args) {
        ComparatorInCustomized myObject = new ComparatorInCustomized();
        List<Employee> employeeList =  myObject.getEmployeeListDemo();
        List<Employee> employeeSortedList = myObject.sortMethod01_2(employeeList);
        myObject.printEmployeeList(employeeSortedList);
    }



    /**
     * 第一种排序方法。
     * 规则：根据id的值大小，升序排序。
     */
    public List<Employee> sortMethod01(List<Employee> employeeList){
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int compareResult = 0;
                boolean conditon = o1.getId() < o2.getId();
                if(conditon){
                    compareResult = -1;
                }else if(conditon){
                    compareResult = 1;
                }
                return compareResult;
            }
        });
        return employeeList;
    }

    /**
     * 同 第一种排序方法。 sort return 方式改变。
     * 规则：根据id的值大小，升序排序。
     */
    public List<Employee> sortMethod01_2(List<Employee> employeeList){
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int compareResult = 0;
                boolean conditon = o1.getId() < o2.getId();
                int differenceConditon = o1.getId() - o2.getId();
                System.out.println("o1: " + o1.getId() + " o2: " + o2.getId() + " 差= " + differenceConditon);
                return differenceConditon;
            }
        });
        return employeeList;
    }

    /**
     * 第二种排序方法。
     * 规则：
     */
    public List<Employee> sortMethod02(List<Employee> employeeList){
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int compareResult = 0;
                boolean conditon = o1.getId() < o2.getId();
                int differenceConditon = o1.getId() - o2.getId();
                System.out.println("o1: " + o1.getId() + " o2: " + o2.getId() + " 差= " + differenceConditon);
                return differenceConditon;
            }
        });
        return employeeList;
    }





    /**
     * 获取排序前的 EmployeeList 信息。
     * @return
     */
    private List<Employee> getEmployeeListDemo(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"一一",1,"管理",false));
        employeeList.add(new Employee(4,"尔尔",5,"产品",false));
        employeeList.add(new Employee(6,"伞伞",2,"测试",true));
        employeeList.add(new Employee(3,"思思",5,"管理",false));
        employeeList.add(new Employee(5,"捂捂",2,"产品",true));
        employeeList.add(new Employee(7,"溜溜",5,"技术",false));
        employeeList.add(new Employee(10,"矢石",1,"管理",true));
        employeeList.add(new Employee(9,"琪琪",4,"测试",false));
        employeeList.add(new Employee(8,"叭叭",3,"技术",true));
        employeeList.add(new Employee(2,"啾啾",2,"产品",false));

        return employeeList;
    }

    /**
     * 循环打印 List 信息
     * @param employeeList
     */
    private void printEmployeeList(List<Employee> employeeList){
        System.out.println("ID\t姓名\t级别\t岗位名称\t是否已离职");
        for (Employee employee : employeeList){
            System.out.println(employee.getId() + "\t"
                    + employee.getName() + "\t"
                    + employee.getLevel() + "\t"
                    + employee.getPositionTitle() + "\t"
                    + employee.isQuit());
        }
    }
}
