package ua.com.Bershka.Classes;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.Bershka.Dao.CommodityDao;
import ua.com.Query.dao.ColorDaoOld;

public class ConsoleMenu {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {

		while (true) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
			EntityManager manager = factory.createEntityManager();
//			manager.getTransaction().begin();
			ColorDaoOld colorDao = new ColorDaoOld(manager);
//			CommodityDao commodityDao=new commodityDao(manager);
			System.out.println("Enter 1 to add  color");
			System.out.println("Enter 2 to add wear type");
			System.out.println("Enter 3 to delete good's color");
			System.out.println("Enter 4 to find 1 color");
			System.out.println("Enter 5 to find all colors");
			System.out.println("Enter 6 to link color and wear type");
			System.out.println("Enter 7 to delete link");
////			switch (sc.next()) {
//			case "1":
//				System.out.println("enter good's color");
//				colorDao.save(new Color(sc.next()));
//				System.out.println("Successfuly added");
//				break;
//			case "2":
//				System.out.println("Enter the commodity u wanna add");
////				commodityDao.save(new Commodity( 0, sc.next(), null, null));
//				break;
//			case "3":
//				System.out.println("enter color u wanna delete");
//				colorDao.delete(sc.next());
//				System.out.println("successfuly deleted");
//				break;
//			case "4":
//				System.out.println("enter color u wanna find");
//				System.out.println(colorDao.findOne(sc.next()));
//				break;
//			case "5":
////				colorDao.findAll().forEach(System.out::println);
//				break;
//			case "6":
//				System.out.println("Enter color  wanna link");
//				String colors=sc.next();
//				System.out.println("Enter wear  type u wanna link");
//				String commodity=sc.next();
//				colorDao.addColorToCommodity(colors, commodity);
//				break;
//			case "7":
//				System.out.println("enter color");
//				String deletedColor=sc.next();
//				System.out.println("Enter commodity");
//				String deletedComm= sc.next();
//				colorDao.deleteColorFromCommodity(deletedColor, deletedComm);
//				break;
//			default:
//				sc.close();
//				return;
//			}

			
		manager.close();
		factory.close();
//		manager.getTransaction().commit();
	}

	}
}
