/**
 *Listfiles.java
 *Version1.0
 *2015年8月30日
 *Copyright easecredit.com
 *
 */
package org.enilu.hellohadoop.hdfs;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * descript<br>
 * </p>
 * Copyright by easecredit.com<br>
 * 作者: zhangtao <br>
 * 创建日期: 2015年8月30日<br>
 */
public class Listfiles extends HDFS {

	@Override
	public void execute1(FileSystem fs) throws Exception {
		Path path = new Path("/");
		FileStatus[] list = fs.listStatus(path);
		for(FileStatus status:list){
			System.out.println("group:"+status.getGroup()+" owner:"+status.getOwner()+"path:"+status.getPath().toString());
		}
	}

}
