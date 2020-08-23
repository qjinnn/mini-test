package qj.mini_test.workbreak;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import qj.mini_test.workbreak.enums.WorkBreakEnum;
import qj.mini_test.workbreak.util.WorkBreakUtil;

/**
 * context
 * 
 * @author qj
 * @date 2020/8/22
 */
public class WorkBreakContext {

	
	//策略路径
	public static final String PACKEGE="qj.mini_test.workbreak.impl.";

	//子类后缀名
	public static final String CLASS_SUFFIX="WorkBreakImpl"; 

	/**
	 * 根据类型，字典，句子输出有效的句子
	 * @param str 句子
	 * @param dict 字典
	 * @param type 类型
	 * @return
	 * @throws Exception 
	 */
	public static List<String> getSentences(String str, Set<String> dict, String type) throws Exception {
		if (Objects.isNull(type)||!WorkBreakEnum.isContain(type)) {
			throw new RuntimeException("请输入正确的类型");
		}
		if (Objects.isNull(str)) {
			throw new NullPointerException("请输入要分词的句子");
		}
		//只有默认字典情况下，字典才可以为空
		if (!type.equals(WorkBreakEnum.one.getValue())&&dict==null) {
			throw new NullPointerException("请输入字典");
		}
		Set<String> getList = wordBreak(type).getList(dict);
		List<String> list= wordBreak(str,getList);
		if (list.isEmpty()) {
			throw new RuntimeException("字典中当前的字数无法反汇编！");
		}
		return list;
	}
	
	public static List<String> wordBreak(String str, Set<String> dict) {
		WorkBreakUtil solution = new WorkBreakUtil();
		List<String> seq = solution.wordBreak(str, dict);
		return seq;
	}
	
	/**
	 * 根据类型生成具体的算法类
	 * @param type			类型
	 * @return
	 * @throws Exception
	 */
	public static WorkBreak wordBreak(String type) throws Exception {
		StringBuilder className = new StringBuilder();
		className.append(PACKEGE).append(type).append(CLASS_SUFFIX);
		return (WorkBreak) Class.forName(className.toString()).newInstance();
	}
}