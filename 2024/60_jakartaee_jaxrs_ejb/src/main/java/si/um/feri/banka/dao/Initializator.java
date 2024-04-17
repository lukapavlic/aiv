package si.um.feri.banka.dao;


import si.um.feri.banka.vao.BankAccount;
import si.um.feri.banka.vao.Person;

import java.math.BigDecimal;

public class Initializator {

    public void initialize(Dao dao) throws Exception {
        if (dao.getAllPeople().size()!=0) return;

        Person elvis=new Person("elvis@mail.com","Elvis","Presley");
        Person daenerys=new Person("daenerys@got.com","Daenerys","Targaryen");

        BankAccount be1=new BankAccount("001-002-003-004", elvis, new BigDecimal(100_000), true);
        BankAccount be2=new BankAccount("007-007-007-007", elvis, new BigDecimal(200_000), true);

        dao.save(elvis);
        dao.save(daenerys);

        dao.save(be1);
        dao.save(be2);
    }

}
