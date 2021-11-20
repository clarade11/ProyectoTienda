package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Categoria;
import model.Perfil;
import model.Producto;
import model.ProductosEscogidos;

public class InicioController {

	public static Perfil usuario = new Perfil("Clara", "de la Cruz Rico", "Mujer");

	public static ArrayList<Producto> productoArray = new ArrayList();

	public static ObservableList<ProductosEscogidos> productosElegidos;
	public static ObservableList<Categoria> categorias;

	@FXML
	private TableView<Categoria> tableView;
	@FXML
	private TableColumn<Categoria, String> tcCategoria;

	@FXML
	private Button botonPerfil;
	@FXML
	private Button botonCarrito;
	
	@FXML
	private Text titulo;
	
	@FXML
	private GridPane gridpane;
	
	@FXML
	private Pane pane;
	
	@FXML
	private ScrollPane scrollpane;

	// imagenes de los productos
	@FXML
	private ImageView img1;
	@FXML
	private ImageView img2;
	@FXML
	private ImageView img3;
	@FXML
	private ImageView img4;
	@FXML
	private ImageView img5;
	@FXML
	private ImageView img6;
	@FXML
	private ImageView img7;
	@FXML
	private ImageView img8;

	// texto
	@FXML
	private Text text1;
	@FXML
	private Text text2;
	@FXML
	private Text text3;
	@FXML
	private Text text4;
	@FXML
	private Text text5;
	@FXML
	private Text text6;
	@FXML
	private Text text7;
	@FXML
	private Text text8;

	// precio
	@FXML
	private Text prec1;
	@FXML
	private Text prec2;
	@FXML
	private Text prec3;
	@FXML
	private Text prec4;
	@FXML
	private Text prec5;
	@FXML
	private Text prec6;
	@FXML
	private Text prec7;
	@FXML
	private Text prec8;

	// Cantidades
	@FXML
	private TextField tfCant1;
	@FXML
	private TextField tfCant2;
	@FXML
	private TextField tfCant3;
	@FXML
	private TextField tfCant4;
	@FXML
	private TextField tfCant5;
	@FXML
	private TextField tfCant6;
	@FXML
	private TextField tfCant7;
	@FXML
	private TextField tfCant8;

	// botones añadir al carrito
	@FXML
	private Button an1;
	@FXML
	private Button an2;
	@FXML
	private Button an3;
	@FXML
	private Button an4;
	@FXML
	private Button an5;
	@FXML
	private Button an6;
	@FXML
	private Button an7;
	@FXML
	private Button an8;

	@FXML
	private void initialize() {
		// AGREGAR ELEMENTOS EN CATALOGO DE CATEGORIAS
		tcCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

		productosElegidos = FXCollections.observableArrayList();
		categorias = FXCollections.observableArrayList();

		anadirProductos();
		

		tableView.setItems(categorias);

		final ObservableList<Categoria> tablaCategoria = tableView.getSelectionModel().getSelectedItems(); // lista
																											// personas
		tablaCategoria.addListener(selectorCatalogo);
	}

	

	// el escucha
	private final ListChangeListener<Categoria> selectorCatalogo = new ListChangeListener<Categoria>() {
		@Override
		public void onChanged(ListChangeListener.Change<? extends Categoria> c) {
			mostrarProductosDerecho(); // mostrar dato en el lado derecho de la persona
		}
	};

	// coger la categoria que el usuario seleccione
	private String categoriaSeleccionada() {
		if (tableView != null) {
			Categoria cat = tableView.getSelectionModel().getSelectedItem();
//			if (cat.size() == 1) {
//				final Categoria catSeleccionada = cat.get(0);
			return cat.getCategoria();
//			}
		}
		return "";

	}

