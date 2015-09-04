/**
 *Main.java
 *Version1.0
 *2015年8月30日
 *Copyright easecredit.com
 *
 */
package org.enilu.hellohadoop.mapreduce.wordcounter;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 * 单词统计<br>
 * 执行命令bin/hadoop jar hadoop-test-1.2.1.jar  org.enilu.hellohadoop.mapreduce.wordcounter.WordCounter profile output.txt
 * </p>
 * Copyright by easecredit.com<br>
 * 作者: zhangtao <br>
 * 创建日期: 2015年8月30日<br>
 */
public class WordCounter {

	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException {
		Configuration conf = new Configuration();
		String[] otherAargs = new GenericOptionsParser(conf,args).getRemainingArgs();
		if(otherAargs.length!=2){
			System.out.println("请输入合法的参数");
			System.exit(2);
		}
		Job job = new Job(conf,"文字统计");
		job.setJarByClass(WordCounter.class);
		job.setMapperClass(MapClass.class);
		job.setReducerClass(ReduceClass.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path(otherAargs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherAargs[1]));
		System.exit(job.waitForCompletion(true)?0:1);
		
		
	}

}
