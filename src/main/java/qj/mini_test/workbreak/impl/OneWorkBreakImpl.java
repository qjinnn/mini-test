package qj.mini_test.workbreak.impl;

import java.util.Set;

import qj.mini_test.workbreak.WorkBreak;


/**
 * 默认字典
 * 
 * @author qj
 * @date 2020/8/22
 */
public class OneWorkBreakImpl implements WorkBreak {

	@Override
	public Set<String> getList(Set<String> dict) {
		return DEFAULT;
	}

}
