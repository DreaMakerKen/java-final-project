import java.io.*; 
import java.util.*;

public class workInstruction	
{
	BufferedReader index =null;
	
	
	public void readfile(){		//讀取所有文件檔內的內容
		int ri=0,rj=0;
		try
		{
		index = new BufferedReader((new InputStreamReader( new FileInputStream("個人工作.txt"))));
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
			System.out.println("Error reading from 個人工作.txt.");
		}
	}
	
	public void key_Data(){		//輸入新增到陣列
        Scanner keyboard = new Scanner(System.in);

        System.out.println("輸入工作名稱:");
        String s1 = keyboard.next();
		finalproject.data[finalproject.num][0]=s1;
        System.out.println("輸入完成日期:(格式mmdd)");
        String s2 = keyboard.next();
		finalproject.data[finalproject.num][1]=s2;
		System.out.println("輸入開始日期:(格式mmdd)");
        String s3 = keyboard.next();
		finalproject.data[finalproject.num][2]=s3;
		System.out.println("輸入完成百分比:(輸入1~100之間的數)");
        String s4 = keyboard.next();
			int strToint = Integer.parseInt(s4);
			while(strToint>100||strToint<0){
				System.out.println("數值錯誤,請重新輸入!");
				System.out.println("輸入完成百分比:(輸入1~100之間的數)");
				s4 = keyboard.next();
				strToint = Integer.parseInt(s4);
			}
		finalproject.data[finalproject.num][3]=s4;
		System.out.println("輸入狀態:(完成、執行中、未開始)");
        String s5 = keyboard.next();
			while(!(s5.equals("完成")||s5.equals("執行中")||s5.equals("未開始"))){
				System.out.println("狀態錯誤,請重新輸入!");
				System.out.println("輸入狀態:(完成、執行中、未開始)");
				s5 = keyboard.next();
			}
		finalproject.data[finalproject.num][4]=s5;
		System.out.println("輸入編號:(以一個英文字母開頭,接著是五位數字)");
        String s6 = keyboard.next();
		finalproject.data[finalproject.num][5]=s6;
		System.out.println("輸入分類:");
        String s7 = keyboard.next();
		finalproject.data[finalproject.num][6]=s7;
		System.out.println("輸入工作內容:");
        String s8 = keyboard.next();
		finalproject.data[finalproject.num][7]=s8;
        System.out.println("Writing to file.");
       
		finalproject.num++;
	}
	public void editData(){	//編輯陣列
		Scanner keyboard = new Scanner(System.in);
		System.out.println("輸入欲編輯工作名稱:");
		String editname=keyboard.next();
		for(int i=0;i<finalproject.num;i++){
			if(finalproject.data[i][0].equals(editname)){
				System.out.println("輸入工作名稱:");
				finalproject.data[i][0] = keyboard.next();
				System.out.println("輸入完成時間:(格式mmdd)");
				finalproject.data[i][1] = keyboard.next();
				System.out.println("輸入開始時間:(格式mmdd)");
				finalproject.data[i][2] = keyboard.next();
				System.out.println("輸入完成百分比:(輸入1~100之間的數)");
				finalproject.data[i][3] = keyboard.next();
					int strToint = Integer.parseInt(finalproject.data[i][3]);
					while(strToint>100||strToint<0){
						System.out.println("數值錯誤,請重新輸入!");
						System.out.println("輸入完成百分比:(輸入1~100之間的數)");
						finalproject.data[i][3] = keyboard.next();
						strToint = Integer.parseInt(finalproject.data[i][3]);
					}
				System.out.println("輸入狀態:(完成、執行中、未開始)");
				finalproject.data[i][4] = keyboard.next();
					while(!(finalproject.data[i][4].equals("完成")||finalproject.data[i][4].equals("執行中")||finalproject.data[i][4].equals("未開始"))){
						System.out.println("狀態錯誤,請重新輸入!");
						System.out.println("輸入狀態:(完成、執行中、未開始)");
						finalproject.data[i][4] = keyboard.next();
					}
				System.out.println("輸入編號:(以一個英文字母開頭,接著是五位數字)");
				finalproject.data[i][5] = keyboard.next();
				System.out.println("輸入分類:");
				finalproject.data[i][6] = keyboard.next();
				System.out.println("輸入工作內容:");
				finalproject.data[i][7] = keyboard.next();
			}
		}
	}
	
