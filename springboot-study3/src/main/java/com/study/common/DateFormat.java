package com.study.common;

import org.apache.commons.lang3.time.FastDateFormat;

public class DateFormat {
	// 마이크로타임을 format에 맞게 string으로 변경
	public static String getFormatString(long nTime, String nFormat) {
		String reval = "";
		String format = "yyyy-MM-dd HH:mm:ss";
		FastDateFormat fastdateformat = null;

		if (nFormat != null) {
			format = nFormat;
		}
		fastdateformat = FastDateFormat.getInstance(format);

		reval = fastdateformat.format(nTime);

		return reval;
	}
}
