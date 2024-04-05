package com.Generic.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Java_Utility {
	public String getDate() {
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String Date = f.format(d);
		return Date;
	}
}
