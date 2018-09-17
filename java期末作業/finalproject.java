import java.io.*; 
import java.util.*;
public class finalproject {
	public static int num = 0;
	public static int partnumber = 10;
	public static boolean setPartShow = false;
	public static String data[][]=new String[128][8];
	public static boolean showName = true;
	public static boolean showFinishtime = true;
	public static boolean showStarttime = true;
	public static boolean showPercent = true;
	public static boolean showStatus = true;
	public static boolean showNumber = true;
	public static boolean showSort = true;
	public static boolean showContent = true;
	
	
    public static void main(String[] args)throws IOException {
		
		AccountCheck Userlogin = new AccountCheck();// 建立一個系統登入的物件
		
        Userlogin.key_in();// 檢查帳號密碼
		
		File newTxt = new File("個人工作.txt");//創文件檔
          if( !newTxt.exists() ){
               newTxt.createNewFile();//在此java檔目錄下建立 個人工作.txt檔
          }
		Scanner keyboard = new Scanner(System.in);
		int userFunction;
		int instruction;
		while(true){
			//分使用者功能or管理者功能
			System.out.println("------------------------------\n");
			System.out.println("進入使用者介面 請按1:");
			System.out.println("進入管理者介面 請按2:");
			System.out.println("\n輸入:");
			userFunction = keyboard.nextInt();
			System.out.println("------------------------------\n");
			workInstruction User = new workInstruction();
			User.readfile();
			if(userFunction==1){//使用者功能
				User.showUserMenu();
				System.out.print("現在時間");
				User.Datetime();
				System.out.println("------------------------------\n");
				System.out.println("輸入指令:");
				instruction = keyboard.nextInt();
				System.out.println("------------------------------\n");
		
				while(true){	
					switch(instruction)
					{
						case 1:User.key_Data();//新增資料
								System.out.println("------------------------------\n");
								break;
						case 2:User.editData();//編輯資料
								System.out.println("------------------------------\n");
								break;
						case 3:User.deleteData();//刪除資料
								System.out.println("------------------------------\n");
								break;
						case 4:User.showData();//顯示資料
								System.out.println("------------------------------\n");
								break;
						case 5:User.searchDataName();//查詢工作依名稱
								System.out.println("------------------------------\n");
								break;
						case 6:User.searchDataNumber();//查詢工作依編號
								System.out.println("------------------------------\n");
								break;
						case 7:User.showUnfinishedData();//查詢未完成工作
								System.out.println("------------------------------\n");
								break;
						case 0:System.exit(0);//離開
								break;
						default:System.out.println("無效指令重新輸入");
								break;
					}
					User.storeinTxt();
					User.showUserMenu();
					System.out.print("現在時間");
					User.Datetime();
					System.out.println("------------------------------\n");
					System.out.println("輸入指令:");
					instruction = keyboard.nextInt();
					System.out.println("------------------------------\n");
				}
			}
			else if(userFunction==2){//管理者功能
				User.showMenu();
				System.out.print("現在時間");
				User.Datetime();
				System.out.println("------------------------------\n");
				System.out.println("輸入指令:");
				instruction = keyboard.nextInt();
				System.out.println("------------------------------\n");
		
				while(true){	
					switch(instruction)
					{
						case 1:User.key_Data();//新增資料
								System.out.println("------------------------------\n");
								break;
						case 2:User.editData();//編輯資料
								System.out.println("------------------------------\n");
								break;
						case 3:User.deleteData();//刪除資料
								System.out.println("------------------------------\n");
								break;
						case 4:User.showData();//顯示資料
								System.out.println("------------------------------\n");
								break;
						case 5:User.searchDataName();//查詢工作依名稱
								System.out.println("------------------------------\n");
								break;
						case 6:User.searchDataNumber();//查詢工作依編號
								System.out.println("------------------------------\n");
								break;
						case 7:User.showUnfinishedData();//查詢未完成工作
								System.out.println("------------------------------\n");
								break;
						case 8:User.setShowpartData();//設定分頁顯示工作
								System.out.println("------------------------------\n");
								break;
						case 9:User.setshowData();//設定顯示欄位
								System.out.println("------------------------------\n");
								break;
						case 10:User.sortData();//設定順序
								System.out.println("------------------------------\n");
								break;
						case 0:System.exit(0);//離開
								break;
						default:System.out.println("無效指令重新輸入");
								break;
					}
					User.storeinTxt();
					User.showMenu();
					System.out.print("現在時間");
					User.Datetime();
					System.out.println("------------------------------\n");
					System.out.println("輸入指令:");
					instruction = keyboard.nextInt();
					System.out.println("------------------------------\n");
				}
			}
		}
	}
}