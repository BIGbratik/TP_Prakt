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
				int choseStyle=0;
				System.out.print("Выберите в какой стиль будет преобразовываться строка (1 - змея; 2 - верблюд): ");
				choseStyle=in.nextInt();
				String name = new String();
				System.out.print("Введите строку для обработки: ");
				in.nextLine();
				name=in.nextLine();
				if (choseStyle==1)
					toSnakeCase(name);
				else
					toCamelCase(name);

				break;
				
			//Практическое задание 1.4
			case 4:
				double jobStart, jobStop, jobPay, jobPayKoef;
				System.out.print("Введите начало рабочего дня - ");
				jobStart = in.nextDouble();
				System.out.print("Введите конец рабочего дня - ");
				jobStop = in.nextDouble();
				System.out.print("Введите ставку - ");
				jobPay= in.nextDouble();
				System.out.print("Введите коэффициент надбавки - ");
				jobPayKoef = in.nextDouble();
				
				overTime(jobStart, jobStop, jobPay, jobPayKoef);
				break;
				
			//Практическое задание 1.5
			case 5:
				String weight=new String();
				String height = new String();
				
				in.nextLine();
				System.out.println("Далее введите вес и рост (число + пробел + код меры измерения). Числа вводите с точкой. \nТип данных обозначить одной буквой (кг - k, фунты - p, метры - m, дюймы - i)");
				System.out.print("Вес - ");
				weight=in.nextLine();
				System.out.print("Рост - ");
				height=in.nextLine();
				
				BMI(weight,height);

				break;
			
			//Практическое задание 1.6
			case 6:
				int num;
				System.out.print("Введите число - ");
				num=in.nextInt();
				
				bugger(num);

				break;
				
			//Практическое задание 1.7
			case 7:
				String starStr = new String();
				in.nextLine();
				System.out.print("Введите строку для обработки: ");
				starStr=in.nextLine();
				
				toStarShorthand(starStr);

				break;
				
			//Практическое задание 1.8
			case 8:
				String str1 = new String();
				String str2 = new String();
				in.nextLine();
				System.out.print("Введите первую строку для сравнения: ");
				str1=in.nextLine();
				System.out.print("Введите вторую строку для сравнения: ");
				str2=in.nextLine();
				
				doesRhyme(str1,str2);

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

	//Метод перевода в Snake
	public static void toSnakeCase (String str)
	{
		String strRes = new String();
		strRes="";
		int start = 0;
		int stop = 0;
		
		for (int i=0; i<str.length();i++)
		{
			if (Character.isUpperCase(str.charAt(i)))
			{
				stop=i;
				if (start==0)
				{
					strRes+=str.substring(start,stop);
				}
				else
				{
					strRes+="_"+Character.toLowerCase(str.charAt(start))+str.substring(start+1,stop);
				}
			}
			start=stop;
		}
		if (start != 0) 
			strRes += "_"+Character.toLowerCase(str.charAt(start)) + str.substring(start + 1);
		System.out.println("Результат: "+strRes);
		
	}
	
	//Метод перевода в Camel
	public static void toCamelCase(String str)
	{
		String[] strSplit = str.split("_");
		String strRes = new String();
		strRes=strSplit[0];
		
		for (int i=1; i<strSplit.length;i++)
		{
			strRes+=strSplit[i].substring(0,1).toUpperCase()+strSplit[i].substring(1);
		}
		System.out.print("Результат: "+strRes);
	}

	//Метод рассчёта з.п. сотрудника за день
	public static void overTime(double Start, double Stop, double Pay, double Koef)
	{
		double pay = 0;
		
		if ((Start<17)&&(Stop<=17))
			pay+=(Stop-Start)*Pay;
		else if ((Start>17)&&(Stop>17))
			pay+=(Stop-Start)*Pay*Koef;
		else
			pay+=(17-Start)*Pay+(Stop-17)*Pay*Koef;
		System.out.println("Заработок за день составил: "+(int)pay+"."+(int)(Math.round((pay%1)*100))+"$");
		
	}

	//Метод рассчёта индекса массы тела
	public static void BMI(String weight, String height)
	{

		double w=0,h=0;
		String[] strW=weight.split(" ");
		String[] strH=height.split(" ");
		
		if (strW[1].equals("k"))
			w=Double.parseDouble(strW[0]);
		else if (strW[1].equals("p"))
			w=Double.parseDouble(strW[0])*0.45;
		
		if (strH[1].equals("m"))
			h=Double.parseDouble(strH[0]);
		else if (strH[1].equals("i"))
			h=Double.parseDouble(strH[0])*0.025;
		
		double index = w/(h*h);
		
		if (index<18.5)
		{
			System.out.println("Индекс массы тела - "+index + " (недостаточная масса тела)");
		}
		else if (index <25)
		{
			System.out.println("Индекс массы тела - "+index + " (нормальная масса тела)");
		}
		else
		{
			System.out.println("Индекс массы тела - "+index + " (избыточная масса тела)");
		}
	}

	//Метод нахождения мультиплекативного пстоянства числа
	public static void bugger(int num)
	{
		int k=0;
		int n,p;
		while (num>9)
		{
			n=num;
			p=1;
			while (n>0)
			{
				p=p*(n%10);
				n=n/10;
			}
			num=p;
			k+=1;
		}
		System.out.println("Мультиплекативное постоянство введённого числа - "+k);
	}

	//Метод замены повторяющихся эл-в строки на умножение на их кол-во
	public static void toStarShorthand(String str)
	{
		String strRes = new String();
		int k=1;
		char lastChr=str.charAt(0);
		for (int i = 1; i<str.length();i++)
		{
			if (str.charAt(i)!=lastChr)
			{
				if (k>1)
					strRes+=lastChr + "*"+k;
				else
					strRes+=lastChr;
				k=1;
				lastChr=str.charAt(i);
			}
			else
				k+=1;
			if (i==str.length()-1)
			{
				if (k>1)
					strRes+=lastChr + "*"+k;
				else
					strRes+=lastChr;
			}
		}
		System.out.println("Обработанная строка - "+strRes);
	}

	//Метод сравнения рифмы
	public static void doesRhyme(String str1,String str2)
	{
		String last1 = new String();
		String last2 = new String();
		
		last1 = str1.substring(str1.lastIndexOf(" ")+1).toLowerCase();
		last2 = str2.substring(str2.lastIndexOf(" ")+1).toLowerCase();
		
		String strSrav1 = new String();
		String strSrav2 = new String();
		
		for (int i=0; i<last1.length();i++)
		{
			if ("aeuioy".contains(last1.substring(i,i+1)))
			{
				strSrav1+=last1.charAt(i);
			}
		}
		for (int j=0; j<last2.length();j++)
		{
			if ("aeuioy".contains(last2.substring(j,j+1)))
			{
				strSrav2+=last2.charAt(j);
			}
		}
		System.out.println(strSrav1.equals(strSrav2));
	}
}
