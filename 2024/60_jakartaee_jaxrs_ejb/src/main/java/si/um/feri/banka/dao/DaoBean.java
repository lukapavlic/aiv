package si.um.feri.banka.dao;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import si.um.feri.banka.vao.BankAccount;
import si.um.feri.banka.vao.Person;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@Stateless
@Local
public class DaoBean implements Dao {

    private static final Logger log=Logger.getLogger("DaoImpl");

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void initialize() {
        try {
            new Initializator().initialize(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Person> getAllPeople() {
        log.info(this+" returning all people");
        return em.createQuery("select o from Person o").getResultList();
    }

    @Override
    public Collection<BankAccount> getAllBankAccounts() {
        log.info(this+" returning all bank accounts");
        return em.createQuery("select o from BankAccount o").getResultList();
    }

    @Override
    public Person findPerson(String email) {
        log.info(this+" finding person"+email);
        Query q=em.createQuery("select o from Person o where o.email = :e");
        q.setParameter("e", email);
        try {
            return (Person)q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public BankAccount findBankAccount(String iban) {
        log.info(this+" finding bank account "+iban);
        return em.find(BankAccount.class,iban);
    }

    @Override
    public List<BankAccount> findBankAccountOwner(String email) {
        log.info(this+" finding owner "+email);
        Query q=em.createQuery("select o from BankAccount o where o.owner.email = :e");
        q.setParameter("e", email);
        try {
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void save(BankAccount br) throws Exception {
        log.info(this+" saving bank account "+br);
        em.persist(br);
    }

    @Override
    public Person save(Person os) throws Exception {
        log.info(this+" saving person "+os);
        em.persist(os);
        return os;
    }

}
