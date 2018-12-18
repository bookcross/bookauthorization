package com.trembear.bookauthorization.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Description: 远程服务访问的基础类.
 * All Rights Reserved.
 * @version 1.0  2016-5-23 下午1:42:38  by 魏凤轩（fx.wei@zuche.com）创建
 */
public class BaseClientService {

	/** 单元测试的时候改为true, 使用HESSIAN调用. tcp在测试无法返回结果. */
	private static boolean isUnitTest = false;

	/** json解析输出日志用. */
	private static SerializeConfig jsonSerializeConfig;

	protected Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * Description: 对远程方法调用的包装，方便统一配置调用类型减少冗余代码。此方法不捕获任何异常，异常信息需要单独处理。
	 * @Version1.0 2016-5-23 下午1:46:00 by 魏凤轩（fx.wei@zuche.com）创建
	 * @param serviceName
	 * @param objects
	 * @return
	 */
//	protected Object executeToObject(String serviceName, Object... objects){
//		if(logger.isDebugEnabled()){
//			logger.debug("[CALL]{}:{}", serviceName, toJSONString(objects));
//		}
//		RemoteClient client = RemoteClientFactory.getInstance(isUnitTest ? RemoteType.HESSIAN : RemoteType.TCP);
//		Object re = client.executeToObject(serviceName, objects);
//		if(logger.isDebugEnabled()){
//			logger.debug("[CALL-RE]{}:{}", serviceName, toJSONString(re));
//		}
//		return re;
//	}

	/**
	 * Description: json解析,byte[]类型简化,降低日志长度.
	 * @Version 1.0 2017-3-9 16:10:57 by 刘庆魁（qk.liu@zuche.com）创建
	 */
	private String toJSONString(Object object){
		SerializeConfig cfg = getSerializeConfig();
		return JSON.toJSONString(object, cfg);
	}

	/**
	 * Description: json解析配置,避免日志byte[]太长的情况. 输出如[bytes count 22443].
	 * filter不好使, 只能用这个了.
	 * @Version 1.0 2017-3-9 16:10:57 by 刘庆魁（qk.liu@zuche.com）创建
	 */
	private static SerializeConfig getSerializeConfig(){
		if( jsonSerializeConfig==null ){
			jsonSerializeConfig = new SerializeConfig();
			jsonSerializeConfig.put(byte[].class, new ObjectSerializer() {
				@Override
				public void write(JSONSerializer serializer, Object object,
                                  Object fieldName, Type fieldType) throws IOException {
					byte[] array = (byte[]) object;
					//[bytes"AQE="]
					SerializeWriter out = serializer.getWriter();
					out.write("[bytes count ");
					out.write(array==null?"null" : String.valueOf(array.length));
					out.write("]");
				}
			});
		}
		return jsonSerializeConfig;
	}

}
