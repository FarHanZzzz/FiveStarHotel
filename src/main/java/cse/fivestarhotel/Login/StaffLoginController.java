package cse.fivestarhotel.Login;

import cse.fivestarhotel.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class StaffLoginController {
    @javafx.fxml.FXML
    private PasswordField StaffPasswordField;
    @javafx.fxml.FXML
    private ComboBox<String> positionComboBox;
    @javafx.fxml.FXML
    private TextField StaffIdTextField;





    // Called when the FXML is loaded
    @javafx.fxml.FXML
    public void initialize() {

        positionComboBox.getItems().addAll("CEO", "Head Manager","Front Desk Staff","Restaurant Manager","Room Service Manager","Room Service Worker","Electrician");
        // Create the binary file with hardcoded data (overwrite existing data)
        frontDeskStaffWrite();
        headmanagerWrite();
        resmanagerWrite();
        roommanagerWrite();
        roomeorkerWrite();
        ceoWrite();
    }






    // Method to create and write hardcoded FrontDeskStaff data
    public ObservableList<FrontDeskStaff> frontDeskStaffWrite() {
        // Hardcoded values
        String id1 = "Farhan";
        String password1 = "1234";

        ObservableList<FrontDeskStaff> frontDeskStaffList = FXCollections.observableArrayList();

        // Adding FrontDeskStaff objects to the list
        frontDeskStaffList.add(new FrontDeskStaff(id1, password1));

        // Overwrite file instead of appending
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FrontDeskStaff.bin", false))) {
            for (FrontDeskStaff staff : frontDeskStaffList) {
                oos.writeObject(staff); // Write each object to the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return frontDeskStaffList;

    }



    public ObservableList<HotelHeadManager> headmanagerWrite() {
        // Hardcoded values
        String headid = "Jenin";
        String headpass = "2222";

        ObservableList<HotelHeadManager> headmanagerList = FXCollections.observableArrayList();

        // Adding FrontDeskStaff objects to the list
        headmanagerList.add(new HotelHeadManager(headid, headpass));

        // Overwrite file instead of appending
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("HotelHeadManager.bin", false))) {
            for (HotelHeadManager head : headmanagerList) {
                oos.writeObject(head); // Write each object to the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return headmanagerList;

    }


    public ObservableList<RestaurantManager> resmanagerWrite() {
        // Hardcoded values
        String resid = "Sadeque";
        String respass = "mama";

        ObservableList<RestaurantManager> resmanagerList = FXCollections.observableArrayList();

        // Adding FrontDeskStaff objects to the list
        resmanagerList.add(new RestaurantManager(resid,respass));

        // Overwrite file instead of appending
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("RestaurantManager.bin", false))) {
            for (RestaurantManager res : resmanagerList) {
                oos.writeObject(res); // Write each object to the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resmanagerList;

    }

    public ObservableList<RoomServiceManager> roommanagerWrite() {

        String roomid = "Rehnuma";
        String roompass = "3333";

        ObservableList<RoomServiceManager> roommanagerList = FXCollections.observableArrayList();

        roommanagerList.add(new RoomServiceManager(roomid,roompass));


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("RoomManager.bin", false))) {
            for (RoomServiceManager room : roommanagerList) {
                oos.writeObject(room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return roommanagerList;

    }


    public ObservableList<RoomServiceWorker> roomeorkerWrite() {

        String roomWid = "Rose";
        String roomWpass = "4444";

        ObservableList<RoomServiceWorker> roomworkerList = FXCollections.observableArrayList();

        roomworkerList.add(new RoomServiceWorker(roomWid,roomWpass));


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("RoomWorker.bin", false))) {
            for (RoomServiceWorker roomW : roomworkerList) {
                oos.writeObject(roomW);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return roomworkerList;

    }


    public ObservableList<CEO> ceoWrite() {

        String ceoid = "Rafid";
        String ceopass = "ayo";

        ObservableList<CEO> ceoList = FXCollections.observableArrayList();

        ceoList.add(new CEO(ceoid,ceopass));


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("CEO.bin", false))) {
            for (CEO c : ceoList) {
                oos.writeObject(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ceoList;

    }







    // Action handler for the login button
    @javafx.fxml.FXML
    public void StaffLogInOnAction(ActionEvent actionEvent) {
        String id = StaffIdTextField.getText();
        String password = StaffPasswordField.getText();
        String position = positionComboBox.getValue();

        if (position == null || id.isEmpty() || password.isEmpty()) {   //empty check
            System.out.println("Please fill in all fields.");
            return;
        }

        if (position.equals("Front Desk Staff")) {    // verify
            ObservableList<FrontDeskStaff> staffList = frontDeskStaffRead();

            boolean isAuthenticated = staffList.stream()
                    .anyMatch(staff -> staff.getId().equals(id) && staff.getPassword().equals(password));

            if (isAuthenticated) {   // go to dashboard
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/FrontDeskStaff/FrontDeskStaffDashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
                    stage.setTitle("FrontDeskStaff Dashboard");
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {

                System.out.println("Invalid ID or password.");
            }


        } else if (position.equals("Head Manager")) {    // verify Hotel Head Manager
            ObservableList<HotelHeadManager> headList = headmanagerRead();

            boolean isAuthenticated = headList.stream()
                    .anyMatch(head -> head.getId().equals(id) && head.getPassword().equals(password));

            if (isAuthenticated) {   // go to dashboard
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/HotelHeadManager/HeadManagerDashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
                    stage.setTitle("Head Manager Dashboard");
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {

                System.out.println("Invalid ID or password.");
            }



        } else if (position.equals("Restaurant Manager")) {    // verify Hotel Head Manager
            ObservableList<RestaurantManager> resList = resManagerRead();

            boolean isAuthenticated = resList.stream()
                    .anyMatch(res -> res.getId().equals(id) && res.getPassword().equals(password));

            if (isAuthenticated) {   // go to dashboard
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RestaurantManager/RestaurantManagerDashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
                    stage.setTitle("Restaurant Manager Dashboard");
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {

                System.out.println("Invalid ID or password.");
            }


        } else if (position.equals("Room Service Manager")) {    // verify Hotel Head Manager
            ObservableList<RoomServiceManager> roomList = roomManagerRead();

            boolean isAuthenticated = roomList.stream()
                    .anyMatch(room -> room.getId().equals(id) && room.getPassword().equals(password));

            if (isAuthenticated) {   // go to dashboard
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RoomServiceManager/RoomServiceManagerDashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
                    stage.setTitle("Room Service Manager Dashboard");
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {

                System.out.println("Invalid ID or password.");
            }


        } else if (position.equals("CEO")) {    // verify Hotel Head Manager
            ObservableList<CEO> ceoList = ceoRead();

            boolean isAuthenticated = ceoList.stream()
                    .anyMatch(c -> c.getId().equals(id) && c.getPassword().equals(password));

            if (isAuthenticated) {   // go to dashboard
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/CEO/CEODashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
                    stage.setTitle("CEO Dashboard");
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {

                System.out.println("Invalid ID or password.");
            }



        } else if (position.equals("Room Service Worker")) {    // verify Hotel Head Manager
            ObservableList<RoomServiceWorker> roomWList = roomworkerRead();

            boolean isAuthenticated = roomWList.stream()
                    .anyMatch(roomW -> roomW.getId().equals(id) && roomW.getPassword().equals(password));

            if (isAuthenticated) {   // go to dashboard
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/RoomServiceWorker/RoomServiceWorkerDashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
                    stage.setTitle("Room Service Worker Dashboard");
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {

                System.out.println("Invalid ID or password.");
            }




        } else {
            System.out.println("Invalid position selected.");
        }


    }









    // read FrontDeskStaff data
    public ObservableList<FrontDeskStaff> frontDeskStaffRead() {
        ObservableList<FrontDeskStaff> frontDeskStaffList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FrontDeskStaff.bin"))) {
            while (true) {
                frontDeskStaffList.add((FrontDeskStaff) ois.readObject());
            }
        } catch (EOFException eof) {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return frontDeskStaffList;
    }


    // read Head Manager data
    public ObservableList<HotelHeadManager> headmanagerRead() {
        ObservableList<HotelHeadManager> headmanagerList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HotelHeadManager.bin"))) {
            while (true) {
                headmanagerList.add((HotelHeadManager) ois.readObject());
            }
        } catch (EOFException eof) {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return headmanagerList;
    }

    // read Restaurant Manager data
    public ObservableList<RestaurantManager> resManagerRead() {
        ObservableList<RestaurantManager> resmanagerList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("RestaurantManager.bin"))) {
            while (true) {
                resmanagerList.add((RestaurantManager) ois.readObject());
            }
        } catch (EOFException eof) {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resmanagerList;
    }


    // read Restaurant Manager data
    public ObservableList<RoomServiceManager> roomManagerRead() {
        ObservableList<RoomServiceManager> roommanagerList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("RoomManager.bin"))) {
            while (true) {
                roommanagerList.add((RoomServiceManager) ois.readObject());
            }
        } catch (EOFException eof) {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return roommanagerList;
    }

    public ObservableList<RoomServiceWorker> roomworkerRead() {
        ObservableList<RoomServiceWorker> roomworkerList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("RoomWorker.bin"))) {
            while (true) {
                roomworkerList.add((RoomServiceWorker) ois.readObject());
            }
        } catch (EOFException eof) {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return roomworkerList;
    }


    public ObservableList<CEO> ceoRead() {
        ObservableList<CEO> ceoList = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("CEO.bin"))) {
            while (true) {
                ceoList.add((CEO) ois.readObject());
            }
        } catch (EOFException eof) {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ceoList;
    }








    @javafx.fxml.FXML
    public void FromStaffReturnToSigninOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/cse/fivestarhotel/Login/Signin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
    }

}



