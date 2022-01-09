package com.ecorp.bank.phone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import com.ecorp.bank.appuser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PhoneService {
    int VerificationNumber;
    public String sendSms() {
        try {
            String apiKey = "apikey=" + "NDY2OTM3Nzk2ZDRmMzA2ZDM4NDk3NTYyNGE0YjM5MzY=";
            Random random = new Random();
            VerificationNumber = random.nextInt(999999);
            AppUser user = new AppUser();
            String message = "&message=" + "Hey " + user.getFirstName() + "your verification number is: " + VerificationNumber;
            String sender = "&sender=" + "ECorp";
            String numbers = "&numbers=" + user.getPhone();

            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            return stringBuffer.toString();
        } catch (Exception e) {
            System.out.println("Error SMS " + e);
            return "Error " + e;
        }
    }
}
