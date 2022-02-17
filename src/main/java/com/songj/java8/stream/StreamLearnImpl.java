package com.songj.java8.stream;

import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.songj.model.po.Employee;
import com.songj.model.po.People;
import com.songj.model.po.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

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
    public void parallelStream(){
        List<Employee> employeeList = getEmployeeDemoList(5);
        employeeList.parallelStream().filter(item -> item.getId().intValue()%2==0).forEach(item -> System.out.println(item.getId()));
    }

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
    public void flatMap02(){
        Map<Integer, List<User>> map = Maps.newHashMap();
        List<User> aClassList1 = Lists.newArrayList();
        User aClass = new User(1, "zhuoli1", "haha1");
        aClassList1.add(aClass);
        aClassList1.add(new User(2, "zhuoli2", "haha2"));
        aClassList1.add(new User(3, "zhuoli3", "haha3"));

        List<User> aClassList2 = Lists.newArrayList();
        aClassList2.add(aClass);
        aClassList2.add(new User(5, "zhuoli5", "haha5"));
        aClassList2.add(new User(6, "zhuoli6", "haha6"));

        /*交集*/
        /*[User(id=1, name=zhuoli1, description=haha1)]*/
        List<User> intersectResult = aClassList1.stream().filter(aClassList2::contains).collect(Collectors.toList());
        System.out.println(intersectResult);

        /*并集*/
        List<User> unionResult = Stream.of(aClassList1, aClassList2).flatMap(Collection::stream).distinct().collect(Collectors.toList());
        assertEquals(unionResult.size(), 5);
        System.out.println(unionResult);

        /*差集*/
        /*[User(id=2, name=zhuoli2, description=haha2), AClass(id=3, name=zhuoli3, description=haha3)]*/
        List<User> differenceResult = aClassList1.stream().filter(x -> !aClassList2.contains(x)).collect(Collectors.toList());
        System.out.println(differenceResult);

        map.put(1, new ArrayList<>(aClassList1));
        map.put(2, new ArrayList<>(aClassList2));

        /*合并多个list*/
        List<User> aClassListResult = map.values().stream().flatMap(item -> item.stream()).collect(Collectors.toList());
        /*注意跟并集的区别*/
        assertEquals(aClassListResult.size(), 6);
        System.out.println(aClassListResult);

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
    public void sort02(){
        List<Employee> employeeList = getEmployeeDemoList(5);
        foreachPrintln01(employeeList);
        System.out.println("=================");
        employeeList.stream()
                .sorted((x,y) -> x.getLevel() - y.getLevel())
                .forEach(System.out::println);
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
        System.out.println(JSONUtil.toJsonStr(treeMap1));
        Map<Boolean, List<Employee>> treeMap2 = employees.stream()
                .sorted(Comparator.comparing(Employee::getId))
                .collect(Collectors.groupingBy(Employee::isQuit));
        System.out.println(JSONUtil.toJsonStr(treeMap2));
    }

    @Test
    @Override
    public  void summaryStatistics01(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
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
