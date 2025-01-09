package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This is a generic method to generate random number
	 * @param bound
	 * @return
	 */
	public int  generateRandomNumber(int bound)
	{
		Random r = new Random();
		int num = r.nextInt(bound);
		return num;
	}
	public String  getCalanderDetails(String format)
	{
		Calendar cal = Calendar.getInstance();
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String data = sdf.format(d);
		return data;
		
	}
}
