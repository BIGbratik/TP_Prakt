//Подключение класса для обеспечения ввода с клавиатуры
import java.util.Scanner;

public class Prakt3_6 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int choice;
		System.out.print("\n Введите номер задания (от 1 до 10), которое хотите выполнить - ");
		choice=in.nextInt();
		in.nextLine();
		
		switch (choice)
		{
			//Практическое задание 3.1
			case 1:
				int a,b,c;
				System.out.println("\n Введите значения A, B, C:");
				a=in.nextInt();
				b=in.nextInt();
				c=in.nextInt();
				in.nextLine();
				
				solutions(a,b,c);
				break;
		
			//Практическое задание 3.2
			case 2:
				String strZip;
				System.out.println("\n Введите строку:");
				strZip=in.nextLine();
				
				findZip(strZip);
				break;
				
			//Практическое задание 3.3
			case 3:
				int perfectNum;
				System.out.print("\n Введите ваше число: ");
				perfectNum=in.nextInt();
				in.nextLine();
				
				checkPerfect(perfectNum);
				break;
				
			//Практическое задание 3.4
			case 4:
				String strFlip;
				System.out.println("\n Введите вашу строку:");
				strFlip=in.nextLine();
				
				flipEndChars(strFlip);
				break;
				
			//Практическое задание 3.5
			case 5:
					break;
			
			//Практическое задание 3.6
			case 6:
				break;
				
			//Практическое задание 3.7
			case 7:
				break;
				
			//Практическое задание 3.8
			case 8:
				break;
				
			//Практическое задание 3.9
			case 9:
				break;
				
			//Практическое задание 3.10
			case 10:
				break;
					
			default:
				System.out.println(" Задания, номер которого вы ввели, не существует");
		}
	}
	
	//Метод, определяющий сколько решений имеет квадратное уравнение, исходя из переданных коэффициентов
	public static void solutions(int a,int b,int c)
	{
		double disc;
		disc=Math.pow(b, 2) - 4 * a * c;
		if (disc > 0)
			System.out.println("Уравнение с данными коэффициентами имеет 2 решения");
		else if (disc == 0)
			System.out.println("Уравнение с данными коэффициентами имеет 1 решение");
		else
			System.out.println("Уравнение с данными коэффициентами не имеет  решений");
	}
	
	//Метод, определяющий второе вхождение подстроки "zip" в строку
	public static void findZip(String strZip)
	{
		int indexZip1, indexZip2;
		indexZip1=strZip.indexOf("zip");
		strZip=strZip.substring(indexZip1+3);
		indexZip2=strZip.indexOf("zip");
		if (indexZip2!=-1)
				System.out.println("Индекс второго вхождения 'zip' в указанной строке: "
						+(indexZip2+indexZip1+3+1));
		else
			System.out.println("Индекс второго вхождения 'zip' в указанной строке: "
					+indexZip2);
	}
	
	//Метод, определяющий явлется ли число совершенным
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

	//Метод, изменяющий первый и последний символы в строке
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