	// mostrar productos
	private void mostrarProductosDerecho() {

		String categoriaCliente = categoriaSeleccionada();
		int N = tableView.getSelectionModel().getSelectedIndex();
//		System.out.println(N % 8);

		if (categoriaCliente != null) { // si pulsamos una categoria entra en el filtro
//			System.out.println(categoriaCliente);
			for (int i = N * 8; i < productoArray.size(); i++) {
//				System.out.println(productoArray.get(i).getCategoria().equals(categoriaCliente));
				if (productoArray.get(i).getCategoria().equals(categoriaCliente)) { // filtro por categoria
//					System.out.println("dentro");
					if (i % 8 == 0) {
//						System.out.println(productoArray.get(i).getUrlImagen());
						Image image1 = new Image(
								getClass().getResourceAsStream("/docs/" + productoArray.get(i).getUrlImagen()));
						img1.setImage(image1);
						text1.setText(productoArray.get(i).getNombre());
						prec1.setText(String.valueOf(productoArray.get(i).getPrecio()));

					} else if (i % 8 == 1) {
						Image image1 = new Image(
								getClass().getResourceAsStream("/docs/" + productoArray.get(i).getUrlImagen()));
						img2.setImage(image1);
						text2.setText(productoArray.get(i).getNombre());
						prec2.setText(String.valueOf(productoArray.get(i).getPrecio()));

					} else if (i % 8 == 2) {
						Image image1 = new Image(
								getClass().getResourceAsStream("/docs/" + productoArray.get(i).getUrlImagen()));
						img3.setImage(image1);
						text3.setText(productoArray.get(i).getNombre());
						prec3.setText(String.valueOf(productoArray.get(i).getPrecio()));

					} else if (i % 8 == 3) {
						Image image1 = new Image(
								getClass().getResourceAsStream("/docs/" + productoArray.get(i).getUrlImagen()));
						img4.setImage(image1);
						text4.setText(productoArray.get(i).getNombre());
						prec4.setText(String.valueOf(productoArray.get(i).getPrecio()));

					} else if (i % 8 == 4) {
						Image image1 = new Image(
								getClass().getResourceAsStream("/docs/" + productoArray.get(i).getUrlImagen()));
						img5.setImage(image1);
						text5.setText(productoArray.get(i).getNombre());
						prec5.setText(String.valueOf(productoArray.get(i).getPrecio()));

					} else if (i % 8 == 5) {
						Image image1 = new Image(
								getClass().getResourceAsStream("/docs/" + productoArray.get(i).getUrlImagen()));
						img6.setImage(image1);
						text6.setText(productoArray.get(i).getNombre());
						prec6.setText(String.valueOf(productoArray.get(i).getPrecio()));

					} else if (i % 8 == 6) {
						Image image1 = new Image(
								getClass().getResourceAsStream("/docs/" + productoArray.get(i).getUrlImagen()));
						img7.setImage(image1);
						text7.setText(productoArray.get(i).getNombre());
						prec7.setText(String.valueOf(productoArray.get(i).getPrecio()));

					} else if (i % 8 == 7) {
						Image image1 = new Image(
								getClass().getResourceAsStream("/docs/" + productoArray.get(i).getUrlImagen()));
						img8.setImage(image1);
						text8.setText(productoArray.get(i).getNombre());
						prec8.setText(String.valueOf(productoArray.get(i).getPrecio()));

						break;

					}
				}
			}
		} else {

		}

	}

	// BASE DE DATOS
	private void anadirProductos() {

		// categorias de los productos
		categorias.add(new Categoria("Teclados"));
		categorias.add(new Categoria("Ratones"));
		categorias.add(new Categoria("Monitores"));
		categorias.add(new Categoria("Auriculares"));
		categorias.add(new Categoria("Alfombrillas"));

		// teclados
		productoArray.add(new Producto("Mars Gaming Mecanico SX5856", 49.99, 0, "Teclados", "tecladoMarsGaming.jpg"));
		productoArray.add(new Producto("Toshiba M5426", 35.87, 0, "Teclados", "tecladoToshiba.png"));
		productoArray.add(new Producto("Empire Gaming K3042", 9.98, 0, "Teclados", "tecladoEmpireGaming.png"));
		productoArray.add(new Producto("Hivenets 87 teclas", 45.90, 0, "Teclados", "tecladoHivenets.png"));
		productoArray.add(new Producto("SteelSeries APJ8", 19.59, 0, "Teclados", "tecladoSteelSeries.jpg"));
		productoArray.add(new Producto("Newskill", 69.20, 0, "Teclados", "tecladoNewSkill.jpg"));
		productoArray.add(new Producto("Razer", 204.20, 0, "Teclados", "tecladoRazer.jpg"));
		productoArray.add(new Producto("Corsair K55", 39.40, 0, "Teclados", "tecladoCorsairK55.jpg"));
//		//ratones
		productoArray.add(new Producto("Mars Gaming", 9.10, 0, "Ratones", "ratonMarsGaming.jpg"));
		productoArray.add(new Producto("Lenovo X10", 5.50, 0, "Ratones", "ratonLenovo.jpg"));
		productoArray.add(new Producto("Empire Gaming", 4.10, 0, "Ratones", "ratonEmpireGaming.jpg"));
		productoArray.add(new Producto("Dilosde S42", 566.10, 0, "Ratones", "ratonDilosde.jpg"));
		productoArray.add(new Producto("Corsair ", 4.10, 0, "Ratones", "ratonCorsair.jpg"));
		productoArray.add(new Producto("Dilosde S20", 566.10, 0, "Ratones", "ratonDilosdeSX20.jpg"));
		productoArray.add(new Producto("Tecknet inalambrico", 12.50, 0, "Ratones", "tecknet.jpg"));
		productoArray.add(new Producto("Gaming con cable", 11.90, 0, "Ratones", "gaming.jpg"));
//		//pantallas
		productoArray.add(new Producto("Huawei Display 23.8",119.0,0,"Monitores","monitor1.jpg"));
		productoArray.add(new Producto("Msi Optic G217",169.0,0,"Monitores","monitor2.jpg"));
		productoArray.add(new Producto("Acer Nitro qcg1",109.0,0,"Monitores","monitor3.jpg"));
		productoArray.add(new Producto("Lg 24MG",139.0,0,"Monitores","monitor4.jpg"));
		productoArray.add(new Producto("HP M22F",129.0,0,"Monitores","monitor5.jpg"));
		productoArray.add(new Producto("AOC 24MB1H",99.89,0,"Monitores","monitor6.jpg"));
		productoArray.add(new Producto("HP X24iH",120.55,0,"Monitores","monitor7.jpg"));
		productoArray.add(new Producto("Philips model:2018",149.80,0,"Monitores","monitor8.jpg"));
		//auriculares
		productoArray.add(new Producto("Bluetooh unicornio",13.95,0,"Auriculares","auriculares1.jpg"));
		productoArray.add(new Producto("Philips inalambricos",23.50,0,"Auriculares","auriculares2.jpg"));
		productoArray.add(new Producto("True Wireless",14.50,0,"Auriculares","auriculares3.jpg"));
		productoArray.add(new Producto("Duendes fantasia",9.95,0,"Auriculares","auriculares4.jpg"));
		productoArray.add(new Producto("Logitech",59.99,0,"Auriculares","auriculares5.jpg"));
		productoArray.add(new Producto("Philips TH42CKO",39.30,0,"Auriculares","auriculares6.jpg"));
		productoArray.add(new Producto("HP 500",1199.0,0,"Auriculares","auriculares7.png"));
		productoArray.add(new Producto("Sony 2019",39.99,0,"Auriculares","auriculares8.jpg"));
		//alfombrillas
		productoArray.add(new Producto("Krom Konout XL",20.90,0,"Alfombrillas","alfombrilla1.jpg"));
		productoArray.add(new Producto("RuoCherg LED",19.95,0,"Alfombrillas","alfombrilla2.jpg"));
		productoArray.add(new Producto("NewSkill",17.95,0,"Alfombrillas","alfombrilla3.jpg"));
		productoArray.add(new Producto("GAME MM510",17.95,0,"Alfombrillas","alfombrilla4.png"));
		productoArray.add(new Producto("TEMPEX",12.95,0,"Alfombrillas","alfombrilla5.jpg"));
		productoArray.add(new Producto("ASUS",12.20,0,"Alfombrillas","alfombrilla6.jpg"));
		productoArray.add(new Producto("Corsair",4.95,0,"Alfombrillas","alfombrilla7.jpg"));
		productoArray.add(new Producto("MudeX",11.30,0,"Alfombrillas","alfombrilla8.jpg"));
		//consolas
//		productoArray.add(new Producto("",0,0,"Alfombrillas",""));
		//videojuegos
		
		
//		

	}

