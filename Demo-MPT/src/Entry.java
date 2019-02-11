import java.util.List;
import java.util.Scanner;

import com.capgemini.beans.Account;
import com.capgemini.beans.Options;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class Entry {
	private static Scanner sc;

	public static void main(String[] args) {
		
		AccountService service = new AccountServiceImpl();
		sc = new Scanner(System.in);
		List<Account> accounts = service.findAll();
		
		
		System.out.println("Enter 1 to delete");
		System.out.println("Enter 2 to Create");
		System.out.println("Enter 3 to Sort by name");
		System.out.println("Enter 4 to sort by id");
		System.out.println("Enter 5 to find all accounts");
		System.out.println("Enter 6 to update");
		System.out.println("Enter 7 to find by ID");
		System.out.println("Enter 8 to exit");
		
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:
		{
			System.out.println("Enter id to be Deleted:");
			int idd = sc.nextInt();
			service.delete(idd);
		break;
		}
		case 2:
		{
			
			System.out.println("Enter id to be updated :");
			int idn = sc.nextInt();
			System.out.println("Enter updated sallary:");
			double saln = sc.nextDouble();
			System.out.println("Enter NAme:");
			String nn = sc.next();
			Account newAccount = new Account();
			newAccount.setId(idn);
			newAccount.setBalance(saln);
			newAccount.setName(nn);
			
			boolean flag = service.create(newAccount);
			System.out.println("New Accout created? "+flag);
			
			break;
		}
		case 3:
		{
			
			accounts = service.sortAccountDetails(Options.byName);
			for(Account account: accounts){
				System.out.print(account);
			}
			break;
		}
		case 4:
		{
			
			accounts = service.sortAccountDetails(Options.byId);
			for(Account account: accounts){
				System.out.print(account);
			}
			break;
		}
		case 5:
		{
			 accounts = service.findAll();
				
				for(Account account: accounts){
					System.out.print(account);
				}
			break;
		}
		case 6:
		{

			System.out.println("Enter id to be updated :");
			int idup = sc.nextInt();
			System.out.println("Enter updated sallary:");
			double newsal = sc.nextDouble();
			System.out.println("Enter NAme:");
			String n = sc.next();
			
			Account newAccount2 = new Account();
			newAccount2.setId(idup);
			newAccount2.setBalance(newsal);
			newAccount2.setName(n);
			
			service.update(idup, newAccount2);
			
			 accounts = service.findAll();
				
				for(Account account: accounts){
					System.out.print(account);
				}
			
			break;
			
		}
		case 7:
			{
				System.out.println("Enter id to be Searched :");
				int s = sc.nextInt();
		     	Account a=service.findById(s);
			   if(a==null)
				 System.out.println("Doesn't exist");
			 else
				System.out.println(a +"Found");
			 break;
			
		}
		case 8:
			System.exit(0);
			break;
			default:
				System.out.println("Wrong Choice");
		
	}
}
}