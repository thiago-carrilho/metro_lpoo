package controller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

import DAO.UsersDAO;

public class Menu {
	protected LinkedList<LinkedHashMap<String, ChamarMetodoInterface>>
		menuList = new LinkedList<>();
	
	private int opcaoMenu=-1;
	
	public Menu() {
		//menuList.put("Logar", () -> UsersDAO.loginUser());
	}
	public void addOpcao(String opcao, Method metodo, Object obj, MenuWrapper wrapper) {
		//Adiciona uma opcao no ultimo menu criado.
		
		//menuList.get(menuList.size()-1).put(opcao, 
		//		this.getClass().getDeclaredMethod("printHelloWorld"));
		ChamarMetodoInterface inv = new ChamarMetodo();

	    inv.setMethod(metodo);
	    inv.setObj(obj);
	    inv.setWrapper(wrapper);
	    if(menuList.getLast()!=null) {
	    	this.menuList.getLast().put(opcao,inv);
	    }
	    else {
	    	LinkedHashMap<String, ChamarMetodoInterface> novo =
	    			new LinkedHashMap<String, ChamarMetodoInterface>();
	    	novo.put(opcao,inv);
	    	this.menuList.set(this.menuList.lastIndexOf(null), novo);
	    	//this.menuList.add(e)
	    	System.out.println("NULO" + this.menuList.getLast().toString());
	    }
	}
	public void addMenu() {//Cria um menu
//		LinkedHashMap<String, InvokesMethodItf> newHash = 
//				new LinkedHashMap<String, InvokesMethodItf>();
		menuList.add(null);
	}
	public void listarOpcoes(Scanner in) {
		int escolha=-1;
		for (int i = 0; i < menuList.size(); i++) {
			for (String textoOpcao : menuList.get(i).keySet()) {
				System.out.println((i+1) + " - " + textoOpcao);
				escolha = escolherOpcao(in, i);
			}
			
		}
	}
	public int escolherOpcao(Scanner in, int idArrayList) {
//		while(opcaoMenu!=0) {
			opcaoMenu= in.nextInt();
			while(opcaoMenu<0 || opcaoMenu>menuList.get(idArrayList).size()) {
				System.out.println("Digite uma opcao valida");
			}
			executarOpcao(idArrayList, opcaoMenu);
			
			System.out.println("Ta aqui");
			return opcaoMenu;
//		}
	}
	public void executarOpcao(int idArrayList, int idHashMap) {
		List<ChamarMetodoInterface> opcoes = new ArrayList<>(menuList.get(idArrayList).values());
		try {
			opcoes.get(idHashMap-1).invokeMethod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	
}
