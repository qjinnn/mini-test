package qj.mini_test.workbreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



public interface WorkBreak {

	public static final Set<String> DEFAULT = new HashSet<>(Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man go", "and"));

	
	/**
	 * 获取输入字典集合
	 * 
	 * @param dict
	 * @return
	 */
	Set<String> getList(Set<String> dict);

}
