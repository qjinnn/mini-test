package qj.mini_test;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;


import junit.framework.TestCase;
import qj.mini_test.workbreak.WorkBreakContext;
import qj.mini_test.workbreak.enums.WorkBreakEnum;

/**
 * test
 * @author 	qj
 * @date  2020/8/22
 */
public class AppTest extends TestCase {
	@Test
	public void testOne() throws Exception {
		List<String> sentences = WorkBreakContext.getSentences("ilikesamsungmobile", null, WorkBreakEnum.one.getValue());
		sentences.forEach(System.out::println);
		sentences = WorkBreakContext.getSentences("ilikeicecreamandmango", null, WorkBreakEnum.one.getValue());
		sentences.forEach(System.out::println);

	}

	@Test
	public void testTow() throws Exception {
		Set<String> set = new HashSet<String>(
				Arrays.asList("i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango", "and"));
		List<String> sentences = WorkBreakContext.getSentences("ilikesamsungmobile", set, WorkBreakEnum.tow.getValue());
		sentences.forEach(System.out::println);

	}

	@Test
	public void testTree() throws Exception {
		Set<String> set = new HashSet<String>(
				Arrays.asList("i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango"));
		List<String> sentences = WorkBreakContext.getSentences("ilikesamsungmobile", set, WorkBreakEnum.three.getValue());
		sentences.forEach(System.out::println);
	}
	
	
	 // 测试参数
	 
    @Test
    public void testCaseOne()  {
    	try {
    		WorkBreakContext.getSentences(null, null, null);
		} catch (Exception e) {
			assertTrue(e instanceof RuntimeException);
			assertEquals(e.getMessage(), "请输入正确的类型");
		}
    }
    
    @Test
    public void testCaseTwo()  {
    	try {
        	WorkBreakContext.getSentences(null, null,  WorkBreakEnum.one.getValue());
		} catch (Exception e) {
			assertTrue(e instanceof NullPointerException);
			assertEquals(e.getMessage(), "请输入要分词的句子");
		}
    }
    @Test
    public void testCaseTree()  {
    	try {
        	WorkBreakContext.getSentences("test", null,  WorkBreakEnum.three.getValue());
		} catch (Exception e) {
			assertTrue(e instanceof NullPointerException);
			assertEquals(e.getMessage(), "请输入字典");
		}
    }
    
    @Test
    public void testCaseFour() {
    	try {
    		WorkBreakContext.getSentences("test", null,  "test类型");
    	} catch (Exception e) {
    		assertTrue(e instanceof RuntimeException);
    		assertEquals(e.getMessage(), "请输入正确的类型");
    	}
    }
    

   
    
    
    
 



    
}