	// añadir cantidades al carrito
	@FXML
	private void anadirCarrito1(ActionEvent e) {
		procesoAnadirAlCarro(tfCant1, text1, prec1);
	}

	@FXML
	private void anadirCarrito2() {
		procesoAnadirAlCarro(tfCant2, text2, prec2);
	}

	@FXML
	private void anadirCarrito3() {
		procesoAnadirAlCarro(tfCant3, text3, prec3);
	}

	@FXML
	private void anadirCarrito4() {
		procesoAnadirAlCarro(tfCant4, text4, prec4);
	}

	@FXML
	private void anadirCarrito5() {
		procesoAnadirAlCarro(tfCant5, text5, prec5);
	}

	@FXML
	private void anadirCarrito6() {
		procesoAnadirAlCarro(tfCant6, text6, prec6);
	}

	@FXML
	private void anadirCarrito7() {
		procesoAnadirAlCarro(tfCant7, text7, prec7);
	}

	@FXML
	private void anadirCarrito8() {
		procesoAnadirAlCarro(tfCant8, text8, prec8);
	}

	public void procesoAnadirAlCarro(TextField tfCant, Text text, Text precio) {
		Integer cantidad_elegida = Integer.parseInt(tfCant.getText());
		String nombre_elegido = text.getText();
		Double precio_elegido = Double.parseDouble(precio.getText());

		productosElegidos.add(new ProductosEscogidos(nombre_elegido, cantidad_elegida, precio_elegido));

		// alerta
		Alert alert = new Alert(AlertType.INFORMATION, "Se ha añadido el producto a la cesta");
		alert.show();

		tfCant.clear();
		tfCant.setText("0");
	}

	// abrir ventana carrito
	public void compra() throws IOException {
		Stage stage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("/application/Compra.fxml"));
		Scene scene = new Scene(root,500,300);
		stage = new Stage(StageStyle.DECORATED);
		
		stage.setScene(scene);
		stage.setTitle("Mi carrito");
		stage.show();
	}

	// abrir ventana perfil
	public void perfil() throws IOException {
		Stage stage = new Stage();
		Pane root = FXMLLoader.load(getClass().getResource("/application/Perfil.fxml"));
		Scene scene = new Scene(root);
		stage = new Stage(StageStyle.DECORATED);
		stage.setScene(scene);
		stage.setTitle("Mi perfil");
		stage.show();
	}

}
