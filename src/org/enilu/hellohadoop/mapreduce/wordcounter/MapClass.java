/**
 *MapClass.java
 *Version1.0
 *2015年8月30日
 *Copyright easecredit.com
 *
 */
package org.enilu.hellohadoop.mapreduce.wordcounter;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * descript<br>
 * </p>
 * Copyright by easecredit.com<br>
 * 作者: zhangtao <br>
 * 创建日期: 2015年8月30日<br>
 */
public class MapClass extends Mapper<Object, Text, Text, IntWritable> {
	private Text textKey = new Text("key");
	private IntWritable intValue = new IntWritable(1);
	@Override
	protected void map(Object key, Text value,
			Context context)
			throws IOException, InterruptedException {
		StringTokenizer tokenizer = new StringTokenizer(value.toString());
		while(tokenizer.hasMoreElements()){
			textKey.set(tokenizer.nextToken());
			context.write(textKey, intValue);
		}
	}

}
