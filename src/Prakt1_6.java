//Подключение класса для обеспечения ввода с клавиатуры
import java.util.Scanner;


public class Prakt1_6 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int choice;
		System.out.println("\n Введите номер задания (от 1 до 10), которое хотите выполнить -");
		choice=in.nextInt();
		
		switch (choice)
		{
			//Практическое задание 1.1
			case 1:
				double div_d, div_r, rem;
				
				System.out.println("\n Введите делимое и делитель (если вводите с плавающей точкой - вводите с запятой !!!)");
				System.out.println("\n Делимое - ");
				div_d=in.nextDouble();
				System.out.println("\n Делитель - ");
				div_r=in.nextDouble();
				
				rem=remOfDiv(div_d,div_r);
				System.out.printf("\n Остаток от деления - %f",rem);
				break;
		
			//Практическое задание 1.2
			case 2:
				double foot, height, area;
				
				System.out.println("\n Введите значения основания и высоты (если вводите с плавающей точкой - вводите с запятой !!!)");
				System.out.println("\n Основание - ");
				foot=in.nextDouble();
				System.out.println("\n Высота - ");
				height=in.nextDouble();
				
				area=areaTriang(foot,height);
				System.out.println("\n Площадь треугольника - " + area);
				break;
				
			//Практическое задание 1.3
			case 3:
				int chickens, cows, pigs,count;
				
				System.out.println("\n Введите кол-во животных:");
				System.out.println("\n Кол-во кур - ");
				chickens=in.nextInt();
				System.out.println("\n Кол-во коров - ");
				cows=in.nextInt();
				System.out.println("\n Кол-во свиней - ");
				pigs=in.nextInt();
				
				count=countLegs(chickens,cows,pigs);
				System.out.println("\n Общее кол-во ног в амбаре - " + count);
				break;
				
			//Практическое задание 1.4
			case 4:
				double prob,price,pay;
				boolean profit;
				
				System.out.println("\n Введите параметры сделки:");
				System.out.println("\n Prob - ");
				prob=in.nextDouble();
				System.out.println("\n Price - ");
				price=in.nextDouble();
				System.out.println("\n Pay - ");
				pay=in.nextDouble();
				
				profit=profitableGamble(prob, price, pay);
				System.out.println("\n Пофитность сделки - " + profit);
				break;
				
			//Практическое задание 1.5
			case 5:
				double N,a,b;
				String operation;
					
				System.out.println("\n Введите числа для проверки:");
				System.out.println("\n Число-результат (N) - ");
				N=in.nextDouble();
				System.out.println("\n Первое число (a) - ");
				a=in.nextDouble();
				System.out.println("\n Второе число (b) - ");
				b=in.nextDouble();
				
				operation=operations(N, a, b);
				System.out.println("\n Необхожимая операция - " + operation);
				break;
					
			default:
				System.out.println("Задания, номер которого вы ввели, не существует");
		}
	}
	
	//Метод, выводящий остаток от деления параметров
	public static double remOfDiv (double divined, double divider)
	{
		double rem;
		rem=divined%divider;
		return rem;
	}
	
	//Метод, выводящий площадь треугольника (по высоте и основанию)
	public static double areaTriang (double footing, double height)
	{
		double area;
		area=(footing*height)/2;
		return area;
	}
	
	//Метод, подсчитывающий общее кол-во ног в амбаре
	public static int countLegs(int chickens, int cows, int pigs)
	{
		int count;
		count = chickens*2+cows*4+pigs*4;
		return count;
	}
	
	//Метод, высчитывающий профитность условий
	public static boolean profitableGamble(double prob, double price, double pay)
	{
		boolean profit;
		if (prob*price>pay)
		{
			profit=true;
		}
		else
		{
			profit=false;
		}
		return profit;
	}
	
	//Метод, возвращающий название операции, которую нужно совершить над переданным вторым и третьим параметром, чтобы получить первый
	public static String operations(double N, double a, double b)
	{
		String oper;
		if (a+b==N)
		{
			oper="Summ (Сложение)";
		}
		else
		{
			if (a-b==N)
			{
				oper="Subtration (Вычитание)";
			}
			else
			{
				if (a*b==N)
				{
					oper="Multiplication (Умножение)";
				}
				else
				{
					if (a/b==N)
					{
						oper="Division (Деление)";
					}
					else
					{
						oper="None (Нет подходящей простой операции)";
					}
				}
			}
		}
		return oper;
	}
}
