package qj.mini_test.workbreak.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 类选项枚举
 * @author qj
 *
 */
public enum WorkBreakEnum {
	one("One"),tow("Tow"),three("Tree");

	private String value;

	private WorkBreakEnum(String value) {

		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static boolean isContain(String key){
		WorkBreakEnum[] values = WorkBreakEnum.values();
		for (WorkBreakEnum workBreakEnum : values) {
			if (StringUtils.equals(workBreakEnum.getValue(), key)) {
				return true;
			}
		}
		return false;
	}

}
