package org.enilu.hellohadoop;

import org.enilu.hellohadoop.hdfs.Copy;
import org.enilu.hellohadoop.hdfs.GetHdfsNodes;
import org.enilu.hellohadoop.hdfs.HDFS;
import org.enilu.hellohadoop.hdfs.Listfiles;
import org.enilu.hellohadoop.hdfs.Mkdir;
import org.enilu.hellohadoop.hdfs.Rm;

public class Main {

	public static void main(String[] args) throws Exception {
		String cmd = args[0];
		System.out.println("accept command:" + args[0]);
		HDFS hdfs = null;
		switch (cmd) {
		case "copy":
			hdfs = new Copy();
			break;
		case "rm":
			hdfs = new Rm();
			break;
		case "mkdir":
			hdfs = new Mkdir();
			break;
		case "node":
			hdfs = new GetHdfsNodes();
			break;
		case "list":
			hdfs = new Listfiles();
			break;
		default:
			System.out.println("nothing....");
			break;
		}
		hdfs.execute();

	}
}
