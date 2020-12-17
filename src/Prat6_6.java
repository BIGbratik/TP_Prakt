import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Prat6_6 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int choice=0;
		while (choice!=-1)
		{
			System.out.print("\n Введите номер задания (от 1 до 10), которое хотите выполнить - ");
			choice=in.nextInt();
			switch (choice)
			{
				//Практическое задание 6.1
				case 1:
					int n;
					System.out.print("Введите кол-во элементов множества - ");
					n=in.nextInt();
					
					bell(n);
					break;
			
				//Практическое задание 6.2
				case 2:
					int choic;
					System.out.print("Что вы хотите сделать ? (1 - перевести слово; 2 - перевести предложение) - ");
					choic=in.nextInt();
					in.nextLine();
					switch(choic)
					{
						case 1:
							System.out.print("Введите слово - ");
							String word = in.nextLine();
							System.out.println(translateWord(word));
							break;
						case 2:
							System.out.print("Введите предложение - ");
							String str = in.nextLine();
							translateSentence(str);
							break;
						default:
							System.out.println("Ваш выбор не возможен в данной системе!!!");
							break;	
					}
					break;
					
				//Практическое задание 6.3
				case 3:
					String color;
					in.nextLine();
					System.out.print("Введите строку со значениями RGB(A)");
					color=in.nextLine();
					validColor(color);
					break;
					
				//Практическое задание 6.4
				case 4:
					int k;
					System.out.print("Что вы хотите передать? (1 - просто строку URL; 2 - строку URL и массив удаляемых) - ");
					k=in.nextInt();
					in.nextLine();
					switch(k)
					{
						case 1:
							String URLa;
							System.out.print("Введите URL-строку - ");
							URLa=in.nextLine();
							stripUrlParams(URLa);
							break;
						case 2:
							String URLb;
							System.out.print("Введите URL-строку - ");
							URLb=in.nextLine();
							String del;
							System.out.print("Введите значения параметров для удаления через пробел - ");
							del=in.nextLine();
							stripUrlParams(URLb,del);
							break;
						default:
							System.out.println("Введённого номера варианта действий не существует!!!");
							break;
					}
					break;
					
				//Практическое задание 6.5
				case 5:
					String top;
					in.nextLine();
					System.out.print("Введите ваш отрывок из газеты - ");
					top=in.nextLine();
					getHashTags(top);
					break;
				
				//Практическое задание 6.6
				case 6:
					int numUlam;
					System.out.print("Введите порядковый номер числа из ряда чисел Улама - ");
					numUlam=in.nextInt();
					ulam(numUlam);
					break;
					
				//Практическое задание 6.7
				case 7:
					String str;
					in.nextLine();
					System.out.print("Введите последовательность символов - ");
					str=in.nextLine();
					longestNonrepeatingSubstring(str);
					break;
					
				//Практическое задание 6.8
				case 8:
					int roman;
					System.out.println("Введите число для преобразования - ");
					roman=in.nextInt();
					System.out.println(convertToRoman(roman));
					break;
					
				//Практическое задание 6.9
				case 9:
					String formula;
					in.nextLine();
					System.out.print("Введите формулу (без пробелов!!!!) - ");
					formula=in.nextLine();
					Formula(formula);
					break;
					
				//Практическое задание 6.10
				case 10:
					String num;
					in.nextLine();
					System.out.print("Введите ваше число - ");
					num=in.nextLine();
					palindromedescendant(num);
					break;
				
				//Завершение программы
				case -1:
					System.out.println("Работа программы завершена");
					break;
						
				default:
					System.out.println(" Задания, номер которого вы ввели, не существует");
			}
		}
	}
	
	//Метод определяющий число Белла по заданному число эл-в множества
	public static void bell(int n)
	{
		int[][] matr = new int[n+1][n+1]; 
        matr[0][0] = 1; 
          
        for (int i=1; i <= n; i++) 
        { 
        	matr[i][0] = matr[i-1][i-1]; 
            for (int j=1; j<=i; j++) 
            	matr[i][j] = matr[i-1][j-1] + matr[i][j-1]; 
        } 
        System.out.println("Кол-во возможных подмножеств = "+matr[n][0]);
	}
	
	//Перевод слова с английского на свинский
	public static String translateWord(String word)
	{
		String wordRes="";
		boolean isUpper = false;
		if (Character.isUpperCase(word.charAt(0)))
			isUpper=true;
		word=word.toLowerCase();
		if ("aeyuio".contains(word.substring(0,1).toLowerCase()))
		{
			wordRes+=word+"yay";
		}
		else
		{
			int i=0;
			while (!"aeyuio".contains(word.substring(i,i+1).toLowerCase()))
				i++;
			wordRes+=word.substring(i)+word.substring(0,i)+"ay";
		}
		if (isUpper)
			wordRes=wordRes.substring(0,1).toUpperCase()+wordRes.substring(1);
		return wordRes;
	}
	
	//Метод перевода предложения с английского на свинский
	public static void translateSentence(String str)
	{
		Pattern p = Pattern.compile("[a-zA-Z]+");
		Matcher m = p.matcher(str);
		int index = 0;
		while (m.find())
		{
			String word = m.group();
			index = str.indexOf(word, index);
			str = str.substring(0, index) + str.substring(index).replaceFirst(word, translateWord(word));
		}
		System.out.println(str);
	}
	
	//Метод определяющий валидность введённого значения RGB
	public static void validColor(String color)
	{
		color=color.toLowerCase();
		boolean isColor=true;
		if (color.charAt(color.length()-1)!=')')
			isColor=false;
		else
		{
			if (color.substring(0,4).equals("rgb("))
			{
				color=color.substring(4,color.length()-1);
				String mas[]=color.split(",");
				if (mas.length==3)
				{
					for (int i=0;i<3;i++)
					{
						int num;
						try
						{
							num=Integer.parseInt(mas[i]);
							if ((num<0)||(num>255))
							{
								isColor=false;
								break;
							}
						}
						catch (Exception ex)
						{
							isColor=false;
						}
					}
				}
				else
					isColor=false;
			}
			else if (color.substring(0,5).equals("rgba("))
			{
				color=color.substring(5,color.length()-1);
				String mas[]=color.split(",");
				if (mas.length==4)
				{
					for (int i=0;i<3;i++)
					{
						int num;
						try
						{
							num=Integer.parseInt(mas[i]);
							if ((num<0)||(num>255))
							{
								isColor=false;
								break;
							}
						}
						catch (Exception ex)
						{
							isColor=false;
						}
					}
					try
					{
						if ((Double.parseDouble(mas[3])<0)||(Double.parseDouble(mas[3])>1))
							isColor=false;
					}
					catch(Exception ex)
					{
						isColor=false;
					}
				}
				else
					isColor=false;
			}
			else
				isColor=false;
		}
		System.out.println(isColor);
	}
	
	//Метод удаляющий повторяющиеся параметры из URL строки
	public static void stripUrlParams (String str)
	{
		int questionMarkIndex = str.indexOf("?");
		if (questionMarkIndex != -1)
		{
			String[] params = str.substring(questionMarkIndex + 1).split("&");
			String result = str.substring(0, questionMarkIndex);
			String paramsResult = "";
			for (int i = 0; i < params.length; i++)
			{
				String paramName = params[i].substring(0, params[i].indexOf("="));
				String paramValue = params[i].substring(params[i].indexOf("=") + 1);
				boolean foundEarlier = false;
				for (int j = 0; j < i; j++)
				{
					String earlierParamName = params[j].substring(0, params[j].indexOf("="));
					if(paramName.contentEquals(earlierParamName))
					{
						foundEarlier = true;
						break;
					}
				}
				if (foundEarlier) continue;
				for (int j = i + 1; j < params.length; j++)
				{
					String laterParamName = params[j].substring(0, params[j].indexOf("="));
					if(paramName.contentEquals(laterParamName))
					{
						paramValue = params[j].substring(params[j].indexOf("=") + 1);
					}
				}
				
				if (paramsResult.length() > 0) paramsResult += "&";
				paramsResult += paramName + "=" + paramValue;
			}
			if (paramsResult.length() > 0)
			{
				result += "?" + paramsResult;
			}
			System.out.println(result);
		}
		else
		{
			System.out.println(str);
		}
	}

	//Метод удаляющий повторяющиеся и указанные в массиве параметры из URL строки
	public static void stripUrlParams(String str, String paramsToStrip)
	{
		String[]mas=paramsToStrip.split(" ");
		int questionMarkIndex = str.indexOf("?");
		if (questionMarkIndex != -1)
		{
			String[] params = str.substring(questionMarkIndex + 1).split("&");
			String result = str.substring(0, questionMarkIndex);
			String paramsResult = "";
			for (int i = 0; i < params.length; i++)
			{
				String paramName = params[i].substring(0, params[i].indexOf("="));
				String paramValue = params[i].substring(params[i].indexOf("=") + 1);
				boolean foundEarlier = false;
				for (int j = 0; j < i; j++)
				{
					String earlierParamName = params[j].substring(0, params[j].indexOf("="));
					if(paramName.contentEquals(earlierParamName))
					{
						foundEarlier = true;
						break;
					}
				}
				if (foundEarlier) continue;
				for (int j = i + 1; j < params.length; j++)
				{
					String laterParamName = params[j].substring(0, params[j].indexOf("="));
					if(paramName.contentEquals(laterParamName))
					{
						paramValue = params[j].substring(params[j].indexOf("=") + 1);
					}
				}
				boolean foundInParamsToStrip = false;
				for (int j = 0; j < mas.length; j++)
				{
					if (mas[j].contentEquals(paramName))
					{
						foundInParamsToStrip = true;
						break;
					}
				}
				if (!foundInParamsToStrip)
				{
					if (paramsResult.length() > 0) paramsResult += "&";
					paramsResult += paramName + "=" + paramValue;
				}
			}
			
			if (paramsResult.length() > 0)
			{
				result += "?" + paramsResult;
			}
			System.out.println(result);
		}
		else
		{
			System.out.println(str);
		}
	}

	//Метод, находящий в стркое три самых длинных слова
	public static void getHashTags(String top)
	{
		top=top.toLowerCase();
		String[]mas = top.split("\\W");
		String first = "";
		String second = "";
		String third = "";
		for (int i = 0; i < mas.length; i++)
		{
			if (mas[i].length() > first.length())
			{
				third = second;
				second = first;
				first = mas[i];
			}
			else if (mas[i].length() > second.length())
			{
				third = second;
				second = mas[i];
			}
			else if (mas[i].length() > third.length())
				third = mas[i];
		}
		if (first.length() == 0)
			System.out.println("Хештегов нет!!!");
		else if (second.length() == 0) 
			System.out.println("#"+first);
		else if (third.length() == 0)
			System.out.println("#"+first+" #"+second);
		else
			System.out.println("#"+first+" #"+second+" #"+third);
	}

	//Метод, выполняющий поиск n-го числа из радв числе Улама
	public static void ulam(int n)
	{
		ArrayList<Integer>ULAM = new ArrayList<Integer>();
		ULAM.add(1);
		ULAM.add(2);
		
		int num = 2;
		for (int i = 2; i < n; i++)
		{
			while (true)
			{
				num++;
				int count = 0;
				for (int j = 0; j < ULAM.size() - 1; j++)
				{
					for (int k = j + 1; k < ULAM.size(); k++)
					{
						if (ULAM.get(j) + ULAM.get(k) == num)
							count++;
					}
				}
				if (count == 1)
				{
					ULAM.add(num);
					break;
				}
			}
		}
		System.out.println(ULAM.get(n-1));
	}

	//Метод, возвращающий самую длинную непосторяющуюся последовательность из строки символов
	public static void longestNonrepeatingSubstring(String str)
	{
		String strRes="";
		String strTemp="";
		
		for (int i=0;i<str.length();i++)
		{
			if (!strTemp.contains(str.substring(i,i+1)))
				strTemp+=str.charAt(i);
			else
			{
				if (strTemp.length()>strRes.length())
					strRes=strTemp;
				strTemp="";
			}
		}
		if ((strTemp.length()!=0)&&(strRes.length()==0))
			strRes=strTemp;
		System.out.println(strRes);
	}

	//Метод, преобразующий арабское число в римское до 4000
	public static String convertToRoman(int arab)
	{
		if (arab==0)
			return "Не знаю как он выглядел, он это ноль";
		else
		{
			TreeMap<Integer, String> map = new TreeMap<Integer, String>();
			map.put(1, "I");
			map.put(4, "IV");
			map.put(5, "V");
			map.put(9, "IX");
			map.put(10, "X");
			map.put(40, "XL");
	        map.put(50, "L");
	        map.put(90, "XC");
	        map.put(100, "C");
	        map.put(400, "CD");
	        map.put(500, "D");
	        map.put(900, "CM");
	        map.put(1000, "M");
	        
	        int part = map.floorKey(arab);
	        if (part == arab)
	        	return map.get(part);
	        else
	        	return map.get(part) + convertToRoman(arab - part);
		}
	}

	//Метод, производящий операции умножения и деления с выражением
	public static double multiplication(String str)
	{
		double result = 1;
		String currentNumber = "";
		boolean multiplying = true;
		for (int i = 0; i < str.length(); i++)
		{
			if ("*/".contains(str.substring(i,i+1)))
			{
				if (currentNumber.length() > 0)
				{
					if (multiplying) 
						result *= Double.parseDouble(currentNumber);
					else 
						result /= Double.parseDouble(currentNumber);
				}
				
				currentNumber = "";
				
				multiplying = (str.charAt(i) == '*');
				
			}
			else
			{
				currentNumber += str.substring(i,i+1);
			}
		}
		if (multiplying) 
			result *= Double.parseDouble(currentNumber);
		else 
			result /= Double.parseDouble(currentNumber);
		
		return result;
	}
	
	//Метод, выполняющий операции сложения и вычитания с выржением
	public static double addition(String str)
	{
		double result = 0;
		String currentNumber = "";
		if (!"+-".contains(str.substring(0, 1)))
			currentNumber = "+";
		for (int i = 0; i < str.length(); i++)
		{
			if ("+-".contains(str.substring(i,i+1)))
			{
				if (currentNumber.length() > 0) 
					result += multiplication(currentNumber);
				currentNumber = str.substring(i,i+1);
			}
			else
			{
				currentNumber += str.substring(i,i+1);
			}
		}
		result += multiplication(currentNumber);
		return result;
	}
	//Метод, проверки тождественности формулы
	public static void Formula(String formula)
	{
		String[] mas=formula.split("=");
		double res;
		boolean isIdentity=true;
		
		if (mas.length==0 || mas.length==1)
		{
			System.out.println("Это не формула, тут нет знаков (=)");
		}
		else
		{
			res = addition(mas[0]);
			for (int i = 1; i < mas.length; i++)
			{
				if (res != addition(mas[i]))
					isIdentity=false;
			}
			System.out.println(isIdentity);
		}
	}

	//Метод, определёющий, является ли переданная строка палиндромом
	public static boolean isPalindrom(String str)
	{
		boolean isPal=true;
		for (int i=0; i<(str.length()/2);i++)
		{
			if (str.charAt(i)!=str.charAt(str.length()-1-i))
			{
				isPal=false;
				break;
			}
		}
		return isPal;
	}
	//Метод, определяющий является ли число, или его потомки, палиндромом
	public static void palindromedescendant(String num)
	{
		String strNum="";
		boolean find=false;
		while (num.length()>1)
		{
			if (isPalindrom(num))
			{
				find=true;
				break;
			}
			for (int i=0;i<num.length()-1;i+=2)
			{
				strNum+=(Integer.parseInt(num.substring(i,i+1))+Integer.parseInt(num.substring(i+1,i+2)));
			}
			num=strNum;
			strNum="";
		}
		System.out.println(num+" "+find);
	}
}


