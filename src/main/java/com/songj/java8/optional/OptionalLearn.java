package com.songj.java8.optional;

import com.songj.model.po.User;
import lombok.Data;
import org.junit.Test;

import java.util.Optional;

/**
 * @Classname OptionalLearn
 * @Description https://zhuanlan.zhihu.com/p/112109825
 * @Date 2021/9/10 上午9:00
 * @Created by admin
 */
public class OptionalLearn {

    @Data
    class Good{
        private Integer id;
        private String name;
        private Good next;

        public Good() {
        }

        public Good(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }


    /**
     * 可以使用静态方法 empty() 创建一个空的 Optional 对象
    **/
    @Test
    public void empty(){
        Optional<Good> empty = Optional.empty();
        // 输出：Optional.empty
        System.out.println(empty);
    }

    /**
     * 可以使用静态方法 of () 创建一个非空的 Optional 对象。
     * 传递给 of() 方法的参数必须是非空的，也就是说不能为 null，否则仍然会抛出 NullPointerException。
    **/
    @Test
    public void of() {
        Optional<String> opt_1 = Optional.of("沉默王二");
        // 输出：Optional[沉默王二]
        System.out.println(opt_1);

        Optional<Good> opt_2 = Optional.of(new Good(1,"货物名称"));
        // 输出：Optional[OptionalLearn.Good(id=1, name=货物名称)]
        System.out.println(opt_2);
    }

    /**
     *
     * 判断对象是否存在，仅对 null 做检查，空对象检测不出。
    **/
    @Test
    public void isPresent(){
        Optional<Good> op_good_1 = Optional.ofNullable(new Good());
        //判断是否为null，输出true
        System.out.println(op_good_1.isPresent());

        Optional<Good> op_good_2 = Optional.ofNullable(null);
        //Java 9 后还可以通过方法 ifPresentOrElse(action, emptyAction) 执行两种结果，非空时执行 action，空时执行 emptyAction。

        //判断是否为null，输出false
        System.out.println(op_good_2.isPresent());
    }


    @Test
    public void orElse(){
        User user = null;
//        User result = Optional.ofNullable(user).orElse(() -> {System.out.print("");});
    }



}
