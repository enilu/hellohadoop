package org.enilu.hellohadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

public abstract class HDFS {

	public void execute() throws Exception {
		 Configuration conf = new Configuration();
	        FileSystem fs =  FileSystem.get(conf);
	        execute1(fs);
	}
	public abstract void execute1(FileSystem fs) throws Exception;
}
