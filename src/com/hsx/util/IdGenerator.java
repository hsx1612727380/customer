package com.hsx.util;

import java.util.UUID;

/**
 * ID要求不能重复
 * @author hsx
 *
 */
public class IdGenerator {

	/**
	 * 通过使用UUID确保ID不会重复
	 * @return
	 */
	public static String getId() {
		return UUID.randomUUID().toString();
	}
	
}
