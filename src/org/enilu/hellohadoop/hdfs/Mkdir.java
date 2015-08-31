package org.enilu.hellohadoop.hdfs;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Mkdir extends HDFS{

	@Override
	public void execute1(FileSystem fs) throws Exception{
		Path path= new Path("/user/root/hello/20150820");
		if(!fs.exists(path)){
		   fs.mkdirs(path);
		   System.out.println("创建文件"+path.toString()+"成功");
		}else{
			System.out.println("文件"+path.toString()+"已存在");
		}
	}

}
