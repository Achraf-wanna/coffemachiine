package application;




import java.awt.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import com.coffeemachine.controllers.MachineController;
import com.coffeemachine.controllers.ProductController;
import com.coffeemachine.controllers.TechnicianController;
import com.coffeemachine.models.Machine;
import com.coffeemachine.models.Product;
import com.coffeemachine.models.Technician;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController implements Initializable{

	    @FXML
	    private TextField Nom;

	    @FXML
	    private TextField Phone;

	    @FXML
	    private TextField Ref;

	    @FXML
	    private TextField AccessCode;
	    
	    @FXML
	    private TableView<Technician> tech_table;
	    
	    @FXML
	    private TableColumn<Technician, Long> id;

	    @FXML
	    private TableColumn<Technician, String> name;

	    @FXML
	    private TableColumn<Technician, String> phone;

	    @FXML
	    private TableColumn<Technician, String> idRF;

	    @FXML
	    private TableColumn<Technician, String> code;
	    
	    @FXML
	    private Button addtechnicien;
	    
	    @FXML
	    private Label error;
	    
	    
	    //declaration
	    TechnicianController tech ;
	    Technician technician;   
	    public  ObservableList<Technician> tech_list = FXCollections.observableArrayList();
	    
	  
	    // Adding data to the ObservableList (technician)
	    public void AddTechnician() throws Exception {
	    	
	    		//generate random id
	  		    Random rd = new Random();
	  	        long id1 = (long)(rd.nextDouble()*100000000L);
	  	        
	  	        technician = new Technician();
	    		tech = new TechnicianController();
		    	tech_list.add(new Technician(id1,Nom.getText(),Phone.getText(),Ref.getText(),AccessCode.getText()));
		    	
//		    	clearInputs ();
		    	
		    	System.out.println(tech_list);
		    	loadTechnicianData();
	    	
	    } 
	    
	    
//	    //Clearing data from the inputs (technician)
//	 	public void clearInputs () {
//	 		Nom.clear();
//	 		Phone.clear();
//	 		Ref.clear();
//	 		AccessCode.clear();
//	 	}
//	 	
	 	
	 	// Initialise the table view culums to match the attr of the class(technician)
	    public void initialize (URL url , ResourceBundle rb) {
	    	id.setCellValueFactory(new PropertyValueFactory<>("id"));
	    	name.setCellValueFactory(new PropertyValueFactory<>("name"));
	    	phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
	    	idRF.setCellValueFactory(new PropertyValueFactory<>("idRef"));
	    	code.setCellValueFactory(new PropertyValueFactory<>("accessCode"));
	    
	    }

        //load data from the array list (technician)
		public void loadTechnicianData() {
			tech_table.setItems(tech_list);
			initialize(null, null);
		}
	    	
		
	
		/////////////////////////////////// product section //////////////////////////////////////////
		
		
		
		 @FXML
		 private TableView<Product> product_table;

		 @FXML
		 private TableColumn<Product, Long> product_id;

		 @FXML
		 private TableColumn<Product, String> product_name;
		 
		 @FXML
		 private TableColumn<Product, Double> product_price;

		 @FXML
		 private TextField product_price1;

		 @FXML
		 private TextField prduct_name1;

		 @FXML
		 private Button add_product;
		 
		  @FXML
		    private Label error1;
		    
		   
		//declaration
		    ProductController product_cnotroller ;
		    Product product;   
		    ObservableList<Product> product_list = FXCollections.observableArrayList();
		    
		    
		// Adding data to the ObservableList (product)
		    public void AddProduct() throws Exception {
		    	if(prduct_name1.getText().isEmpty() || product_price1.getText().isEmpty()) {
		    		error1.setText("please fill all the inputs");
		    	}else {
		    		//generate random id
		  		    Random rd = new Random();
		  	        long id1 = (long)(rd.nextDouble()*100000000L);
		  	        
		  	      // product = new Product();
		  	        product_cnotroller = new ProductController();
		  	        product_list.add(new Product(id1,prduct_name1.getText() ,  Double.parseDouble(product_price1.getText()) )); 
		  	        
		  	        error1.setText("Poduct is added ");
//		  	        clearProductInputs ();
//			    	
		  	        System.out.println(product_list);
		  	        loadProductData();
		    		
		    	}
		    } 
	    
//		  //Clearing data from the inputs (product)
//		 	public void clearProductInputs () {
//		 		prduct_name1.clear();
//		 		product_price1.clear();
//		 		
//		 	}
		 		 		
			public void initialize1(URL url, ResourceBundle rb) {
				product_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		    	product_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		    	product_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		    	
			}
			
			
		    //load data from the array list (product)
			public void loadProductData() {
				product_table.setItems(product_list);
				initialize1(null, null);
			}
			
			
			
        /////////////////////////////////// product section //////////////////////////////////////////
			
			
			 @FXML
			    private TextField machine_change;

			    @FXML
			    private Button add_machine;

			    @FXML
			    private Label error2;

			    @FXML
			    private ComboBox<?> product_list1;

			    @FXML
			    private TableView<Machine> machine_table;
			    
			    @FXML
			    private TableColumn<Machine, Long> machine_id;
			    
			    @FXML
			    private TableColumn<Machine, Boolean> isTurnedOn;

			    @FXML
			    private TableColumn<Machine, Double> sumChange;

			    @FXML
			    private TableColumn<Machine, List> products;

			  //declaration
			    MachineController machine_cnotroller ;
			    Machine machine;   
			    ObservableList<Machine> machine_list = FXCollections.observableArrayList();
			    
			 // Adding data to the ObservableList (product)
			    public void AddMachine() throws Exception {
			   
			    		//generate random id
			  		    Random rd = new Random();
			  	        long id2 = (long)(rd.nextDouble()*100000000L);
			  	        
			  	      // product = new Product();
			  	        machine_cnotroller = new MachineController();
			  	        machine = new Machine(id2);
			  	        machine_list.add(machine); 
			  	        
			  	        error2.setText("Machine is added ");    
			  	        System.out.println(machine_list);
			  	        
			  	
			  	        loadMachinetData();		
			    	
			    }
			    
			 
			    
			    public void initialize2(URL url, ResourceBundle rb) {
			    	machine_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			    	isTurnedOn.setCellValueFactory(new PropertyValueFactory<>("isTurnedOn"));
					sumChange.setCellValueFactory(new PropertyValueFactory<>("sumChange"));
			    	products.setCellValueFactory(new PropertyValueFactory<>("products"));
			    	
				}
			    
			  //load data from the array list (product)
				public void loadMachinetData() {
					machine_table.setItems(machine_list);
					initialize2(null, null);
				}
			    
			    
}