	public void deleteData(){		//刪除陣列
		Scanner keyboard = new Scanner(System.in);
		boolean flag = false;
		System.out.println("輸入欲刪除工作名稱:");
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
	
	public void showData(){	//顯示陣列
		for(int showi=0;showi<finalproject.num;showi++){
			if(finalproject.showName)
			System.out.print("工作名稱:"+finalproject.data[showi][0]);
			if(finalproject.showFinishtime)
			System.out.print(" 完成時間:"+finalproject.data[showi][1]);
			if(finalproject.showStarttime)
			System.out.print(" 開始時間:"+finalproject.data[showi][2]);
			if(finalproject.showPercent)
			System.out.print(" 完成百分比:"+finalproject.data[showi][3]);
			if(finalproject.showStatus)
			System.out.print(" 工作狀態:"+finalproject.data[showi][4]);
			if(finalproject.showNumber)
			System.out.print(" 工作編號:"+finalproject.data[showi][5]);
			if(finalproject.showSort)
			System.out.print(" 工作分類:"+finalproject.data[showi][6]);
			if(finalproject.showContent)
			System.out.print(" 工作內容:"+finalproject.data[showi][7]);
			System.out.print("\n");
			if(finalproject.setPartShow){
				if((((showi+1)%finalproject.partnumber)==0)&&(showi!=0))
					System.out.println("------------------------------\n");		
			}
		}	
	}
	
	public void showUnfinishedData(){//顯示未完成工作
		for(int u=0;u<finalproject.num;u++){
			if(finalproject.data[u][4].equals("完成")){}
			else{
				if(finalproject.showName)
				System.out.print("工作名稱:"+finalproject.data[u][0]);
				if(finalproject.showFinishtime)
				System.out.print(" 完成時間:"+finalproject.data[u][1]);
				if(finalproject.showStarttime)
				System.out.print(" 開始時間:"+finalproject.data[u][2]);
				if(finalproject.showPercent)
				System.out.print(" 完成百分比:"+finalproject.data[u][3]);
				if(finalproject.showStatus)
				System.out.print(" 工作狀態:"+finalproject.data[u][4]);
				if(finalproject.showNumber)
				System.out.print(" 工作編號:"+finalproject.data[u][5]);
				if(finalproject.showSort)
				System.out.print(" 工作分類:"+finalproject.data[u][6]);
				if(finalproject.showContent)
				System.out.print(" 工作內容:"+finalproject.data[u][7]);
				System.out.print("\n");
				if(finalproject.setPartShow){
					if((((u+1)%finalproject.partnumber)==0)&&(u!=0))
						System.out.println("------------------------------\n");		
				}
			}
		}		
	}
	
	public void setShowpartData(){//分頁顯示陣列
		Scanner keyboard = new Scanner(System.in);
		System.out.println("是否設定分頁顯示");
		System.out.println("是 : 輸入1 否 : 輸入2");
		int setShowpart = keyboard.nextInt();
		if(setShowpart==1){
			finalproject.setPartShow=true;
			System.out.println("輸入設定分頁顯示幾筆工作:(輸入數字)");
			finalproject.partnumber  = keyboard.nextInt();
		}
		else if(setShowpart==2){
			finalproject.setPartShow=false;
		}
		else
			System.out.println("輸入錯誤 回主選單!");
			
	}
	
	
	public void searchDataName(){	//查詢工作
		boolean find = false;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("輸入查詢工作名稱:");//查詢工作依名稱
		String searchname = keyboard.next();
		for(int s=0;s<finalproject.num;s++){
			if(finalproject.data[s][0].equals(searchname)){
				if(finalproject.showName)
				System.out.print("工作名稱:"+finalproject.data[s][0]);
				if(finalproject.showFinishtime)
				System.out.print(" 完成時間:"+finalproject.data[s][1]);
				if(finalproject.showStarttime)
				System.out.print(" 開始時間:"+finalproject.data[s][2]);
				if(finalproject.showPercent)
				System.out.print(" 完成百分比:"+finalproject.data[s][3]);
				if(finalproject.showStatus)
				System.out.print(" 工作狀態:"+finalproject.data[s][4]);
				if(finalproject.showNumber)
				System.out.print(" 工作編號:"+finalproject.data[s][5]);
				if(finalproject.showSort)
				System.out.print(" 工作分類:"+finalproject.data[s][6]);
				if(finalproject.showContent)
				System.out.print(" 工作內容:"+finalproject.data[s][7]);
				System.out.print("\n");
				find = true;
			}
		}			
		if(!find){
			System.out.println("無此工作");
		}
	
	}
	
	public void searchDataNumber(){	//查詢工作
		boolean find = false;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("輸入查詢工作編號:");//查詢工作依編號
		String searchname = keyboard.next();
		for(int s=0;s<finalproject.num;s++){
			if(finalproject.data[s][5].equals(searchname)){
				if(finalproject.showName)
				System.out.print("工作名稱:"+finalproject.data[s][0]);
				if(finalproject.showFinishtime)
				System.out.print(" 完成時間:"+finalproject.data[s][1]);
				if(finalproject.showStarttime)
				System.out.print(" 開始時間:"+finalproject.data[s][2]);
				if(finalproject.showPercent)
				System.out.print(" 完成百分比:"+finalproject.data[s][3]);
				if(finalproject.showStatus)
				System.out.print(" 工作狀態:"+finalproject.data[s][4]);
				if(finalproject.showNumber)
				System.out.print(" 工作編號:"+finalproject.data[s][5]);
				if(finalproject.showSort)
				System.out.print(" 工作分類:"+finalproject.data[s][6]);
				if(finalproject.showContent)
				System.out.print(" 工作內容:"+finalproject.data[s][7]);
				System.out.print("\n");
				find = true;
			}
		}			
		if(!find){
			System.out.println("無此工作");
		}
	
	}
	
	public void setshowData(){//設定部分顯示
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("  設定顯示欄位\n");//設定顯示或不顯示
		System.out.println("------------------------------\n");
		System.out.println("  輸入1 設定顯示欄位");
		System.out.println("  輸入2 設定不顯示欄位");
		int setshow = keyboard.nextInt();
		System.out.println("------------------------------\n");
		if(setshow==1){
			System.out.println("  輸入顯示欄位:\n");
			System.out.println("  顯示工作名稱   輸入1");
			System.out.println("  顯示完成時間   輸入2");
			System.out.println("  顯示開始時間   輸入3");
			System.out.println("  顯示完成百分比 輸入4");
			System.out.println("  顯示工作狀態   輸入5");
			System.out.println("  顯示工作編號   輸入6");
			System.out.println("  顯示工作分類   輸入7");
			System.out.println("  顯示工作內容   輸入8");
			System.out.println("  離開           輸入9");
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
			System.out.println("  輸入不顯示欄位:\n");
			System.out.println("  不顯示工作名稱   輸入1");
			System.out.println("  不顯示完成時間   輸入2");
			System.out.println("  不顯示開始時間   輸入3");
			System.out.println("  不顯示完成百分比 輸入4");
			System.out.println("  不顯示工作狀態   輸入5");
			System.out.println("  不顯示工作編號   輸入6");
			System.out.println("  不顯示工作分類   輸入7");
			System.out.println("  不顯示工作內容   輸入8");
			System.out.println("  離開             輸入9");
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
				default: System.out.println("輸入錯誤!!");
			}	
		}
		else
			System.out.println("輸入錯誤!!離開!!");
		
	}
	
