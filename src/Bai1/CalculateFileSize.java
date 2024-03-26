package Bai1;

import java.util.Scanner;
import java.io.File;;
public class CalculateFileSize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap duong dan: ");
        String filePath;
        filePath = sc.nextLine();
        
        //tạo đối tượng file
        File file = new File(filePath);

        //kiểm tra xem tập tin có tồn tại k!
        if(!file.exists()){
            System.out.println("file khong ton tai!");
            return;
        }

        //kiểm tra xem có phải là tập tin k!
        if(!file.isFile()){
            System.out.println("khong phai file!");
            return;
        }

        //lấy kích thước của tập tin(byte), lớn hơn 2GB sẽ sai!
        double fileSizeByte = file.length();
        double fileSizeKB = fileSizeByte / 1024;
        double fileSizeMB = fileSizeKB / 1024;
        double fileSizeGB = fileSizeMB / 1024;

        System.out.println("Kich thuoc tep: ");
        System.out.println("Byte: "+ fileSizeByte);
        System.out.println("Mega Byte: "+ fileSizeMB);
        System.out.println("Giga Byte "+ fileSizeGB);
   
    }
}
