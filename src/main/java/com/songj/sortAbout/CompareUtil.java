package com.songj.sortAbout;

//import com.alibaba.fastjson.JSONObject;
//import com.gochinatv.vrs.framework.bean.LabelAlbum;
//import com.gochinatv.vrs.framework.bean.Video;
import com.songj.bean.Employee;
import org.apache.commons.lang.time.DateUtils;

import java.util.*;


public class CompareUtil {

    /**
     * sort 1正序 -1 倒序  filed 多字段排序
     */
    public static <T> Comparator createComparator(int sort, String... filed) {
        return new ImComparator(sort, filed);
    }

    public static class ImComparator implements Comparator {
        int sort = 1;
        String[] filed;

        public ImComparator(int sort, String... filed) {
            this.sort = sort == -1 ? -1 : 1;
            this.filed = filed;
        }

        @Override
        public int compare(Object o1, Object o2) {
            int result = 0;
            for (String file : filed) {
                Object value1 = ReflexUtil.invokeMethod(file, o1);
                Object value2 = ReflexUtil.invokeMethod(file, o2);
                if (value1 == null || value2 == null) {
                    continue;
                }
                if (value1 instanceof Integer) {
                    //Integer整数序排序
                    int v1 = Integer.valueOf(value1.toString());
                    int v2 = Integer.valueOf(value2.toString());
                    if (v1 == v2) {continue;}
                    if (sort == 1) {
                        return v1 - v2;
                    } else if (sort == -1) {
                        return v2 - v1;
                    }
                } else if (value1 instanceof Date) {
                    //Date类型排序
                    Date d1 = (Date) value1;
                    Date d2 = (Date) value2;
                    if (d1.compareTo(d2) == 0) {
                        continue;
                    }
                    if (sort == 1) {
                        return d1.compareTo(d2);
                    } else if (sort == -1) {
                        return d2.compareTo(d1);
                    }
                } else if (value1 instanceof Long) { //Long排序
                    long v1 = Long.valueOf(value1.toString());
                    long v2 = Long.valueOf(value2.toString());
                    if (v1 == v2) {
                        continue;
                    }
                    if (sort == 1) {
                        return v1 > v2 ? 1 : -1;
                    } else if (sort == -1) {
                        return v2 > v1 ? 1 : -1;
                    }
                } else if (value1 instanceof Double) { //Double排序
                    Double v1 = Double.valueOf(value1.toString());
                    Double v2 = Double.valueOf(value2.toString());
                    if (v1 == v2) continue;
                    if (sort == 1) {
                        return v1 > v2 ? 1 : -1;
                    } else if (sort == -1) {
                        return v2 > v1 ? 1 : -1;
                    }
                }

            }

            return result;
        }
    }

    public static void main(String args[]) {
        method02();
    }

    private static void method(){
//        Video label1 = new Video();
//        label1.setDisplayOrder(1);
//        label1.setCreateTime(DateUtils.convert("2014-01-01"));
//        Video label2 = new Video();
//        label2.setDisplayOrder(3);
//        label2.setCreateTime(DateUtils.convert("2014-01-02"));
//        Video label3 = new Video();
//        label3.setDisplayOrder(2);
//        label3.setCreateTime(DateUtils.convert("2014-01-03"));
//        Video label4 = new Video();
//        label4.setDisplayOrder(2);
//        label4.setCreateTime(DateUtils.convert("2014-01-01"));
//        Video label5 = new Video();
//        label5.setDisplayOrder(4);
//        label5.setCreateTime(DateUtils.convert("2014-01-05"));
//        List<Video> list = new ArrayList<Video>();
//        list.add(label1);
//        list.add(label2);
//        list.add(label3);
//        list.add(label4);
//        list.add(label5);
//        Collections.sort(list, CompareUtil.createComparator(1, "createTime", "displayOrder"));
//        for (int i = 0; i < list.size(); i++) {
//            Video labelAlbum = list.get(i);
//            System.out.println("displayorder:" + labelAlbum.getDisplayOrder() + "  sequence：" + DateUtils.convert(labelAlbum.getCreateTime()));
//        }
    }

    private static void method02(){
        List<Employee> employeeList = new ArrayList<Employee>() {
            {
                add(new Employee(1, 1));
                add(new Employee(2, 1));
                add(new Employee(3, 0));
                add(new Employee(4, 0));
                add(new Employee(5, 1));
                add(new Employee(6, 0));
                add(new Employee(7, 1));
                add(new Employee(8, 0));
                add(new Employee(9, 1));
                add(new Employee(10, 0));
                add(new Employee(11, 1));
            }
        };
        Collections.sort(employeeList, CompareUtil.createComparator(-1, "level", "id"));
        System.out.println("ID\tLevel");
        System.out.println("=============================");
        for (Employee employee : employeeList) {
            System.out.printf("%d\t%d\n", employee.getId(), employee.getLevel());
        }
        System.out.println("=============================");
    }
}




