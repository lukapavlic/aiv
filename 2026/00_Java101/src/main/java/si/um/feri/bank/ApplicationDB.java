package si.um.feri.bank;

import si.um.feri.bank.dao.BankAccountDBDao;
import si.um.feri.bank.vao.BankAccount;
import si.um.feri.bank.vao.Person;
import si.um.feri.bank.vao.Transaction;
import si.um.feri.bank.vao.PremiumBankAccount;
import java.math.BigDecimal;

public class ApplicationDB {

    public static void main(String[] args) throws Exception {

        BankAccountDBDao bank=new BankAccountDBDao();

        Person janko=new Person("Janko","The Husband");
        Rich metka=new Person("Metka","The Wife");
        BankAccount jankoAccount=new BankAccount("SI56-0000-0000-2222");
        jankoAccount.setOwner(janko);

        BankAccount metkaAccount=new PremiumBankAccount("SI56-0000-0000-4444");
        metkaAccount.setOwner((Person)metka);

        bank.savePerson(janko);
        bank.savePerson((Person)metka);

        bank.save(jankoAccount);
        bank.save(metkaAccount);

        bank.saveTransaction(
                new Transaction(jankoAccount,metkaAccount,new BigDecimal(1000d),"a gift")
        );

        bank.getAll().keySet().forEach(br->System.out.println(bank.find(br)));

    }

}
