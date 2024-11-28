import java.awt.*;
import java.awt.event.*;

class Doctor extends Frame {
    Image backgroundImage;

    Doctor() {
        setTitle("Doctor Login");

        // Setting up labels, text fields, and buttons
        Label l1 = new Label("USERNAME:");
        Label l2 = new Label("PASSWORD:");

        TextField t1 = new TextField(15);
        TextField t2 = new TextField(15);
        t2.setEchoChar('*'); // Mask password input

        Button b1 = new Button("LOGIN");
        Button b2 = new Button("CANCEL");

        b1.setBackground(Color.GRAY);
        b2.setBackground(Color.GRAY);

        l1.setBounds(400, 200, 90, 20);
        t1.setBounds(500, 200, 110, 20);
        l2.setBounds(400, 240, 90, 20);
        t2.setBounds(500, 240, 110, 20);
        b1.setBounds(420, 280, 70, 20);
        b2.setBounds(500, 280, 70, 20);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(b2);

        // Frame settings
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        // Load background image
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        backgroundImage = toolkit.getImage("sphoto.jpg");

        // Button actions
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t1.getText().isEmpty() || t2.getText().isEmpty()) {
                    showErrorDialog("Please enter username and password.");
                } else {
                    dispose();
                    DoctorAppointment nextPage = new DoctorAppointment();
                    nextPage.setVisible(true);
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // Override paint method to draw the background image
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
    }

    // Helper method for error dialog
    private void showErrorDialog(String message) {
        Dialog dialog = new Dialog(this, "Error", true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label(message));
        dialog.setSize(300, 100);
        dialog.setLocationRelativeTo(this);

        Button closeButton = new Button("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.add(closeButton);
        dialog.setVisible(true);
    }
}

class DoctorAppointment extends Frame {
    Image backgroundImage;

    DoctorAppointment() {
        setTitle("Doctor Appointment");

        // Setting up labels, text fields, and components
        Label nameLabel = new Label("Name:");
        TextField nameTextField = new TextField();

        Label sexLabel = new Label("Sex:");
        CheckboxGroup sexCheckboxGroup = new CheckboxGroup();
        Checkbox maleCheckbox = new Checkbox("Male", sexCheckboxGroup, true);
        Checkbox femaleCheckbox = new Checkbox("Female", sexCheckboxGroup, false);

        Label dobLabel = new Label("Date of Birth:");
        TextField dobTextField = new TextField();

        Label contactLabel = new Label("Contact Number:");
        TextField contactTextField = new TextField();

        Label addressLabel = new Label("Address:");
        TextField addressTextField = new TextField();

        Button submitButton = new Button("Submit");

        // Setting bounds
        nameLabel.setBounds(400, 150, 100, 20);
        nameTextField.setBounds(500, 150, 200, 20);
        sexLabel.setBounds(400, 190, 100, 20);
        maleCheckbox.setBounds(500, 190, 60, 20);
        femaleCheckbox.setBounds(570, 190, 70, 20);
        dobLabel.setBounds(400, 230, 100, 20);
        dobTextField.setBounds(500, 230, 200, 20);
        contactLabel.setBounds(400, 270, 100, 20);
        contactTextField.setBounds(500, 270, 200, 20);
        addressLabel.setBounds(400, 310, 100, 20);
        addressTextField.setBounds(500, 310, 200, 20);
        submitButton.setBounds(450, 370, 100, 30);

        add(nameLabel);
        add(nameTextField);
        add(sexLabel);
        add(maleCheckbox);
        add(femaleCheckbox);
        add(dobLabel);
        add(dobTextField);
        add(contactLabel);
        add(contactTextField);
        add(addressLabel);
        add(addressTextField);
        add(submitButton);

        // Frame settings
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        // Load background image
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        backgroundImage = toolkit.getImage("fn.jpg");

        // Button action
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nameTextField.getText().isEmpty() || dobTextField.getText().isEmpty() || contactTextField.getText().isEmpty() || addressTextField.getText().isEmpty()) {
                    showErrorDialog("Please fill in all fields.");
                } else {
                    showInfoDialog("Appointment submitted successfully!");
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // Override paint method to draw the background image
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
    }

    // Helper methods for dialogs
    private void showErrorDialog(String message) {
        Dialog dialog = new Dialog(this, "Error", true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label(message));
        dialog.setSize(300, 100);
        dialog.setLocationRelativeTo(this);

        Button closeButton = new Button("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.add(closeButton);
        dialog.setVisible(true);
    }

    private void showInfoDialog(String message) {
        Dialog dialog = new Dialog(this, "Information", true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label(message));
        dialog.setSize(300, 100);
        dialog.setLocationRelativeTo(this);

        Button closeButton = new Button("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.add(closeButton);
        dialog.setVisible(true);
    }
}

public class Appointment {
    public static void main(String[] args) {
    }
}
