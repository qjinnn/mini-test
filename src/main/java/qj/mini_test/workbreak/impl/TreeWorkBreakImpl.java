package qj.mini_test.workbreak.impl;

import java.util.Set;

import qj.mini_test.workbreak.WorkBreak;
import qj.mini_test.workbreak.WorkBreakContext;

/**
 * 用户提供自定义的有效英语单词词典作为附加
 * 
 * @author qj
 * @date 2020/8/22
 */
public class TreeWorkBreakImpl implements WorkBreak {

	@Override
	public Set<String> getList(Set<String> dict) {
		dict.addAll(DEFAULT);
		return dict;
	}

}
