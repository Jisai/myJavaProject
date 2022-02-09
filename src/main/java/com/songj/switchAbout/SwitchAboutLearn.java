package com.songj.switchAbout;

/**
 * @ClassName: SwitchAboutLearn
 * @Description: TODO
 * @Author: Scott S
 * @Date: 2018-07-16 16:04
 * @Version: 1.0
 */
public class SwitchAboutLearn {

    public static void main(String[] args) {
        SwitchAboutLearn object= new SwitchAboutLearn();
        object.method01();
//        object.method02();
//        object.method03();
//        object.method04();

    }


    /**
     * 输出：0
     */
    private void method01(){
        int i = 0;
        switch(i){
            case 0: System.out.println("0");break;
            case 1: System.out.println("1");break;
            case 2: System.out.println("2");break;
            default: System.out.println("default");break;
        }
    }

    /**
     * 输出：1
             2
             default
     */
    private void  method02(){
        int i = 1;
        switch(i){
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            default:
                System.out.println("default");
        }
    }
    /**
     * 输出：2
            3
     */
    private void  method03(){
        int i = 2;
        switch(i){
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");break;
            default:
                System.out.println("default");
        }
    }

    private void method04(){
        for(int i = 0 ; i < 5; i++){

            if(i ==3){
                System.out.println("我是 continue");
                continue;
            }
            System.out.println("我是" + i);
        }
    }

}
