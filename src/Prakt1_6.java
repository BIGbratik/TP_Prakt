//Подключение класса для обеспечения ввода с клавиатуры
import java.util.Scanner;


public class Prakt1_6 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int choice;
		System.out.println("\nВведите номер задания (от 1 до 10), которое хотите выполнить -");
		choice=in.nextInt();
		
		switch (choice)
		{
			//Практическое задание 1.1
			case 1:
				double div_d, div_r, rem;
				
				System.out.println("\nВведите делимое и делитель (если вводите с плавающей точкой - вводите с запятой !!!)");
				System.out.println("\nДелимое - ");
				div_d=in.nextDouble();
				System.out.println("\nДелитель - ");
				div_r=in.nextDouble();
				
				rem=remOfDiv(div_d,div_r);
				System.out.printf("\nОстаток от деления - %f",rem);
				break;
		
			//Практическое задание 1.2
			case 2:
				double foot, height, area;
				
				System.out.println("\nВведите значения основания и высоты (если вводите с плавающей точкой - вводите с запятой !!!)");
				System.out.println("\nОснование - ");
				foot=in.nextDouble();
				System.out.println("\nВысота - ");
				height=in.nextDouble();
				
				area=areaTriang(foot,height);
				System.out.println("\nПлощадь треугольника - " + area);
				break;
				
			//Практическое задание 1.3
			case 3:
				int chickens, cows, pigs,count;
				
				System.out.println("\nВведите кол-во животных:");
				System.out.println("\n Кол-во кур - ");
				chickens=in.nextInt();
				System.out.println("\n Кол-во коров - ");
				cows=in.nextInt();
				System.out.println("\n Кол-во свиней - ");
				pigs=in.nextInt();
				
				count=countLegs(chickens,cows,pigs);
				System.out.println("\nОбщее кол-во ног в амбаре - " + count);
				break;
				
			//Практическое задание 1.4
			case 4:
				double prob,price,pay;
				boolean profit;
				
				System.out.println("\nВведите параметры сделки:");
				System.out.println("\n Prob - ");
				prob=in.nextDouble();
				System.out.println("\n Price - ");
				price=in.nextDouble();
				System.out.println("\n Pay - ");
				pay=in.nextDouble();
				profit=profitableGamble(prob, price, pay);
				System.out.println("\nПофитность сделки - " + profit);
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
}
