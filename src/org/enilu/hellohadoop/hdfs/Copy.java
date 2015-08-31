/**
 *Copy.java
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
public class Copy extends HDFS {

	@Override
	public void execute1(FileSystem fs) throws Exception {
		Path source = new Path("/etc/profile");
		Path dest = new Path("profile");
		fs.copyFromLocalFile(source, dest);
		
	}

}
