
import java.util.Arrays;
import java.util.Scanner;

public class Prakt2_6 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int choice;
		System.out.println("\n Введите номер задания (от 1 до 10), которое хотите выполнить -");
		choice=in.nextInt();
		
		switch (choice)
		{
			//Практическое задание 2.1
			case 1:
				String str = new String();
				int k;
				
				System.out.println("\n Введите строку для обработки:");
				str=in.next();
				System.out.println("\n Введите число раз, которе необходимо повторять символы:");
				k=in.nextInt();
				
				String strNew = new String();
				strNew=repeat(str,k);
				System.out.println("\n Итоговая обработанная строка - "+strNew);				
				break;
		
			//Практическое задание 2.2
			case 2:
				int n1;
				int[] arrayOfNums1;
				System.out.println("\n Введите число элементов в массиве для обработки:");
				n1=in.nextInt();
				arrayOfNums1=new int[n1];
				System.out.println("Вводите числа для массива: ");
				for (int i=0; i<n1;i++)
				{
					arrayOfNums1[i]=in.nextInt();
				}
				
				differMaxMin(arrayOfNums1);
				break;
				
			//Практическое задание 2.3
			case 3:
				int n2;
				int[] arrayOfNums2;
				System.out.println("\n Введите число элементов в массиве для обработки:");
				n2=in.nextInt();
				arrayOfNums2=new int[n2];
				System.out.println("Вводите числа для массива: ");
				for (int i=0; i<n2;i++)
				{
					arrayOfNums2[i]=in.nextInt();
				}
				
				isAvgWhole(arrayOfNums2);
				break;
				
			//Практическое задание 2.4
			case 4:
				int n3;
				int[] arrayOfNums3;
				System.out.println("\n Введите число элементов в массиве для обработки:");
				n3=in.nextInt();
				arrayOfNums3=new int[n3];
				System.out.println("Вводите числа для массива: ");
				for (int i=0; i<n3;i++)
				{
					arrayOfNums3[i]=in.nextInt();
				}
				
				cumulativeSum(arrayOfNums3);
				break;
				
			//Практическое задание 2.5
			case 5:
				break;
			
			//Практическое задание 2.6
			case 6:
				break;
				
			//Практическое задание 2.7
			case 7:
				break;
				
			//Практическое задание 2.8
			case 8:
				break;
				
			//Практическое задание 2.9
			case 9:
				break;
				
			//Практическое задание 2.10
			case 10:
				break;
					
			default:
				System.out.println(" Задания, номер которого вы ввели, не существует");
		}
	}	
	
	//Метод, повторяющий каждый символ строки k-раз
	public static String repeat(String s, int k)
	{
		String sNew = new String();
		int l = s.length();
		char ch;
		
		for (int i = 0; i < l; i++)
		{
			ch=s.charAt(i);
			for (int j = 0; j < k; j++)
			{
				sNew=sNew+ch;
			}
		}
		
		return sNew;
	}
	
	//Метод, находящий минимальное и максимальное числа в массиве и выводящий разницу между ними
	public static void differMaxMin (int[] mas)
	{
		int n = mas.length;
		int max=mas[0];
		int min=mas[0];
		
		if (n>1)
		{
			for (int i = 1; i < n; i++)
			{
				if (max<mas[i])
				{
					max=mas[i];
				}
				
				if (min>mas[i])
				{
					min=mas[i];
				}
			}
			System.out.println("\n MAX число в массиве " + max + " , а MIN число в массиве " + min + 
					"\n Разница между MIN и MAX числами массива - " + (max-min));
		}
		else
		{
			System.out.println("\n MAX число в массиве " + max + " , а MIN число в массиве " + min + 
					"\n Разница между MIN и MAX числами массива - " + (max-min));
		}
	}
	
	//Метод, определяющий, является ли среднее значение массива целым числом
	public static void isAvgWhole(int[] mas)
	{
		boolean isWhole;
		int n = mas.length;
		int sum = 0;
		for(int i = 0; i < n; i++)
		{
			sum+=mas[i];
		}
		isWhole=(sum % n) == 0;
		System.out.println(isWhole);
	}
	
	//Метод, обрабатывающий введённый массив так, что каждый элемент тановится суммой предыдущих и его самого
	public static void cumulativeSum(int[] mas)
	{
		int n = mas.length;
		for (int i = n-1; i >= 0; i--)
		{
			for (int j = 0; j < i; j++)
			{
				mas[i]+=mas[j];
				System.out.println(mas[i]);
			}
		}
		System.out.println(Arrays.toString(mas));
	}
}
