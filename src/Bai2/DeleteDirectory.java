package Bai2;

import java.io.File;
import java.util.Scanner;

public class DeleteDirectory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập đường dẫn từ người dùng
        System.out.print("Nhập đường dẫn thư mục hoặc tệp tin cần xoá: ");
        String path = scanner.nextLine();

        // Tạo đối tượng File từ đường dẫn nhập vào
        File file = new File(path);

        // Kiểm tra xem đường dẫn có tồn tại không
        if (!file.exists()) {
            System.out.println("Đường dẫn không tồn tại.");
            return;
        }

        // Kiểm tra xem đường dẫn là thư mục hay tệp tin
        if (file.isDirectory()) {
            // Nếu là thư mục, gọi phương thức để xoá thư mục
            deleteDirectory(file);
        } else {
            // Nếu là tệp tin, gọi phương thức để xoá tệp tin
            if (file.delete()) {
                System.out.println("Xoá tệp tin thành công.");
            } else {
                System.out.println("Xoá tệp tin không thành công.");
            }
        }
    }

    // Phương thức để xoá thư mục và tất cả các tệp tin bên trong
    private static void deleteDirectory(File directory) {
        // Kiểm tra xem thư mục có chứa các tệp tin hay không
        if (directory.listFiles() != null) {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    // Nếu là thư mục, gọi đệ quy để xoá thư mục
                    deleteDirectory(file);
                } else {
                    // Nếu là tệp tin, xoá tệp tin
                    if (file.delete()) {
                        System.out.println("Xoá tệp tin " + file.getName() + " thành công.");
                    } else {
                        System.out.println("Xoá tệp tin " + file.getName() + " không thành công.");
                    }
                }
            }
        }

        // Xoá thư mục sau khi đã xoá hết các tệp tin bên trong
        if (directory.delete()) {
            System.out.println("Xoá thư mục " + directory.getName() + " thành công.");
        } else {
            System.out.println("Xoá thư mục " + directory.getName() + " không thành công.");
        }
    }
}

