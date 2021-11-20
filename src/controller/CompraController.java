package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.ProductosEscogidos;

public class CompraController {
	
	@FXML
	private TableView<ProductosEscogidos> tableView;
	@FXML
	private TableColumn<ProductosEscogidos, String> tcProducto;
	@FXML
	private TableColumn<ProductosEscogidos, Double> tcPrecio;
	
	@FXML
	private Pane panel;
	
	@FXML
	private Label lbTotal;
	
	@FXML
	private CheckBox checkRegalo;
	@FXML
	private Text precioFinal;
	@FXML
	private Button botonComprar;
	
	@FXML
	private void initialize() {

		panel.getStylesheets().add("/application/compra.css");
		// AGREGAR ELEMENTOS EN CATALOGO DE CATEGORIAS
		tcProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		tcPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

		ObservableList<ProductosEscogidos> listaProductos = InicioController.productosElegidos;

		ladoDerecho(listaProductos);

		tableView.setItems(listaProductos);

	}
	
	private void ladoDerecho(ObservableList<ProductosEscogidos> lista) {
		
		Double precioFinalCarrito=0.0;
		
		//sumamos cesta
		for(int i=0; i<lista.size();i++) {
			int cantidad=lista.get(i).getCantidad();
			Double precio=lista.get(i).getPrecio();
			
			Double operacion = cantidad*precio;
			
			precioFinalCarrito+=operacion;
			
		}
		
		precioFinal.setText(String.valueOf(precioFinalCarrito));
	}
	
	
	@FXML
	private void finalizar() {
		tableView.getItems().clear();
		precioFinal.setText("0");
		checkRegalo.setSelected(false);
		
	}
	

}
