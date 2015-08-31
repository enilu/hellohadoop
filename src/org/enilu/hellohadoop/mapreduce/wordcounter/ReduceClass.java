package org.enilu.hellohadoop.mapreduce.wordcounter;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReduceClass extends Reducer<Text, IntWritable, Text, IntWritable>{
	private IntWritable intValue = new IntWritable(0);
	@Override
	protected void reduce(Text textKey, Iterable<IntWritable> values,
			 Context context)
			throws IOException, InterruptedException {

		int sum = 0;
		while(values.iterator().hasNext()){
			sum +=values.iterator().next().get();
		}
		intValue.set(sum);
		context.write(textKey, intValue);
	}

}
