package lottery;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
class SingleChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("SingleChoose", new SingleChoose());
	}
	@Override
	public int getwinLevel() {
		// TODO Auto-generated method stub
		boolean same=true;
		for(int i=0;i<3;i++) {
			if(winNum[i]!=inputNum[i]){
				same=false;
				break;
				}
		}
		if(same)
			return 1040;
		else
			return 0;
		
	}
	
}
class GroupChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("GroupChoose", new GroupChoose());
	}
	@Override
	public boolean getInput() {
		System.out.println("请输入0-999之间的整数");
		Scanner s=new Scanner(System.in);
		int inputnum=s.nextInt();
		if (inputnum<1000&&inputnum>=0) {				
			inputNum=new int[3];
			numsplit(inputnum,inputNum);
			if(inputNum[0]==inputNum[1]&&inputNum[1]==inputNum[2])
				return false;
			else {
				return true;
			}
		}
		else
			return false;	
	}
	@Override
	public int getwinLevel() {
		int count=0;
		for(int i=0,j=0;i<3;i++)
		{
			if(count==3)
				break;
			if(inputNum[i]==winNum[j])
				{
					count++;j++;
					inputNum[i]=-1;
					i=-1;
				}
		}	
		if(count==3)
		{
			if(winNum[0]==winNum[1]||winNum[1]==winNum[2]||winNum[0]==winNum[2])
				return 346;
			else {
				return 173;
			}
		}
		return 0;
	}
}
class OneDChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("OneDChoose", new OneDChoose());
	}
	char[] inputChar;
	@Override
	public boolean getInput() {
		System.out.println("请输入确定位置的一个数字，其他位输入*，例如，如果确定个位数为2，请输入**2");
		Scanner s=new Scanner(System.in);
		String inputnum=s.nextLine();
		inputnum =inputnum.replaceAll(" ", "");
		if (inputnum.length()!=3)
			return false;
		inputChar=new char[3];
		int starcount=0;
		for(int i=0;i<3;i++) {
	//只能输入数字或者*	
			char temp=inputnum.charAt(i);
			if((temp>='0'&&temp<='9')||temp=='*') {
				inputChar[i]=temp;
				if(temp=='*')
					starcount++;
			}
			else
				return false;
		}
		if (starcount==2)
			return true;
		else
			return false;
		
	}
	@Override
	public int getwinLevel() {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++) {
			if(inputChar[i]!='*' && winNum[i]+'0'==inputChar[i])
				return 10;
		}
		return 0;
		
	}
	
}
class GuessOneD extends Lottery3D{
	static {
		Lottery3D.playList.put("GuessOneD", new GuessOneD());
	}
	int n;
	public boolean getInput() {
		System.out.println("请输入一个数字");
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		if(n<0||n>9)
			return false;
		return true;
	}
	@Override
	public int getwinLevel() {
		int count=0;
		for(int i=0;i<3;i++)
		{
			if(winNum[i]==n)
				count++;
		}
		if(count==1)
			return 2;
		if(count==2)
			return 12;
		if(count==3)
			return 230;
		return 0;
	}
}
class TwoD extends Lottery3D{
	static {
		Lottery3D.playList.put("TwoD", new TwoD());
	}
	char[] inputChar;
	@Override
	public boolean getInput() {
		System.out.println("请输入确定位置的2个数字，其他位输入*，例如，如果确定百位数为1，个位数为2，请输入*12");
		Scanner s=new Scanner(System.in);
		String inputnum=s.nextLine();
		inputnum =inputnum.replaceAll(" ", "");
		if (inputnum.length()!=3)
			return false;
		inputChar=new char[3];
		int starcount=0;
		for(int i=0;i<3;i++) {
	//只能输入数字或者*	
			char temp=inputnum.charAt(i);
			if((temp>='0'&&temp<='9')||temp=='*') {
				inputChar[i]=temp;
				if(temp=='*')
					starcount++;
			}
			else
				return false;
		}
		if (starcount==1)
			return true;
		else
			return false;
		
	}
	@Override
	public int getwinLevel() {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0;i<3;i++) {
			if(inputChar[i]!='*' && winNum[i]+'0'==inputChar[i])
				count++;
		}
		if(count==2||count==3)
			return 104;
		return 0;
		
	}
}
class GuessTwoD extends Lottery3D{
	static {
		Lottery3D.playList.put("GuessTwoD",new GuessTwoD());
	}
	int[]inputnum;
	@Override
	public boolean getInput() {
		System.out.println("请输入两个数字");
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
		input =input.replaceAll(" ", "");
		if (input.length()!=2)
			return false;
		inputnum=new int[2];
		inputnum[0]=input.charAt(0)-'0';
		inputnum[1]=input.charAt(1)-'0';
		return true;
	}
	@Override
	public int getwinLevel() {
		int count=0;
		if(inputnum[0]==inputnum[1])
		{
			for(int i=0;i<3;i++)
				if(winNum[i]==inputnum[0])
					count++;
			if(count==2||count==3)
				return 37;
		}
		else {
			for(int i=0;i<3;i++)
			{
				if(winNum[i]==inputnum[0])
					count++;
				if(winNum[i]==inputnum[1])
					count++;
			}
			if(count==2||count==3)
				return 19;
		}
		return 0;
	}
}
class AllChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("AllChoose",new AllChoose());
	}
	@Override
	public int getwinLevel() {
		// TODO 自动生成的方法存根
		int count=0;
		for(int i=0;i<3;i++) {
			if(winNum[i]==inputNum[i]){
				count++;
				}
		}
		if(count==3)
			return 470;
		if(count==2)
			return 21;
		return 0;
	}
}
class GuessSum extends Lottery3D{
	static {
		Lottery3D.playList.put("GuessSum",new GuessSum());
	}
	int n;
	public boolean getInput() {
		System.out.println("请输入一个数字");
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		if(n<0||n>27)
			return false;
		return true;
	}
	@Override
	public int getwinLevel() {
		// TODO 自动生成的方法存根
		int temp=0;
		for(int i=0;i<3;i++)
			temp+=winNum[i];
		if(n==temp)
		{
			if(temp==0||temp==27)
				return 1040; 
			if(temp==1||temp==26)
				return 345; 
			if(temp==2||temp==25)
				return 172; 
			if(temp==3||temp==24)
				return 104; 
			if(temp==4||temp==23)
				return 69; 
			if(temp==5||temp==22)
				return 49; 
			if(temp==6||temp==21)
				return 37; 
			if(temp==7||temp==20)
				return 29; 
			if(temp==8||temp==19)
				return 23; 
			if(temp==9||temp==18)
				return 19; 
			if(temp==10||temp==17)
				return 16; 
			if(temp==11||temp==16)
				return 15; 
			if(temp==12||temp==15)
				return 15; 
			if(temp==13||temp==14)
				return 14; 
		}
		return 0;
	}
}
class BagChoose extends Lottery3D{
	static {
		Lottery3D.playList.put("BagChoose",new BagChoose());
	}
	@Override
	public boolean getInput() {
		// TODO 自动生成的方法存根
		System.out.println("请输入0-999之间的整数");
		Scanner s=new Scanner(System.in);
		int inputnum=s.nextInt();
		if (inputnum<1000&&inputnum>=0) {				
			inputNum=new int[3];
			numsplit(inputnum,inputNum);
			if(inputNum[0]==inputNum[1]&&inputNum[1]==inputNum[2])
				return false;
			else {
				return true;
			}
		}
		else
			return false;	
	}
	@Override
	public int getwinLevel() {
		// TODO 自动生成的方法存根
		int count=0;
		if(inputNum[0]==inputNum[1]||inputNum[1]==inputNum[2]||inputNum[0]==inputNum[2])
		{
			for(int i=0;i<3;i++)
			{
				if(inputNum[i]==winNum[i])
					count++;
			}
			if(count==3)
				return 693;
			if(count!=3)
			{
				count=0;
				for(int i=0,j=0;i<3;i++)
				{
					if(count==3)
						break;
					if(inputNum[i]==winNum[j])
					{
						count++;j++;
						inputNum[i]=-1;
						i=-1;
					}
					if(count==3)
						return 173;
				}
			}
		}
		else {
			for(int i=0;i<3;i++)
			{
				if(inputNum[i]==winNum[i])
					count++;
			}
			if(count==3)
				return 606;
			if(count!=3)
			{
				count=0;
				for(int i=0,j=0;i<3;i++)
				{
					if(count==3)
						break;
					if(inputNum[i]==winNum[j])
					{
						count++;j++;
						inputNum[i]=-1;
						i=-1;
					}
					if(count==3)
						return 86;
				}
			}
		}
		
		return 0;
	}
}
class BigorSmall extends Lottery3D{
	static {
		Lottery3D.playList.put("BigorSmall",new BigorSmall());
	}
	char gue;
	@Override
	public boolean getInput() {
		// TODO 自动生成的方法存根
		System.out.println("请输入大或者小");
		Scanner s=new Scanner(System.in);
		gue=s.next().charAt(0);
		if(gue=='大'||gue=='小')
			return true;
		return false;
	}
	@Override
	public int getwinLevel() {
		int temp=0;
		for(int i=0;i<3;i++)
		{
			temp+=winNum[i];
		}
		if(gue=='大')
			if(temp>=19)
				return 6;
		if(gue=='小')
			if(temp<=8)
				return 6;
		return 0;
	}
}
class ThreeSame extends Lottery3D{
	static {
		Lottery3D.playList.put("ThreeSame",new ThreeSame());
	}
	char gue;
	@Override
	public boolean getInput() {
		System.out.println("请输入是或者否");
		Scanner s=new Scanner(System.in);
		gue=s.next().charAt(0);
		if(gue=='是'||gue=='否')
			return true;
		return false;
	}
	@Override
	public int getwinLevel() {
		// TODO 自动生成的方法存根
		if(winNum[0]==winNum[1]&&winNum[1]==winNum[2])
			{if(gue=='是')
				return 104;
			}
		else {
			if(gue=='否')
				return 104;
		}
		return 0;
	}
}
class Tractor extends Lottery3D{
	static {
		Lottery3D.playList.put("Tractor",new Tractor());
	}
	char gue;
	@Override
	public boolean getInput() {
		// TODO 自动生成的方法存根
		System.out.println("请输入是或者否");
		Scanner s=new Scanner(System.in);
		gue=s.next().charAt(0);
		if(gue=='是'||gue=='否')
			return true;
		return false;
	}
	@Override
	public int getwinLevel() {
		// TODO 自动生成的方法存根
		boolean flag=false;
		if(winNum[0]<winNum[1]&&winNum[1]<winNum[2])
			flag=true;
		if(winNum[0]>winNum[1]&&winNum[1]>winNum[2])
			flag=true;
		if(flag)
		{
			if(winNum[0]==8&&winNum[1]==9&&winNum[2]==0)
				flag=false;
			if(winNum[0]==0&&winNum[1]==9&&winNum[2]==8)
				flag=false;
			if(winNum[0]==9&&winNum[1]==0&&winNum[2]==1)
				flag=false;
			if(winNum[0]==1&&winNum[1]==0&&winNum[2]==9)
				flag=false;
		}
		if(flag)
		{
			if(gue=='是')
				return 65;
		}
		else {
			if(gue=='否')
				return 65;
		}
		return 0;
	}
}
class OddorEven extends Lottery3D{
	static {
		Lottery3D.playList.put("OddorEven",new OddorEven());
	}
	char gue;
	@Override
	public boolean getInput() {
		// TODO 自动生成的方法存根
		System.out.println("请输入奇或者偶");
		Scanner s=new Scanner(System.in);
		gue=s.next().charAt(0);
		if(gue=='奇'||gue=='偶')
			return true;
		return false;
	}
	@Override
	public int getwinLevel() {
		// TODO 自动生成的方法存根
		int count=0;
		for(int i=0;i<3;i++)
		{
			if(winNum[i]%2==0)
				count++;
		}
		if(gue=='奇')
			if(count==0)
				return 8;
		if(gue=='偶')
			if(count==3)
				return 8;
		return 0;
	}
}
class Lottery3DManager{
	public static boolean checkPlayList(String playName) {
		Lottery3D temp=Lottery3D.playList.get(playName);
		if (temp==null) {
			try {
			Class.forName("lottery."+playName);//注意固定的包名，也可以设置配置文件，从配置文件里面获取
			return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		return true;
	}
}
public abstract class Lottery3D {

	int [] winNum;
	int [] inputNum;
	protected static Map<String,Lottery3D> playList=new HashMap();
	public void setWinNum(int [] winNum) {
		this.winNum=winNum;
	}
	public static void numsplit(int num,int [] t) {
		t[2]=num %10 ;
		t[1]=(num/10)%10;
		t[0]=(num/100);
	}
	public void randwinNum() {
		Random rd=new Random();
		winNum=new int[3];
		numsplit(rd.nextInt(1000),winNum);
	}
	public void printWinNum() {
		System.out.print("中奖号为：");
		for(int num:winNum) {
			System.out.print(num+" ");
		}
		System.out.println();
	}
	public boolean getInput() {
		System.out.println("请输入0-999之间的整数");
		Scanner s=new Scanner(System.in);
		int inputnum=s.nextInt();
		if (inputnum<1000&&inputnum>=0) {
			inputNum=new int[3];
			numsplit(inputnum,inputNum);
			return true;
		}
		else
			return false;	
		
	}
	public abstract int getwinLevel();
	public static void main(String[] arg) {
		Scanner sin = new Scanner(System.in);
		System.out.println("请输入投注方式");
		System.out.println("可供选择的投注方式为 'SingleChoose','GroupChoose','OneDChoose','GuessOneD','TwoD',");
		System.out.println("'GuessTwoD','AllChoose','GuessSum','BagChoose','BigorSmall','ThreeSame','Tractor','OddorEven'");
		while(sin.hasNext()) {
			String playtype=sin.nextLine();
			if(Lottery3DManager.checkPlayList(playtype)) {
				Lottery3D temp=Lottery3D.playList.get(playtype);
				temp.randwinNum();
				temp.printWinNum();				
				while(true) {
					if(temp.getInput()) {
						System.out.println("您获得的奖金为"+temp.getwinLevel());
						break;
					}
					else{
						System.out.println("请输入正确的投注内容");
					}
				}
			}
			else {
				System.out.println("您输入的投注方式不存在，请重新输入");
			}
			System.out.println("请输入投注方式");
		}
	}
}
