//����������� ������ ��� ����������� ����� � ����������
import java.util.Scanner;

public class Prakt3_6 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int choice;
		System.out.print("\n ������� ����� ������� (�� 1 �� 10), ������� ������ ��������� - ");
		choice=in.nextInt();
		in.nextLine();
		
		switch (choice)
		{
			//������������ ������� 3.1
			case 1:
				int a,b,c;
				System.out.println("\n ������� �������� A, B, C:");
				a=in.nextInt();
				b=in.nextInt();
				c=in.nextInt();
				in.nextLine();
				
				solutions(a,b,c);
				break;
		
			//������������ ������� 3.2
			case 2:
				String strZip;
				System.out.println("\n ������� ������:");
				strZip=in.nextLine();
				
				findZip(strZip);
				break;
				
			//������������ ������� 3.3
			case 3:
				int perfectNum;
				System.out.print("\n ������� ���� �����: ");
				perfectNum=in.nextInt();
				in.nextLine();
				
				checkPerfect(perfectNum);
				break;
				
			//������������ ������� 3.4
			case 4:
				String strFlip;
				System.out.println("\n ������� ���� ������:");
				strFlip=in.nextLine();
				
				flipEndChars(strFlip);
				break;
				
			//������������ ������� 3.5
			case 5:
					break;
			
			//������������ ������� 3.6
			case 6:
				break;
				
			//������������ ������� 3.7
			case 7:
				break;
				
			//������������ ������� 3.8
			case 8:
				break;
				
			//������������ ������� 3.9
			case 9:
				break;
				
			//������������ ������� 3.10
			case 10:
				break;
					
			default:
				System.out.println(" �������, ����� �������� �� �����, �� ����������");
		}
	}
	
	//�����, ������������ ������� ������� ����� ���������� ���������, ������ �� ���������� �������������
	public static void solutions(int a,int b,int c)
	{
		double disc;
		disc=Math.pow(b, 2) - 4 * a * c;
		if (disc > 0)
			System.out.println("��������� � ������� �������������� ����� 2 �������");
		else if (disc == 0)
			System.out.println("��������� � ������� �������������� ����� 1 �������");
		else
			System.out.println("��������� � ������� �������������� �� �����  �������");
	}
	
	//�����, ������������ ������ ��������� ��������� "zip" � ������
	public static void findZip(String strZip)
	{
		int indexZip1, indexZip2;
		indexZip1=strZip.indexOf("zip");
		strZip=strZip.substring(indexZip1+3);
		indexZip2=strZip.indexOf("zip");
		if (indexZip2!=-1)
				System.out.println("������ ������� ��������� 'zip' � ��������� ������: "
						+(indexZip2+indexZip1+3+1));
		else
			System.out.println("������ ������� ��������� 'zip' � ��������� ������: "
					+indexZip2);
	}
	
	//�����, ������������ ������� �� ����� �����������
	public static void checkPerfect(int perfectNum)
	{
		int sum=0;
		for (int i = 1; i < perfectNum; i++)
		{
			if (perfectNum % i == 0)
				sum+=i;
		}
		System.out.println(" "+(sum==perfectNum));
	}

	//�����, ���������� ������ � ��������� ������� � ������
	public static void flipEndChars(String strFlip)
	{
		if (strFlip.length()>1)
		{
			if (strFlip.charAt(0)!=strFlip.charAt(strFlip.length()-1))
			{
				System.out.println("\n"+strFlip.charAt(strFlip.length()-1)
				+strFlip.substring(1, strFlip.length()-1)+strFlip.charAt(0));
			}
			else
			{
				System.out.println("\n Two's a pair!!!");
			}
		}
		else
		{
			System.out.println("\n Incompatible!!!");
		}
	}
}
