package com.songj.threadAbout;

/**
 * Java使用Thread类代表线程，所有的线程对象都必须是Thread类或其子类的实例。Java可以用三种方式来创建线程，如下所示：
 * 1）继承Thread类创建线程
 * 2）实现Runnable接口创建线程
 * 3）使用Callable和Future创建线程
 */
public class CreateThread3Methods {

	//主方法用于测试
	public static void main(String[] args) {
		//MyThead_1()
		MyThead_1 myThead_1 = new MyThead_1();
		myThead_1.start();
		//MyThead_2()
		MyThead_2 myThead_2 = new MyThead_2();
		Thread thread = new Thread(myThead_2);
		thread.start();//或者    new Thread(new MyThread2()).start();
		//MyThead_3()

	}


	/**
	 * 通过继承Thread类来创建并启动多线程的一般步骤如下
	 * 1】定义Thread类的子类，并重写该类的run()方法，该方法的方法体就是线程需要完成的任务，run()方法也称为线程执行体。
	 * 2】创建Thread子类的实例，也就是创建了线程对象
	 * 3】启动线程，即调用线程的start()方法
	 */
	static class MyThead_1 extends  Thread{
		//重写run方法
		@Override
		public void run(){
			System.out.println("我是继承Thread类，重写run方法实现创建线程。");
		}
	}

	/**
	 * 通过实现Runnable接口创建并启动线程一般步骤如下：
	 * 1】定义Runnable接口的实现类，一样要重写run()方法，这个run（）方法和Thread中的run()方法一样是线程的执行体
	 * 2】创建Runnable实现类的实例，并用这个实例作为Thread的target来创建Thread对象，这个Thread对象才是真正的线程对象
	 * 3】第三部依然是通过调用线程对象的start()方法来启动线程
	 */
	static class MyThead_2 implements Runnable{
		public void run(){
			System.out.println("我是实现Runnable接口，重写run方法实现创建线程。");
		}
	}

	/**
	 * 1】创建Callable接口的实现类，并实现call()方法，然后创建该实现类的实例（从java8开始可以直接使用Lambda表达式创建Callable对象）。
	 * 2】使用FutureTask类来包装Callable对象，该FutureTask对象封装了Callable对象的call()方法的返回值
	 * 3】使用FutureTask对象作为Thread对象的target创建并启动线程（因为FutureTask实现了Runnable接口）
	 * 4】调用FutureTask对象的get()方法来获得子线程执行结束后的返回值
	 */


}
