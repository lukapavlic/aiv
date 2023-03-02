package si.um.feri.bank;

import si.um.feri.bank.dao.BankAccountDao;
import si.um.feri.bank.dao.BankAccountInMemoryDao;
import si.um.feri.bank.vao.BankAccount;
import si.um.feri.bank.vao.Person;
import si.um.feri.bank.vao.PremiumBankAccount;

public class Application {

    public static void main(String[] args) throws Exception {

        BankAccountDao bank=
                //BancniRacunDBDao.getInstance();
                //new BancniRacunInFileDao();
                new BankAccountInMemoryDao();

        Person janko=new Person("Janko","The Husband");
        Rich metka=new Person("Metka","The Wife");
        BankAccount jankoAccount=new BankAccount("SI56-0000-0000-2222");
        jankoAccount.setOwner(janko);

        BankAccount metkaAccount=new PremiumBankAccount("SI56-0000-0000-4444");
        metkaAccount.setOwner((Person)metka);

        bank.save(jankoAccount);
        bank.save(metkaAccount);

        metkaAccount.donate("For the poor",10_000.0d);

        System.out.println(metkaAccount);
        System.out.println(jankoAccount);

        bank.save(metkaAccount);
        bank.save(jankoAccount);

        System.out.println("------------");

        bank.getAll().keySet().forEach(br->System.out.println(bank.find(br)));

    }

}
