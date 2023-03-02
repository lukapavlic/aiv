package si.um.feri.bank;

import java.time.format.DateTimeFormatter;

public interface Constants {

    final static double ALLOWED_LIMIT_PREMIUM_ACCOUNT =-1000.0d;

    final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    static final String FILE_STORAGE ="C:/_DEV23/bank_accounts";

}
