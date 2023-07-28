package com.spring.api.enums;

public enum CourseEnum {

	MATH(1), INFORMATICS(2), HISTORY(3);

	private int code;

	CourseEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static CourseEnum valueOf(int code) {
		for (CourseEnum value : CourseEnum.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid CourseEnum code");
	}

}
