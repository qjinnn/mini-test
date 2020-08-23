package qj.mini_test.workbreak.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author qj
 * @date  2020/8/22
 */
public class WorkBreakUtil {
	
	/**
	 * 
	 * @param s 输入内容
	 * @param dict 字典
	 * @param list 
	 * @param ret 输出
	 */
	public void rec(String s, Set<String> dict, List<String> list, List<String> ret) {
		if (s.length() == 0) {
			String concat = "";
			for (int i = 0; i < list.size(); i++) {
				concat += list.get(i);
				if (i != list.size() - 1) {
					concat += " ";
				}
			}
			ret.add(concat);
			return;
		}
		for (String cur : dict) {
			String temp = cur.replace(" ", "");
			if (temp.length() > s.length()) {
				continue;
			}
			String substr = s.substring(0, temp.length());
			if (substr.equals(temp)) {
				list.add(cur);
				rec(s.substring(temp.length()), dict, list, ret);
				list.remove(list.size() - 1);
			}
		}
	}

	/**
	 * 
	 * @param sentence 用户输入内容
	 * @param dictionary  词典
	 * @return
	 */
	public List<String> wordBreak(String sentence, Set<String> dictionary) {
		List<String> list = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		rec(sentence, dictionary, list, ret);
		return ret;
	}

}