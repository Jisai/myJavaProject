import com.songj.bean.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class TestMain {

	public static void main(String[] args) {
		TestMain testMain = new TestMain();
		User user = testMain.setSomeUser();
		testMain.setSomeUser(user);
		System.out.println(user);
	}



	public User setSomeUser(){
		User user = new User();
		user.setUserId(123456);
		user.setUserName("小红");
		user.setUserAge(12);
		return user;
	}

	public User setSomeUser(User user){
		user.setUserAge(13);
		user.setUserHomeAdress("北京昌平");
		return user;
	}


	public void generateExcel(){
		//创建HSSFWorkbook对象
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建HSSFSheet对象
		HSSFSheet sheet = wb.createSheet("sheet0");
		//创建HSSFRow对象
		HSSFRow row = sheet.createRow(0);
		//创建HSSFCell
		HSSFCell cell = row.createCell(0);
		//设置单元格的值
		cell.setCellValue("单元格中的中文");
		//输出Excel文件
		//FileOutputStream outputStream = new FileOutputStream("d:\\workbook.xls");


	}



}
