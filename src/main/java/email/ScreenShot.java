package email;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/* Screenshot class has one function, to take a screenshot of the users wishlist.
 * Using the flash api to obtain the screenshot and save it to the screenshot.jpeg file in the project folder.   */
public class ScreenShot {

    public boolean TakeScreenShot(String stockExchange, String symbols) throws IOException {

        symbols = symbols.replace(";", "%3B");
        boolean isComplete = false;

        URL url = new URL("https://api.apiflash.com/v1/urltoimage?access_key=561750093ea5477589d2927f709ac72c&url=https%3A%2F%2Fapi.stockdio.com%2Fvisualization%2Ffinancial%2Fcharts%2Fv1%2FQuoteBoard%3Fapp-key%3D7F5CA262046A4B63B327718307695CF1%26stockExchange%3D" + stockExchange + "%26symbols%3D" + symbols + "%26includeVolume%3Dtrue%26palette%3DFinancial-Light%26title%3DWatch%2520List%26onload%3Dst_fee6e0ef4821475da6bcc7b6ce0cb6e9&format=jpeg&full_page=true&delay=4&response_type=image");
        InputStream inputStream = url.openStream();
        OutputStream outputStream = Files.newOutputStream(Paths.get("screenshot.jpeg"));

        byte[] b = new byte[2048];
        int length;
        while ((length = inputStream.read(b)) != -1) {
            outputStream.write(b, 0, length);
            isComplete = true;
        }

        inputStream.close();
        outputStream.close();
        return isComplete;
    }
}

