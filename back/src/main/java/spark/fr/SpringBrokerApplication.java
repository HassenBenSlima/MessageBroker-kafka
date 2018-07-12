package spark.fr;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spark.fr.dao.ClientRepository;
import spark.fr.dao.MessageRepository;
import spark.fr.dao.MessagesClientsRepository;

@SpringBootApplication
public class SpringBrokerApplication implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	MessagesClientsRepository messagesClientsRepository;

	// private static final Logger log =
	// LoggerFactory.getLogger(SpringBrokerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBrokerApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		//
		// List<Client> clientsR = messagesClientsRepository.getClientReciever();
		// clientsR.forEach(c -> {
		//
		// System.out.println(c.getName());
		//
		// });
		//
		// List<Client> clientsS = messagesClientsRepository.getClientSender();
		// clientsS.forEach(c -> {
		//
		// System.out.println(c.getName());
		//
		// });
		//
		// clientRepository.save(new Client("Anis"));
		// clientRepository.save(new Client("Hassen"));
		// clientRepository.save(new Client("Mohamed"));
		// clientRepository.save(new Client("Mahdi"));
		// messageRepository.save( new Message("Bonjour Hassen"));
		// messageRepository.save( new Message("Bonjour Anis"));
		// messageRepository.save( new Message("Bonjour Mohamed"));
		// messageRepository.save( new Message("Bonjour Mahdi"));
		//
		// Client clt1 = clientRepository.findById(1L).get();
		// Client clt2 = clientRepository.findById(2L).get();
		// Message ms = messageRepository.findById(1L).get();
		//
		// messagesClientsRepository.save(new MessagesClients(clt1, clt2, ms, new
		// Date()));

		// // Cleanup the tables
		// // clientRepository.deleteAllInBatch();
		// // messageRepository.deleteAllInBatch();
		//
		// // =======================================

		// List<Client> clients = clientRepository.findAll();
		// clients.forEach(c -> {
		//
		// System.out.println(c.getName());
		//
		// });
		//
		// // Message msg = new Message("Hassen", "Anis", "Bonjour");
		//
		// // messageRepository.save(msg);
		// System.out.println("***********4***************");
		//
		// Client clt = clientRepository.findById(4L).get();
		// Message msg4 = messageRepository.findById(4L).get();
		//
		// System.out.println("***********4***************");
		// System.out.println("**************************" + clt.getName());
		// System.out.println("**************************" + msg4.getContent());
		// System.out.println("***********4***************");
		//
		// // System.out.println("+++++++++++++++++++++++++++++++" + msg.getContent());
		//
		// System.out.println("***********4***************");
		//
		// msg4.getClients().add(clt);
		// clt.getMessages().add(msg4);
		//
		// clt.getMessages().forEach(a -> System.out.println(a));
		// msg4.getClients().forEach(a -> System.out.println(a));
		System.out.println("***********5***************");

		// Client jack = new Client("Jack4");
		// Client peter = new Client("Peter4");
		//
		// clientRepository.save(jack);
		// clientRepository.save(peter);
		//
		// Message math = new Message("Mathematics4", "Mathematics4", "Mathematics4");
		// Message computer = new Message("Compter4", "Compter4", "Compter4");
		//
		// // messageRepository.save(math);
		// // messageRepository.save(computer);
		//
		// System.out.println("**************Collection Messages************");
		// // Message m = messageRepository.findById(4L).get();
		// // Message c = messageRepository.findById(5L).get();
		//
		// Collection<Message> Messages = new HashSet<Message>();
		// Messages.add(math);
		// Messages.add(computer);
		//
		// Client j = clientRepository.findById(4L).get();
		// Client p = clientRepository.findById(5L).get();
		//
		// j.getMessages().add(math);
		// p.getMessages().add(computer);
		//
		// System.out.println("**************Collection Client************");
		//
		// Collection<Client> Clients = new HashSet<Client>();
		// Clients.add(j);
		// Clients.add(p);
		//
		// math.getClients().add(j);
		// computer.getClients().add(p);
		//
		// messageRepository.save(math);
		// messageRepository.save(computer);
		//
		// List<Client> ClientLst = clientRepository.findAll();
		// List<Message> subLst = messageRepository.findAll();
		//
		// System.out.println(ClientLst.size());
		// System.out.println(subLst.size());
		//
		// System.out.println("===================Clients info:==================");
		// ClientLst.forEach(Client -> System.out.println(Client.toString()));
		//
		// System.out.println("===================Clients info:==================");
		// subLst.forEach(Message -> System.out.println(Message.toString()));

		// Message msg2 = new Message("Hassenn", "Mohamedd", "hammdoulahh");
		// messageRepository.save(msg2);
		// Message ms = messageRepository.findById(17L).get();
		//
		// Client cl = clientRepository.findById(5L).get();
		// cl.getMessages().add(ms);
		// ms.getClients().add(cl);

	}

}
