package controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import DAO.UsersDAO;

public class Menu {
	protected LinkedHashMap<String, Runnable> menuList = new LinkedHashMap<>();
	private int opcaoMenu=-1;
	
	public Menu() {
		//menuList.put("Logar", () -> UsersDAO.loginUser());
	}
	public void addOpcao(String opcao, Runnable metodo) {
		menuList.put(opcao, metodo);
	}
	public void listarOpcoes() {
		for (String opcao : menuList.keySet()) {
			System.out.println(opcao);
		}
	}
	public void executarOpcao(int id) {
		List<Runnable> opcoes = new ArrayList<>(menuList.values());
		opcoes.get(id-1).run();
	}
	public void menuInicial(Scanner in) {
		System.out.println("\n" + 
				"                                                                                                                \n" + 
				"                                                                                                                \n" + 
				"MMMMMMMM               MMMMMMMM                                                                                 \n" + 
				"M:::::::M             M:::::::M                                                                                 \n" + 
				"M::::::::M           M::::::::M                                                                                 \n" + 
				"M:::::::::M         M:::::::::M                                                                                 \n" + 
				"M:::/:::::::M       M::::::::::M   ooooooooooo vvvvvvv           vvvvvvv eeeeeeeeeeee       mmmmmmm    mmmmmmm   \n" + 
				"M:::::::::::M     M:::::::::::M oo:::::::::::oov:::::v         v:::::vee::::::::::::ee   mm:::::::m  m:::::::mm \n" + 
				"M:::::::M::::M   M::::M:::::::Mo:::::::::::::::ov:::::v       v:::::ve::::::eeeee:::::eem::::::::::mm::::::::::m\n" + 
				"M::::::M M::::M M::::M M::::::Mo:::::ooooo:::::o v:::::v     v:::::ve::::::e     e:::::em::::::::::::::::::::::m\n" + 
				"M::::::M  M::::M::::M  M::::::Mo::::o     o::::o  v:::::v   v:::::v e:::::::eeeee::::::em:::::mmm::::::mmm:::::m\n" + 
				"M::::::M   M:::::::M   M::::::Mo::::o     o::::o   v:::::v v:::::v  e:::::::::::::::::e m::::m   m::::m   m::::m\n" + 
				"M::::::M    M:::::M    M::::::Mo::::o     o::::o    v:::::v:::::v   e::::::eeeeeeeeeee  m::::m   m::::m   m::::m\n" + 
				"M::::::M     MMMMM     M::::::Mo::::o     o::::o     v:::::::::v    e:::::::e           m::::m   m::::m   m::::m\n" + 
				"M::::::M               M::::::Mo:::::ooooo:::::o      v:::::::v     e::::::::e          m::::m   m::::m   m::::m\n" + 
				"M::::::M               M::::::Mo:::::::::::::::o       v:::::v       e::::::::eeeeeeee  m::::m   m::::m   m::::m\n" + 
				"M::::::M               M::::::M oo:::::::::::oo         v:::v         ee:::::::::::::e  m::::m   m::::m   m::::m\n" + 
				"MMMMMMMM               MMMMMMMM   ooooooooooo            vvv            eeeeeeeeeeeeee  mmmmmm   mmmmmm   mmmmmm\n" + 
				"");
		System.out.println("Aperte ENTER para continuar");
		String parar = in.nextLine();
	}
	
	public void escolherOpcao(Scanner in) {
		while(opcaoMenu!=0) {
			opcaoMenu= in.nextInt();
			if(opcaoMenu<0 || opcaoMenu>menuList.size()) {
				System.out.println("Digite uma opcao valida");
				continue;
			}
			//switch
			System.out.println("Ta aqui");
		}
	}
}
