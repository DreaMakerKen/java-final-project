import java.io.*; 
import java.util.*;
public class AccountCheck{//登入帳號密碼檢查

	private String UserID="cis",UserPW="1234";//預設帳號密碼
		
	public void key_in(){	//使用者輸入帳密	
		
		String InUserID,InUserPW,word;
		char Userexit;
		boolean logincheck = true;
		
		Scanner keyboard = new Scanner(System.in);

		while(logincheck){
		System.out.println("請輸入使用者帳號 : ");
		InUserID = keyboard.nextLine();
		System.out.println("請輸入使用者密碼 : ");
		InUserPW = keyboard.nextLine();
		
			if (InUserID.equals(UserID)&&InUserPW.equals(UserPW)){
				System.out.println("登入成功!");
				logincheck = false;
			}
			else{
				System.out.println("登入失敗!");
				System.out.println("是否關閉本程式(y/n) : ");
				word = keyboard.nextLine() ;
				Userexit=(char)word.charAt(0);
				if(Userexit=='y'||Userexit=='Y'){
					System.exit(0);
				}
				else{
					System.out.println("\n請重新輸入\n");
				}
			}
		}
	}
}