import java.io.*; 
import java.util.*;

public class workInstruction	
{
	BufferedReader index =null;
	
	
	public void readfile(){		//Ū���Ҧ�����ɤ������e
		int ri=0,rj=0;
		try
		{
		index = new BufferedReader((new InputStreamReader( new FileInputStream("�ӤH�u�@.txt"))));
		String line = index.readLine();
        while (line != null)
        {
			StringTokenizer s = new StringTokenizer(line," ");
			while(s.hasMoreTokens()) {
				for(rj=0;rj<8;rj++){
					finalproject.data[ri][rj] = s.nextToken();
				}
			}
			line = index.readLine( );
			ri++;
        }
		index.close( );
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.");
		}
		catch(IOException e)
		{
			System.out.println("Error reading from �ӤH�u�@.txt.");
		}
	}
	
	public void key_Data(){		//��J�s�W��}�C
        Scanner keyboard = new Scanner(System.in);

        System.out.println("��J�u�@�W��:");
        String s1 = keyboard.next();
		finalproject.data[finalproject.num][0]=s1;
        System.out.println("��J�������:(�榡mmdd)");
        String s2 = keyboard.next();
		finalproject.data[finalproject.num][1]=s2;
		System.out.println("��J�}�l���:(�榡mmdd)");
        String s3 = keyboard.next();
		finalproject.data[finalproject.num][2]=s3;
		System.out.println("��J�����ʤ���:(��J1~100��������)");
        String s4 = keyboard.next();
			int strToint = Integer.parseInt(s4);
			while(strToint>100||strToint<0){
				System.out.println("�ƭȿ��~,�Э��s��J!");
				System.out.println("��J�����ʤ���:(��J1~100��������)");
				s4 = keyboard.next();
				strToint = Integer.parseInt(s4);
			}
		finalproject.data[finalproject.num][3]=s4;
		System.out.println("��J���A:(�����B���椤�B���}�l)");
        String s5 = keyboard.next();
			while(!(s5.equals("����")||s5.equals("���椤")||s5.equals("���}�l"))){
				System.out.println("���A���~,�Э��s��J!");
				System.out.println("��J���A:(�����B���椤�B���}�l)");
				s5 = keyboard.next();
			}
		finalproject.data[finalproject.num][4]=s5;
		System.out.println("��J�s��:(�H�@�ӭ^��r���}�Y,���۬O����Ʀr)");
        String s6 = keyboard.next();
		finalproject.data[finalproject.num][5]=s6;
		System.out.println("��J����:");
        String s7 = keyboard.next();
		finalproject.data[finalproject.num][6]=s7;
		System.out.println("��J�u�@���e:");
        String s8 = keyboard.next();
		finalproject.data[finalproject.num][7]=s8;
        System.out.println("Writing to file.");
       
		finalproject.num++;
	}
	public void editData(){	//�s��}�C
		Scanner keyboard = new Scanner(System.in);
		System.out.println("��J���s��u�@�W��:");
		String editname=keyboard.next();
		for(int i=0;i<finalproject.num;i++){
			if(finalproject.data[i][0].equals(editname)){
				System.out.println("��J�u�@�W��:");
				finalproject.data[i][0] = keyboard.next();
				System.out.println("��J�����ɶ�:(�榡mmdd)");
				finalproject.data[i][1] = keyboard.next();
				System.out.println("��J�}�l�ɶ�:(�榡mmdd)");
				finalproject.data[i][2] = keyboard.next();
				System.out.println("��J�����ʤ���:(��J1~100��������)");
				finalproject.data[i][3] = keyboard.next();
					int strToint = Integer.parseInt(finalproject.data[i][3]);
					while(strToint>100||strToint<0){
						System.out.println("�ƭȿ��~,�Э��s��J!");
						System.out.println("��J�����ʤ���:(��J1~100��������)");
						finalproject.data[i][3] = keyboard.next();
						strToint = Integer.parseInt(finalproject.data[i][3]);
					}
				System.out.println("��J���A:(�����B���椤�B���}�l)");
				finalproject.data[i][4] = keyboard.next();
					while(!(finalproject.data[i][4].equals("����")||finalproject.data[i][4].equals("���椤")||finalproject.data[i][4].equals("���}�l"))){
						System.out.println("���A���~,�Э��s��J!");
						System.out.println("��J���A:(�����B���椤�B���}�l)");
						finalproject.data[i][4] = keyboard.next();
					}
				System.out.println("��J�s��:(�H�@�ӭ^��r���}�Y,���۬O����Ʀr)");
				finalproject.data[i][5] = keyboard.next();
				System.out.println("��J����:");
				finalproject.data[i][6] = keyboard.next();
				System.out.println("��J�u�@���e:");
				finalproject.data[i][7] = keyboard.next();
			}
		}
	}
	
