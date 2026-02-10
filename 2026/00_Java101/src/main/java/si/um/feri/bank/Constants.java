package si.um.feri.bank;

import java.time.format.DateTimeFormatter;

public interface Constants {

    double ALLOWED_LIMIT_PREMIUM_ACCOUNT =-1000.0d;

    DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    String FILE_STORAGE ="/Users/luka/temp/bankaccounts";

}
