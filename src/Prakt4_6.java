import java.util.Scanner;

public class Prakt4_6 
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
				int n,k;
				System.out.print("Введите кол-во слов в эссэ: ");
				n=in.nextInt();
				System.out.print("Введите кол-во символов в строке: ");
				k=in.nextInt();
				in.nextLine();
				System.out.println("Введите строку для обработки: ");
				String str = new String();
				str=in.nextLine();
				
				Esse(n,k,str);
				break;
		
			//Практическое задание 1.2
			case 2:
				String skobki = new String();
				System.out.println("Введите строку скобок");
				in.nextLine();
				skobki=in.nextLine();
				
				split(skobki);

				break;
				
			//Практическое задание 1.3
			case 3:

				break;
				
			//Практическое задание 1.4
			case 4:

				break;
				
			//Практическое задание 1.5
			case 5:

				break;
			
			//Практическое задание 1.6
			case 6:

				break;
				
			//Практическое задание 1.7
			case 7:

				break;
				
			//Практическое задание 1.8
			case 8:

				break;
				
			//Практическое задание 1.9
			case 9:

				break;
				
			//Практическое задание 1.10
			case 10:
				break;
			default:
				System.out.println(" Задания, номер которого вы ввели, не существует");
		}
	}
	
	//Метод обработки стркои Бесси
	public static void Esse (int n, int k, String str)
	{
		int currentK = 0;
		int currentN = 0;
		
		String[] naborSlov = str.split(" ");
		String resStr = new String();
		resStr = "";
		for (int i = 0 ; i<naborSlov.length; i++)
		{
			currentN+=1;
			if (currentN<=n)
			{
				if ((currentK + naborSlov[i].length())< k)
				{
					resStr+=naborSlov[i]+" ";
					currentK+=naborSlov[i].length();
				}
				else
				{
					resStr+="\n" + naborSlov[i]+" ";
					currentK=naborSlov[i].length();
				}

			}
			else
			{
				System.out.println("Кол-во слов превысилов введённый максимум (n)!!!");
				resStr+=" (!!!далее слова не влезли!!!)";
				break;
			}
		}
		System.out.println("Полученная отформатированная строка:\n"+resStr);
	}

	//Метод разбиения строки скобок на подсткрои с группами открывающих-закрывающих скобок
	public static void split (String str)
	{
		int open = 0;
		int close = 0;
		int groupe = 0;
		
		System.out.println("Результат:");
		for (int i = 0; i<str.length();i++)
		{
			if (str.charAt(i)=='(')
				groupe+=1;
			else
				groupe-=1;
			if (groupe == 0)
			{
				close=i+1;
				System.out.println(str.substring(open, close));
				open=close;
			}
		}
	}
}
