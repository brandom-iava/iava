// Source File Name:   DecimalUtils.java

package com.iava.utils;

import java.math.BigDecimal;

public class DecimalUtils {

	private DecimalUtils() {
	}

	public static boolean isNullString(String s) {
		return s == null || s.trim().length() <= 0;
	}

	public static double add(double v1, double v2) {
		return add(v1, v2, false);
	}

	public static double add(double v1, double v2, int scale) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).setScale(scale, 4).doubleValue();
	}

	public static double add(double v1, double v2, boolean scalable) {
		if (scalable) {
			return add(v1, v2, 3);
		} else {
			BigDecimal b1 = new BigDecimal(v1);
			BigDecimal b2 = new BigDecimal(v2);
			return b1.add(b2).doubleValue();
		}
	}

	public static double sub(double v1, double v2) {
		return sub(v1, v2, false);
	}

	public static double sub(double v1, double v2, int scale) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2).setScale(scale, 4).doubleValue();
	}

	public static double sub(double v1, double v2, boolean scalable) {
		if (scalable) {
			return add(v1, v2, 3);
		} else {
			BigDecimal b1 = new BigDecimal(v1);
			BigDecimal b2 = new BigDecimal(v2);
			return b1.subtract(b2).doubleValue();
		}
	}

	public static double mul(double v1, double v2) {
		return mul(v1, v2, false);
	}

	public static double mul(double v1, double v2, int scale) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2).setScale(scale, 4).doubleValue();
	}

	public static double mul(double v1, double v2, boolean scalable) {
		if (scalable) {
			return mul(v1, v2, 3);
		} else {
			BigDecimal b1 = new BigDecimal(v1);
			BigDecimal b2 = new BigDecimal(v2);
			return b1.multiply(b2).doubleValue();
		}
	}

	public static double div(double v1, double v2) {
		return div(v1, v2, 10);
	}

	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"the scale must be a positive integer or zero");
		} else {
			BigDecimal b1 = new BigDecimal(v1);
			BigDecimal b2 = new BigDecimal(v2);
			return b1.divide(b2, scale, 4).doubleValue();
		}
	}

	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"the scale must be a positive integer or zero");
		} else {
			BigDecimal b = new BigDecimal(v);
			BigDecimal one = new BigDecimal(1);
			return b.divide(one, scale, 4).doubleValue();
		}
	}

	private static final int DEF_DIV_SCALE = 10;
	private static final int DEF_SCALE = 3;
}
