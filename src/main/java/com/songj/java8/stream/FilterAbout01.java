package com.songj.java8.stream;

import com.songj.model.po.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAbout01 {

    public static void main(String[] args) {
//        filterMethod01();
        filterSortMethod01();
    }


    /**
     * 符合filter条件数据的被过滤出来
     */
    private static void filterMethod01(){
        List<User> userList = getUserList(10);
        List<User> userListBack = new ArrayList<>();
        System.out.println("过滤前：");
        System.out.println(userList.toString());
        userListBack = userList.parallelStream().filter(item -> "男".equals(item.getUserSex())).collect(Collectors.toList());
        List<Integer> userIdListBack = userList.parallelStream().filter(item -> !("男".equals(item.getUserSex()))).map(User::getUserId).collect(Collectors.toList());
        System.out.println("过滤后：");
        System.out.println(userListBack.toString());
        System.out.println(userIdListBack.toString());
    }

    /**
     * @Description: 根据filter条件进行过滤，然后按照某一条件倒叙。
     * @Author: Scott S
     * @Date: 2019/5/6 - 15:46
     **/
    private static void filterSortMethod01(){
        List<User> userList = getUserList(10);
        List<User> userListBack = new ArrayList<>();
        System.out.println("过滤前：");
        System.out.println(userList.toString());
        userListBack = userList.parallelStream().filter(item -> "男".equals(item.getUserSex())).sorted(Comparator.comparing(User::getUserId).reversed()).collect(Collectors.toList());
        System.out.println("过滤后：");
        System.out.println(userListBack.toString());
    }





    private static List<User> getUserList(int userListSize){
        List<User> userList = new ArrayList<>();
        for(int i = 0; i < userListSize; i++){
            User user = new User();
            user.setUserId(i);
            user.setUserName("用户0" + i);
            user.setUserAge(10);
            user.setUserSalary(1000);
            user.setUserSex(i%2 == 0 ? "男" : "女");
            userList.add(user);
        }
        return userList;
    }

}
