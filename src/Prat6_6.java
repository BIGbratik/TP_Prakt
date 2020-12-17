import java.util.Scanner;
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
					break;
				
				//Практическое задание 6.6
				case 6:
					break;
					
				//Практическое задание 6.7
				case 7:
					break;
					
				//Практическое задание 6.8
				case 8:
					break;
					
				//Практическое задание 6.9
				case 9:
					break;
					
				//Практическое задание 6.10
				case 10:
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
}


