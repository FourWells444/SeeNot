package json;

import java.io.*;


public class H {
    public static void main(String argv[]) {
        String filePath = "D:\\bla.json";
        String filePath2 = "D:\\baba.json";
        io(filePath, filePath2);
    }
    public static void io(String filePath, String filePath2) {
        String encoding = "UTF-8";
        String text = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("要读取的文件找不到啦摔，报错如下");;
            }
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);
/*            while((text = br.readLine()) != null){
                text = br.readLine();
            }*/
            text = br.readLine();
            System.out.println(text);
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }


/*        try {
            File file = new File(filePath2);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            bufferedWriter.write(text);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }*/
    }
}
