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
		
		AccountCheck Userlogin = new AccountCheck();// �إߤ@�Өt�εn�J������
		
        Userlogin.key_in();// �ˬd�b���K�X
		
		File newTxt = new File("�ӤH�u�@.txt");//�Ф����
          if( !newTxt.exists() ){
               newTxt.createNewFile();//�b��java�ɥؿ��U�إ� �ӤH�u�@.txt��
          }
		Scanner keyboard = new Scanner(System.in);
		int userFunction;
		int instruction;
		while(true){
			//���ϥΪ̥\��or�޲z�̥\��
			System.out.println("------------------------------\n");
			System.out.println("�i�J�ϥΪ̤��� �Ы�1:");
			System.out.println("�i�J�޲z�̤��� �Ы�2:");
			System.out.println("\n��J:");
			userFunction = keyboard.nextInt();
			System.out.println("------------------------------\n");
			workInstruction User = new workInstruction();
			User.readfile();
			if(userFunction==1){//�ϥΪ̥\��
				User.showUserMenu();
				System.out.print("�{�b�ɶ�");
				User.Datetime();
				System.out.println("------------------------------\n");
				System.out.println("��J���O:");
				instruction = keyboard.nextInt();
				System.out.println("------------------------------\n");
		
				while(true){	
					switch(instruction)
					{
						case 1:User.key_Data();//�s�W���
								System.out.println("------------------------------\n");
								break;
						case 2:User.editData();//�s����
								System.out.println("------------------------------\n");
								break;
						case 3:User.deleteData();//�R�����
								System.out.println("------------------------------\n");
								break;
						case 4:User.showData();//��ܸ��
								System.out.println("------------------------------\n");
								break;
						case 5:User.searchDataName();//�d�ߤu�@�̦W��
								System.out.println("------------------------------\n");
								break;
						case 6:User.searchDataNumber();//�d�ߤu�@�̽s��
								System.out.println("------------------------------\n");
								break;
						case 7:User.showUnfinishedData();//�d�ߥ������u�@
								System.out.println("------------------------------\n");
								break;
						case 0:System.exit(0);//���}
								break;
						default:System.out.println("�L�ī��O���s��J");
								break;
					}
					User.storeinTxt();
					User.showUserMenu();
					System.out.print("�{�b�ɶ�");
					User.Datetime();
					System.out.println("------------------------------\n");
					System.out.println("��J���O:");
					instruction = keyboard.nextInt();
					System.out.println("------------------------------\n");
				}
			}
			else if(userFunction==2){//�޲z�̥\��
				User.showMenu();
				System.out.print("�{�b�ɶ�");
				User.Datetime();
				System.out.println("------------------------------\n");
				System.out.println("��J���O:");
				instruction = keyboard.nextInt();
				System.out.println("------------------------------\n");
		
				while(true){	
					switch(instruction)
					{
						case 1:User.key_Data();//�s�W���
								System.out.println("------------------------------\n");
								break;
						case 2:User.editData();//�s����
								System.out.println("------------------------------\n");
								break;
						case 3:User.deleteData();//�R�����
								System.out.println("------------------------------\n");
								break;
						case 4:User.showData();//��ܸ��
								System.out.println("------------------------------\n");
								break;
						case 5:User.searchDataName();//�d�ߤu�@�̦W��
								System.out.println("------------------------------\n");
								break;
						case 6:User.searchDataNumber();//�d�ߤu�@�̽s��
								System.out.println("------------------------------\n");
								break;
						case 7:User.showUnfinishedData();//�d�ߥ������u�@
								System.out.println("------------------------------\n");
								break;
						case 8:User.setShowpartData();//�]�w������ܤu�@
								System.out.println("------------------------------\n");
								break;
						case 9:User.setshowData();//�]�w������
								System.out.println("------------------------------\n");
								break;
						case 10:User.sortData();//�]�w����
								System.out.println("------------------------------\n");
								break;
						case 0:System.exit(0);//���}
								break;
						default:System.out.println("�L�ī��O���s��J");
								break;
					}
					User.storeinTxt();
					User.showMenu();
					System.out.print("�{�b�ɶ�");
					User.Datetime();
					System.out.println("------------------------------\n");
					System.out.println("��J���O:");
					instruction = keyboard.nextInt();
					System.out.println("------------------------------\n");
				}
			}
		}
	}
}