	public void deleteData(){		//�R���}�C
		Scanner keyboard = new Scanner(System.in);
		boolean flag = false;
		System.out.println("��J���R���u�@�W��:");
		String deletename=keyboard.next();
		for(int e=0;e<finalproject.num;e++){
			int temp=0;
			if(finalproject.data[e][0].equals(deletename)){
				flag=true;
				temp = e;
				finalproject.num--;
			}
			if(flag){
				e=temp;
				for(e=temp;e<finalproject.num;e++){	
					for(int k=0;k<8;k++){
						finalproject.data[e][k]=finalproject.data[e+1][k];
					}
				}
			}
		}
		
	}
	
	public void showData(){	//��ܰ}�C
		for(int showi=0;showi<finalproject.num;showi++){
			if(finalproject.showName)
			System.out.print("�u�@�W��:"+finalproject.data[showi][0]);
			if(finalproject.showFinishtime)
			System.out.print(" �����ɶ�:"+finalproject.data[showi][1]);
			if(finalproject.showStarttime)
			System.out.print(" �}�l�ɶ�:"+finalproject.data[showi][2]);
			if(finalproject.showPercent)
			System.out.print(" �����ʤ���:"+finalproject.data[showi][3]);
			if(finalproject.showStatus)
			System.out.print(" �u�@���A:"+finalproject.data[showi][4]);
			if(finalproject.showNumber)
			System.out.print(" �u�@�s��:"+finalproject.data[showi][5]);
			if(finalproject.showSort)
			System.out.print(" �u�@����:"+finalproject.data[showi][6]);
			if(finalproject.showContent)
			System.out.print(" �u�@���e:"+finalproject.data[showi][7]);
			System.out.print("\n");
			if(finalproject.setPartShow){
				if((((showi+1)%finalproject.partnumber)==0)&&(showi!=0))
					System.out.println("------------------------------\n");		
			}
		}	
	}
	
	public void showUnfinishedData(){//��ܥ������u�@
		for(int u=0;u<finalproject.num;u++){
			if(finalproject.data[u][4].equals("����")){}
			else{
				if(finalproject.showName)
				System.out.print("�u�@�W��:"+finalproject.data[u][0]);
				if(finalproject.showFinishtime)
				System.out.print(" �����ɶ�:"+finalproject.data[u][1]);
				if(finalproject.showStarttime)
				System.out.print(" �}�l�ɶ�:"+finalproject.data[u][2]);
				if(finalproject.showPercent)
				System.out.print(" �����ʤ���:"+finalproject.data[u][3]);
				if(finalproject.showStatus)
				System.out.print(" �u�@���A:"+finalproject.data[u][4]);
				if(finalproject.showNumber)
				System.out.print(" �u�@�s��:"+finalproject.data[u][5]);
				if(finalproject.showSort)
				System.out.print(" �u�@����:"+finalproject.data[u][6]);
				if(finalproject.showContent)
				System.out.print(" �u�@���e:"+finalproject.data[u][7]);
				System.out.print("\n");
				if(finalproject.setPartShow){
					if((((u+1)%finalproject.partnumber)==0)&&(u!=0))
						System.out.println("------------------------------\n");		
				}
			}
		}		
	}
	
	public void setShowpartData(){//������ܰ}�C
		Scanner keyboard = new Scanner(System.in);
		System.out.println("�O�_�]�w�������");
		System.out.println("�O : ��J1 �_ : ��J2");
		int setShowpart = keyboard.nextInt();
		if(setShowpart==1){
			finalproject.setPartShow=true;
			System.out.println("��J�]�w������ܴX���u�@:(��J�Ʀr)");
			finalproject.partnumber  = keyboard.nextInt();
		}
		else if(setShowpart==2){
			finalproject.setPartShow=false;
		}
		else
			System.out.println("��J���~ �^�D���!");
			
	}
	
	
	public void searchDataName(){	//�d�ߤu�@
		boolean find = false;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("��J�d�ߤu�@�W��:");//�d�ߤu�@�̦W��
		String searchname = keyboard.next();
		for(int s=0;s<finalproject.num;s++){
			if(finalproject.data[s][0].equals(searchname)){
				if(finalproject.showName)
				System.out.print("�u�@�W��:"+finalproject.data[s][0]);
				if(finalproject.showFinishtime)
				System.out.print(" �����ɶ�:"+finalproject.data[s][1]);
				if(finalproject.showStarttime)
				System.out.print(" �}�l�ɶ�:"+finalproject.data[s][2]);
				if(finalproject.showPercent)
				System.out.print(" �����ʤ���:"+finalproject.data[s][3]);
				if(finalproject.showStatus)
				System.out.print(" �u�@���A:"+finalproject.data[s][4]);
				if(finalproject.showNumber)
				System.out.print(" �u�@�s��:"+finalproject.data[s][5]);
				if(finalproject.showSort)
				System.out.print(" �u�@����:"+finalproject.data[s][6]);
				if(finalproject.showContent)
				System.out.print(" �u�@���e:"+finalproject.data[s][7]);
				System.out.print("\n");
				find = true;
			}
		}			
		if(!find){
			System.out.println("�L���u�@");
		}
	
	}
	
