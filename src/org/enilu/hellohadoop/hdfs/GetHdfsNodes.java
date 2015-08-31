/**
 *GetHdfsNodes.java
 *Version1.0
 *2015年8月30日
 *Copyright easecredit.com
 *
 */
package org.enilu.hellohadoop.hdfs;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;

/**
 * descript<br>
 * </p>
 * Copyright by easecredit.com<br>
 * 作者: zhangtao <br>
 * 创建日期: 2015年8月30日<br>
 */
public class GetHdfsNodes extends HDFS{

	@Override
	public void execute1(FileSystem fs) throws Exception {
 
		DistributedFileSystem dfs = (DistributedFileSystem) fs;
		DatanodeInfo[] nodinfos = dfs.getDataNodeStats();
		for(DatanodeInfo nodinfo:nodinfos){{
			System.out.println("name:"+nodinfo.getName()+"capacity:"+nodinfo.getCapacity()+"host:"+nodinfo.getHost());
		}
			
		}
		
	}
	

}