	public void sortData(){		//設定陣列排序
		Scanner keyboard = new Scanner(System.in);
		System.out.println("\n設定依完成度由小到大顯示 請按1");
		System.out.println("\n設定依完成度由大到小顯示 請按2");
		int setsort = keyboard.nextInt();
		if(setsort==1){
			bubble_sort(true);
		}
		else if(setsort==2){
			bubble_sort(false);
		}
		else{
			System.out.println("輸入錯誤!!離開!!");
		}
		
	
	}
	
	public void bubble_sort(boolean isIncrease){ //氣泡排序（Bubble sort）
		String tempdata[]=new String[8];
		int n=0;
		for(int i=finalproject.num-1;i>0;i--){
			for(int k=0;k<i;k++){
				if((isIncrease&&Integer.parseInt(finalproject.data[k][3])>Integer.parseInt(finalproject.data[k+1][3]))||(!isIncrease&Integer.parseInt(finalproject.data[k][3])<Integer.parseInt(finalproject.data[k+1][3]))){ //遞增遞減判斷
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
	
	
	public void storeinTxt() throws IOException{	//把陣列存到txt
		PrintWriter outputStream = new PrintWriter(new FileOutputStream("個人工作.txt"));
				for(int c=0;c<finalproject.num;c++){
					outputStream.println(finalproject.data[c][0]+" "+finalproject.data[c][1]+" "+finalproject.data[c][2]+" "+finalproject.data[c][3]+" "+finalproject.data[c][4]
						+" "+finalproject.data[c][5]+" "+finalproject.data[c][6]+" "+finalproject.data[c][7]);
				}
		outputStream.close();
	}
	
	
	
	public void showUserMenu(){
		System.out.println("==============================");
		System.out.println("+++++++個人工作管理系統+++++++");
		System.out.println("==============================");
		System.out.println("     新增工作          請按1  ");
		System.out.println("     編輯工作          請按2  ");
		System.out.println("     刪除工作          請按3  ");
		System.out.println("     顯示全部工作      請按4  ");
		System.out.println("     查詢工作(名稱)    請按5  ");
		System.out.println("     查詢工作(編號)    請按6  ");
		System.out.println("     顯示未完成工作    請按7  ");
		System.out.println("     離開              請按0  ");
		System.out.println("==============================");
	}
	
	public void showMenu(){
		System.out.println("==============================");
		System.out.println("+++++++個人工作管理系統+++++++");
		System.out.println("==============================");
		System.out.println("     新增工作          請按1  ");
		System.out.println("     編輯工作          請按2  ");
		System.out.println("     刪除工作          請按3  ");
		System.out.println("     顯示全部工作      請按4  ");
		System.out.println("     查詢工作(名稱)    請按5  ");
		System.out.println("     查詢工作(編號)    請按6  ");
		System.out.println("     顯示未完成工作    請按7  ");
		System.out.println("     設定分頁顯示      請按8  ");
		System.out.println("     設定顯示欄位      請按9  ");
		System.out.println("     設定顯示順序      請按10 ");
		System.out.println("     離開              請按0  ");
		System.out.println("==============================");
	}
}