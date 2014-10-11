import com.thoughtworks.iamcoach.pos.BarcodeScanner;
import com.thoughtworks.iamcoach.pos.CartItem;
import com.thoughtworks.iamcoach.pos.FileHelper;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            List list = FileHelper.get("cart.txt");
            BarcodeScanner barcodeScanner = new BarcodeScanner();
            List<CartItem> cartItemList = barcodeScanner.scan(list);
            System.out.print("******let us go购物清单*******");

        } catch (IOException e) {
            System.out.println("对不起本机暂停服务。。。。。。。。。。");
        }
    }
}
