/**
 *Rm.java
 *Version1.0
 *2015年8月30日
 *Copyright easecredit.com
 *
 */
package org.enilu.hellohadoop.hdfs;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * descript<br>
 * </p>
 * Copyright by easecredit.com<br>
 * 作者: zhangtao <br>
 * 创建日期: 2015年8月30日<br>
 */
public class Rm extends HDFS {

	@Override
	public void execute1(FileSystem fs) throws Exception {
		Path path = new Path("profile");
		if(fs.exists(path)){
			fs.deleteOnExit(path);
			System.out.println("删除文件："+path.toString()+"成功");
		}else{
			System.out.println("不存在该文件："+path.toString());
		}
	}

}
