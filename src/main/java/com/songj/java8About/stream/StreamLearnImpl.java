package com.songj.java8About.stream;

import com.alibaba.fastjson.JSON;
import com.songj.bean.Employee;
import com.songj.bean.People;
import com.songj.jsonAbout.JSONUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName: StreamLearnImpl
 * @Description: stream 流 学习练习
 * @Author: Scott S
 * @Date: 2019/5/6 17:18
 * @Version: 1.0
 **/

public class StreamLearnImpl implements StreamLearn {


    @Test
    @Override
    public void foreach01(){
        List<Employee> employeeList = getEmployeeDemoList(5);
        System.out.println("处理前： " + employeeList);
        employeeList.stream().forEach(item -> {
            item.setSalary(50);
            item.setQuit(true);
        });
        System.out.println("处理后： " + employeeList);
    }


    @Test
    @Override
    public void foreach02(){

    }


    @Override
    public void foreachPrintln01(List list){
        list.stream().forEach(System.out::println);
    }

    @Test
    @Override
    public void map01(){
        List<String> inputList = Arrays.asList("a", "b", "c");
        List<String> outputList = inputList.stream().
                map(String::toUpperCase).
                collect(Collectors.toList());
        foreachPrintln01(outputList);
    }

    @Test
    @Override
    public void map02(){
        List<Integer> inputList = Arrays.asList(1,3,5);
        List<Integer> outputList = inputList.stream().
                map(item -> item * item).
                collect(Collectors.toList());
        outputList.stream().forEach(System.out::println);
    }

    @Test
    @Override
    public void map03(){
        List<Employee> employees = getEmployeeDemoList(10);
        Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(Employee::getId, item -> item, (key1, key2) -> key2));
        System.out.println(map);
    }

    @Test
    @Override
    public void map04(){
        People people = new People();
        People son = new People();
        son.setSeniorityInTheFamily(2);
        people.setSeniorityInTheFamily(1);
        people.setSon(son);
        List<People> peopleList = Arrays.asList(people);
        System.out.println(peopleList.stream().map(item ->{ return item.getSon().getSeniorityInTheFamily();}).distinct().collect(Collectors.toList()));
    }

    @Test
    @Override
    public void flatMap01(){
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<List<Integer>> inputStreamCopy = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        inputStreamCopy.forEach(System.out::println);
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        outputStream.forEach(System.out::println);
    }

    @Test
    @Override
    public void filter01(){
        List<Integer> list = getIntList(10);
        //将偶数筛选出来，且转换为数组
        Integer[] evenArr = list.stream().filter(n -> n%2 == 0).toArray(Integer[]::new);
        System.out.println(Arrays.toString(evenArr));
    }


    @Test
    @Override
    public void peek01(){
        List<String> list = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        foreachPrintln01(list);
    }

    @Test
    @Override
    public void reduce01(){
        List<Integer> integers = getIntList(5);
        System.out.println(integers);
        Integer sum1 = integers.stream().reduce(0, (a, b) -> a+b);
        Integer sum2 = integers.stream().reduce(0, Integer::sum);
        System.out.println("sum1: " + sum1 + "\n" + "sum2: " + sum2);
    }


    @Test
    @Override
    public void reduce02(){
        // 字符串连接，concat1 = "ABCD"
        String concat1 = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue1 = 10, 有起始值
        int sumValue1 = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue2 = 10, 无起始值
        int sumValue2 = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤，字符串连接，concat2 = "ace"
        String concat2 = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
    }


    @Test
    @Override
    public void limit01(){
        List<Integer> integers = getIntList(10);
        System.out.println(integers);
        integers.stream().limit(5).forEach(System.out::println);
    }

    @Test
    @Override
    public void skip01(){
        List<Integer> integers = getIntList(10);
        System.out.println(integers);
        integers.stream().skip(5).forEach(System.out::println);
    }


    @Test
    @Override
    public void sort01(){
        List<Employee> employeeList = getEmployeeDemoList(5);
        foreachPrintln01(employeeList);
        System.out.println("=================");
        employeeList.stream().sorted(Comparator.comparing(Employee::getLevel)).forEach(System.out::println);
    }


    @Test
    @Override
    public void max01(){
        List<Integer> integers = getIntList(10);
        Integer max = integers.stream().max(Integer::compareTo).get();
        System.out.println("max: " + max);
    }

    @Test
    @Override
    public void min01(){
        List<Integer> integers = getIntList(10);
        Integer min = integers.stream().min(Integer::compareTo).get();
        System.out.println("min: " + min);
    }


    @Test
    @Override
    public void match01(){
        List<Employee> employees = getEmployeeDemoList(10);
        boolean predicate1 = employees.stream().allMatch(item -> item.getLevel() > 0);
        System.out.println("predicate1: " + predicate1);
        boolean predicate2 = employees.stream().anyMatch(item -> item.getLevel() > 10);
        System.out.println("predicate2: " + predicate2);
        boolean predicate3 = employees.stream().noneMatch(item -> item.getLevel() > 10);
        System.out.println("predicate3: " + predicate3);
    }

    @Test
    @Override
    public void generate01(){
        // first way
        System.out.println("first way: ");
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(item -> {
            System.out.print(item +"  ");
        });
        // second way
        System.out.println("\n");
        System.out.println("second way: ");
        IntStream.generate(() -> (int)(System.nanoTime() % 100)).limit(10).forEach(item -> {
            System.out.print(item +"  ");
        });
    }

    @Test
    @Override
    public void groupBy01(){
        List<Employee> employees = getEmployeeDemoList(10);
        Map<Boolean, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::isQuit));
        System.out.println(map);
    }


    @Test
    @Override
    public void partitioningBy01(){
        List<Employee> employees = getEmployeeDemoList(10);
        Map<Boolean, List<Employee>> map = employees.stream().collect(Collectors.partitioningBy(item -> item.getLevel() > 5));
        System.out.println(map);
    }

    @Test
    @Override
    public  void groupByAndSort01() {
        List<Employee> employees = getEmployeeDemoList(10);
        Map<Boolean, List<Employee>> treeMap1 = employees.stream()
                .sorted(Comparator.comparing(Employee::getLevel))
                .collect(Collectors.groupingBy(Employee::isQuit));
        System.out.println(JSONUtil.objectToString(treeMap1));
        Map<Boolean, List<Employee>> treeMap2 = employees.stream()
                .sorted(Comparator.comparing(Employee::getId))
                .collect(Collectors.groupingBy(Employee::isQuit));
        System.out.println(JSONUtil.objectToString(treeMap2));
    }



    // ====================== 》》》 私有方法 《《《 ========================
    /**
     * 获取Employee示例的List 数据
     **/
    private List<Employee> getEmployeeDemoList(int size){
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < size; i ++){
            Employee one = new Employee();
            one.setId(i + 1);
            one.setName("代号 " + i);
            one.setLevel(10 - i);
            one.setPositionTitle("我是岗位名称");
            one.setSalary(100);
            one.setYear(i);
            one.setQuit(i % 2 == 0? true : false);
            result.add(one);
        }

        Employee two = new Employee();
        two.setId(1);
        two.setName("代号 1(1)" );
        two.setLevel(10);
        two.setPositionTitle("我是岗位名称");
        two.setSalary(100);
        two.setYear(1);
        two.setQuit(1 % 2 == 0? true : false);
        result.add(two);
        return result;
    }

    /**
     * 获取0-max的list
     **/
    private List<Integer> getIntList(int max){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= max; i++){
            result.add(i);
        }
        return result;
    }





}
