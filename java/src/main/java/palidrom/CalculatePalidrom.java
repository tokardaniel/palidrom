package palidrom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculatePalidrom {

	public void calc() {
		SimpleDateFormat parser = new SimpleDateFormat("yyyyMMddHHmmss");

		String aktualis_ido = "20220101000001";
		Date aktualis_ido_date_obj = null;
		try {
			aktualis_ido_date_obj = parser.parse(aktualis_ido);
			Calendar calendatAktualis = Calendar.getInstance();
			calendatAktualis.setTime(aktualis_ido_date_obj);
			int palindrom_idopontok_szama = 0;

			do {
				calendatAktualis.add(Calendar.SECOND, 1);
				if (palidrom_e(calendatAktualis)) {
					palindrom_idopontok_szama = palindrom_idopontok_szama + 1;
				}
			} while(calendatAktualis.get(Calendar.YEAR) == 2022);
			System.out.println(String.format("Palindorom másodpercek száma 2022-ben: %s",palindrom_idopontok_szama));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private boolean palidrom_e(Calendar calendarDate) {
		SimpleDateFormat parser = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = calendarDate.getTime();
		String formattedDate = parser.format(date);
		String nstr = getReverseString(formattedDate);
		if (formattedDate.equals(nstr)) {
			System.out.println(formattedDate);
			return true;
		}
		return false;
	}

	private String getReverseString(String s) {
		String nstr="";
		char ch;
		for (int i=0; i<s.length(); i++) {
	        ch= s.charAt(i);
	        nstr= ch+nstr;
	      }
		return nstr;
	}
}
