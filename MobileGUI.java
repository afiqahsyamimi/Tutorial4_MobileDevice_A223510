import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MobileGUI extends JFrame implements ActionListener
{
    private JComboBox<String> cboDevice;

    private JTextField txtManufacturer;
    private JTextField txtModel;
    private JTextField txtStation;
    private JTextField txtFrequency;

    private JButton btnDisplay;
    private JButton btnClear;

    private JTextArea txtOutput;

    public MobileGUI()
    {
        setTitle("Mobile Device App");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel title =
                new JLabel("MOBILE DEVICE APP",
                SwingConstants.CENTER);

        title.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(5,2));

        panel.add(new JLabel("Device Type"));

        cboDevice = new JComboBox<>();

        cboDevice.addItem("Smart Phone");
        cboDevice.addItem("Basic Phone");

        panel.add(cboDevice);

        panel.add(new JLabel("Manufacturer"));
        txtManufacturer = new JTextField();
        panel.add(txtManufacturer);

        panel.add(new JLabel("Model"));
        txtModel = new JTextField();
        panel.add(txtModel);

        panel.add(new JLabel("Station"));
        txtStation = new JTextField();
        panel.add(txtStation);

        panel.add(new JLabel("Frequency"));
        txtFrequency = new JTextField();
        panel.add(txtFrequency);

        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        btnDisplay = new JButton("Display");
        btnClear = new JButton("Clear");

        buttonPanel.add(btnDisplay);
        buttonPanel.add(btnClear);

        add(buttonPanel, BorderLayout.SOUTH);

        txtOutput = new JTextArea(8,20);
        txtOutput.setEditable(false);

        add(new JScrollPane(txtOutput),
                BorderLayout.EAST);

        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnDisplay)
        {
            String manufacturer =
                    txtManufacturer.getText();

            String model =
                    txtModel.getText();

            String station =
                    txtStation.getText();

            double frequency =
                    Double.parseDouble(
                            txtFrequency.getText());

            String device =
                    cboDevice.getSelectedItem()
                            .toString();

            if(device.equals("Smart Phone"))
            {
                SmartPhone sp =
                        new SmartPhone(
                                manufacturer,
                                model,
                                "Galaxy");

                sp.setStation(station);
                sp.setFrequency(frequency);

                txtOutput.setText(
                        "SmartPhone Detail:" +
                        "\nManufacturer: " +
                        manufacturer +
                        "\nModel: " +
                        model +
                        "\nType: Galaxy" +
                        "\nStation: " +
                        station +
                        "\nFrequency: " +
                        frequency);
            }

            else
            {
                BasicPhone bp =
                        new BasicPhone(
                                manufacturer,
                                model);

                bp.setStation(station);
                bp.setFrequency(frequency);

                txtOutput.setText(
                        "Basic Phone Detail:" +
                        "\nManufacturer: " +
                        manufacturer +
                        "\nModel: " +
                        model +
                        "\nStation: " +
                        station +
                        "\nFrequency: " +
                        frequency);
            }
        }

        if(e.getSource() == btnClear)
        {
            txtManufacturer.setText("");
            txtModel.setText("");
            txtStation.setText("");
            txtFrequency.setText("");
            txtOutput.setText("");
        }
    }

    public static void main(String[] args)
    {
        new MobileGUI();
    }
}

//References: Copilot