	public void searchDataNumber(){	//�d�ߤu�@
		boolean find = false;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("��J�d�ߤu�@�s��:");//�d�ߤu�@�̽s��
		String searchname = keyboard.next();
		for(int s=0;s<finalproject.num;s++){
			if(finalproject.data[s][5].equals(searchname)){
				if(finalproject.showName)
				System.out.print("�u�@�W��:"+finalproject.data[s][0]);
				if(finalproject.showFinishtime)
				System.out.print(" �����ɶ�:"+finalproject.data[s][1]);
				if(finalproject.showStarttime)
				System.out.print(" �}�l�ɶ�:"+finalproject.data[s][2]);
				if(finalproject.showPercent)
				System.out.print(" �����ʤ���:"+finalproject.data[s][3]);
				if(finalproject.showStatus)
				System.out.print(" �u�@���A:"+finalproject.data[s][4]);
				if(finalproject.showNumber)
				System.out.print(" �u�@�s��:"+finalproject.data[s][5]);
				if(finalproject.showSort)
				System.out.print(" �u�@����:"+finalproject.data[s][6]);
				if(finalproject.showContent)
				System.out.print(" �u�@���e:"+finalproject.data[s][7]);
				System.out.print("\n");
				find = true;
			}
		}			
		if(!find){
			System.out.println("�L���u�@");
		}
	
	}
	
	public void setshowData(){//�]�w�������
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("  �]�w������\n");//�]�w��ܩΤ����
		System.out.println("------------------------------\n");
		System.out.println("  ��J1 �]�w������");
		System.out.println("  ��J2 �]�w��������");
		int setshow = keyboard.nextInt();
		System.out.println("------------------------------\n");
		if(setshow==1){
			System.out.println("  ��J������:\n");
			System.out.println("  ��ܤu�@�W��   ��J1");
			System.out.println("  ��ܧ����ɶ�   ��J2");
			System.out.println("  ��ܶ}�l�ɶ�   ��J3");
			System.out.println("  ��ܧ����ʤ��� ��J4");
			System.out.println("  ��ܤu�@���A   ��J5");
			System.out.println("  ��ܤu�@�s��   ��J6");
			System.out.println("  ��ܤu�@����   ��J7");
			System.out.println("  ��ܤu�@���e   ��J8");
			System.out.println("  ���}           ��J9");
			int setYesshow = keyboard.nextInt();
			switch(setYesshow){
				case 1 : finalproject.showName = true;
						break;
				case 2 : finalproject.showFinishtime = true;
						break;
				case 3 : finalproject.showStarttime = true;
						break;
				case 4 : finalproject.showPercent = true;
						break;
				case 5 : finalproject.showStatus = true;
						break;
				case 6 : finalproject.showNumber = true;
						break;
				case 7 : finalproject.showSort = true;
						break;
				case 8 : finalproject.showContent = true;
						break;
				case 9 : 	
						break;
			}
		}
		else if(setshow==2){
			System.out.println("  ��J��������:\n");
			System.out.println("  ����ܤu�@�W��   ��J1");
			System.out.println("  ����ܧ����ɶ�   ��J2");
			System.out.println("  ����ܶ}�l�ɶ�   ��J3");
			System.out.println("  ����ܧ����ʤ��� ��J4");
			System.out.println("  ����ܤu�@���A   ��J5");
			System.out.println("  ����ܤu�@�s��   ��J6");
			System.out.println("  ����ܤu�@����   ��J7");
			System.out.println("  ����ܤu�@���e   ��J8");
			System.out.println("  ���}             ��J9");
			int setNotshow = keyboard.nextInt();
			switch(setNotshow){
				case 1 : finalproject.showName = false;
						break;
				case 2 : finalproject.showFinishtime = false;
						break;
				case 3 : finalproject.showStarttime = false;
						break;
				case 4 : finalproject.showPercent = false;
						break;
				case 5 : finalproject.showStatus = false;
						break;
				case 6 : finalproject.showNumber = false;
						break;
				case 7 : finalproject.showSort = false;
						break;
				case 8 : finalproject.showContent = false;
						break;
				case 9 : 	
						break;
				default: System.out.println("��J���~!!");
			}	
		}
		else
			System.out.println("��J���~!!���}!!");
		
	}
	
