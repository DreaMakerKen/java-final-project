import java.io.*; 
import java.util.*;
public class AccountCheck{//�n�J�b���K�X�ˬd

	private String UserID="cis",UserPW="1234";//�w�]�b���K�X
		
	public void key_in(){	//�ϥΪ̿�J�b�K	
		
		String InUserID,InUserPW,word;
		char Userexit;
		boolean logincheck = true;
		
		Scanner keyboard = new Scanner(System.in);

		while(logincheck){
		System.out.println("�п�J�ϥΪ̱b�� : ");
		InUserID = keyboard.nextLine();
		System.out.println("�п�J�ϥΪ̱K�X : ");
		InUserPW = keyboard.nextLine();
		
			if (InUserID.equals(UserID)&&InUserPW.equals(UserPW)){
				System.out.println("�n�J���\!");
				logincheck = false;
			}
			else{
				System.out.println("�n�J����!");
				System.out.println("�O�_�������{��(y/n) : ");
				word = keyboard.nextLine() ;
				Userexit=(char)word.charAt(0);
				if(Userexit=='y'||Userexit=='Y'){
					System.exit(0);
				}
				else{
					System.out.println("\n�Э��s��J\n");
				}
			}
		}
	}
}