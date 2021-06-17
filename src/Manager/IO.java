package Manager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IO {
	Manager m;
	IO(Manager m ){
		this.m=m;
	}
	final boolean led[][]= {
			{false,true,true,true,true,true,true,true,true,true,true,true,true,false},
			{true,true,true,true,true,true,true,true,true,true,true,true,true,true},
			{true,true,true,true,true,true,true,true,true,true,true,true,true,true},
			{true,true,true,true,true,true,true,true,true,true,true,true,true,true},
			{false,true,true,true,true,true,false,false,true,true,true,true,true,false},
	};

	public void write(int color[][]) {
		try {
			int filenum = m.getIopanel().getFilenum();
			File file = new File(".\\Output\\"+filenum);

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write((m.getIopanel().getMode()+1)+",");
			for(int i=0;i<color.length;i++){
				for(int j=0;j<color[i].length;j++){
					//System.out.printf("%3d,",color[i][j]);
					bw.write(color[i][j]+",");
				}
				//System.out.println();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static boolean checkBeforeWritefile(File file) {
		return true;
		/*
		if (file.exists()) {
			if (file.isFile() && file.canWrite()) {
				return true;
			}
		}

		return false;*/
	}
}