	public void sortData(){		//�]�w�}�C�Ƨ�
		Scanner keyboard = new Scanner(System.in);
		System.out.println("\n�]�w�̧����ץѤp��j��� �Ы�1");
		System.out.println("\n�]�w�̧����ץѤj��p��� �Ы�2");
		int setsort = keyboard.nextInt();
		if(setsort==1){
			bubble_sort(true);
		}
		else if(setsort==2){
			bubble_sort(false);
		}
		else{
			System.out.println("��J���~!!���}!!");
		}
		
	
	}
	
	public void bubble_sort(boolean isIncrease){ //��w�Ƨǡ]Bubble sort�^
		String tempdata[]=new String[8];
		int n=0;
		for(int i=finalproject.num-1;i>0;i--){
			for(int k=0;k<i;k++){
				if((isIncrease&&Integer.parseInt(finalproject.data[k][3])>Integer.parseInt(finalproject.data[k+1][3]))||(!isIncrease&Integer.parseInt(finalproject.data[k][3])<Integer.parseInt(finalproject.data[k+1][3]))){ //���W����P�_
					for(n=0;n<8;n++){
					tempdata[n]=finalproject.data[k][n];
					finalproject.data[k][n]=finalproject.data[k+1][n];
					finalproject.data[k+1][n]=tempdata[n];
					}
				}
			}
		}
		
	}
	
	public void Datetime(){
		 Date current=new Date();
         java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String c=sdf.format(current);
         System.out.println(c);
	}
	
	
	public void storeinTxt() throws IOException{	//��}�C�s��txt
		PrintWriter outputStream = new PrintWriter(new FileOutputStream("�ӤH�u�@.txt"));
				for(int c=0;c<finalproject.num;c++){
					outputStream.println(finalproject.data[c][0]+" "+finalproject.data[c][1]+" "+finalproject.data[c][2]+" "+finalproject.data[c][3]+" "+finalproject.data[c][4]
						+" "+finalproject.data[c][5]+" "+finalproject.data[c][6]+" "+finalproject.data[c][7]);
				}
		outputStream.close();
	}
	
	
	
	public void showUserMenu(){
		System.out.println("==============================");
		System.out.println("+++++++�ӤH�u�@�޲z�t��+++++++");
		System.out.println("==============================");
		System.out.println("     �s�W�u�@          �Ы�1  ");
		System.out.println("     �s��u�@          �Ы�2  ");
		System.out.println("     �R���u�@          �Ы�3  ");
		System.out.println("     ��ܥ����u�@      �Ы�4  ");
		System.out.println("     �d�ߤu�@(�W��)    �Ы�5  ");
		System.out.println("     �d�ߤu�@(�s��)    �Ы�6  ");
		System.out.println("     ��ܥ������u�@    �Ы�7  ");
		System.out.println("     ���}              �Ы�0  ");
		System.out.println("==============================");
	}
	
	public void showMenu(){
		System.out.println("==============================");
		System.out.println("+++++++�ӤH�u�@�޲z�t��+++++++");
		System.out.println("==============================");
		System.out.println("     �s�W�u�@          �Ы�1  ");
		System.out.println("     �s��u�@          �Ы�2  ");
		System.out.println("     �R���u�@          �Ы�3  ");
		System.out.println("     ��ܥ����u�@      �Ы�4  ");
		System.out.println("     �d�ߤu�@(�W��)    �Ы�5  ");
		System.out.println("     �d�ߤu�@(�s��)    �Ы�6  ");
		System.out.println("     ��ܥ������u�@    �Ы�7  ");
		System.out.println("     �]�w�������      �Ы�8  ");
		System.out.println("     �]�w������      �Ы�9  ");
		System.out.println("     �]�w��ܶ���      �Ы�10 ");
		System.out.println("     ���}              �Ы�0  ");
		System.out.println("==============================");
	}
}