package ui;

import exceptions.EmptyTitleException;
import exceptions.EmptyWebsiteException;
import model.Manhua;
import model.ManhuaList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// Citation: Code sourced and modified from C3-LectureLabStarter-IntersectionGUI class, DrawingEditor.java-
//           DrawingEditor class, Oracle Java Tutorials Documentation(How to Use Lists, Introduction to Event Listeners,
//           Using Swing Components: Examples)
// Manhua reading list application's GUI
public class ManhuaReadingListGUI extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;

    private static final String JSON_STORE = "./data/manhualist.json";
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private ManhuaList manhuaList;

    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton addManhuaButton;
    private JButton removeManhuaButton;
    private JButton viewAllManhuaButton;
    private JButton saveManhuaButton;
    private JButton loadManhuaButton;
    private JFrame frame;
    private JList jlist;
    private DefaultListModel<String> listModel;

    // EFFECTS: initializes fields, graphics, user interaction;
    //          assigns JFrame this object
    public ManhuaReadingListGUI() {
        super("Manhua Reading List");
        frame = this;
        initializeFields();
        initializeGraphics();
        initializeUserInteraction();
    }

    // EFFECTS: set the orientation panels;
    //          constructs all buttons, lists, text fields, and json objects.
    private void initializeFields() {
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        addManhuaButton = new JButton("Add Manhua");
        removeManhuaButton = new JButton("Remove Manhua");
        viewAllManhuaButton = new JButton("View Reading List");
        saveManhuaButton = new JButton("Save Reading List");
        loadManhuaButton = new JButton("Load Reading List");
        listModel = new DefaultListModel<>();
        jlist = new JList(listModel);
        manhuaList = new ManhuaList("My Manhua Reading List");
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
    }

    // MODIFIES: this
    // EFFECTS: draws the JFrame with panels and its assigned features
    private void initializeGraphics() {
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setBothPanels();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // EFFECTS: adds all the buttons to the top panel of the box layout (this is usually default display)
    private void setTopPanel() {
        topPanel.setOpaque(false);
        topPanel.add(addManhuaButton);
        topPanel.add(removeManhuaButton);
        topPanel.add(saveManhuaButton);
        topPanel.add(loadManhuaButton);
    }

    // EFFECTS: adds panel scroller, viewAll button, and panel with given features
    private void setBottomPanel() {
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(jlist, BorderLayout.CENTER);
        bottomPanel.add(viewAllManhuaButton, BorderLayout.SOUTH);

        JScrollPane scroller = new JScrollPane(jlist);
        bottomPanel.add(scroller);
        scroller.setPreferredSize(new Dimension(500, 350));
        scroller.setViewportView(jlist);

        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlist.setLayoutOrientation(JList.VERTICAL);
    }

    // EFFECTS: sets the top and bottom panel;
    //          set background
    private void setBothPanels() {
        frame.setContentPane(new JLabel(new ImageIcon("./data/backgroundImage.jpg")));
        frame.setLayout(new FlowLayout());
        setTopPanel();
        frame.add(topPanel);
        setBottomPanel();
        frame.add(bottomPanel);
    }

    // EFFECTS: initializes all buttons for user interaction
    private void initializeUserInteraction() {
        initializeAddManhuaButton();
        initializeRemoveManhuaButton();
        initializeViewAllManhuaButton();
        initializeSaveManhuaButton();
        initializeLoadManhuaButton();

    }

    // MODIFIES: this
    // EFFECTS: initializes add button
    private void initializeAddManhuaButton() {
        addManhuaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String manhuaTitle = JOptionPane.showInputDialog(jlist, "Enter a manhua title: ");
                String manhuaWebsite = JOptionPane.showInputDialog(jlist, "Enter the corresponding website: ");
                if (!(manhuaTitle == null) && !(manhuaWebsite == null)) {
                    try {
                        Manhua manhua = new Manhua(manhuaTitle, manhuaWebsite);
                        if (manhuaList.containsManhua(manhua.getTitle(), manhua.getWebsite())) {
                            JOptionPane.showMessageDialog(frame, "Manhua already exists.");
                        }
                        manhuaList.addManhua(manhua);
                        listModel.addElement(manhua.toFormat());
                        JOptionPane.showMessageDialog(frame, "Manhua successfully added!");
                    } catch (EmptyTitleException emptyTitleException) {
                        JOptionPane.showMessageDialog(frame, "Invalid");
                    } catch (EmptyWebsiteException emptyWebsiteException) {
                        JOptionPane.showMessageDialog(frame, "Invalid");
                    }
                }
            }
        });
    }

    // EFFECTS: initializes remove button
    private void initializeRemoveManhuaButton() {
        removeManhuaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String manhuaTitle = JOptionPane.showInputDialog(jlist,
                        "Enter the manhua's title to remove: ");
                if (manhuaList.getManhua(manhuaTitle) == null) {
                    JOptionPane.showMessageDialog(frame, "Cannot find the manhua to remove.");
                    } else {
                    listModel.removeElement(manhuaList.getManhua(manhuaTitle));
                    manhuaList.removeManhua(manhuaList.getManhua(manhuaTitle));
                    JOptionPane.showMessageDialog(frame, "Manhua successfully removed!");
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: initializes view all button
    private void initializeViewAllManhuaButton() {
        viewAllManhuaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.clear();
                for (Manhua manhua : manhuaList.getManhuaList()) {
                    String manhuaFormatted = manhua.toFormat();
                    listModel.addElement(manhuaFormatted);
                }
            }
        });
    }

    // EFFECTS: initializes save button
    private void initializeSaveManhuaButton() {
        saveManhuaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(manhuaList);
                    jsonWriter.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(frame, "Reading List Saved!");
                listModel.clear();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: initializes load button
    private void initializeLoadManhuaButton() {
        loadManhuaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listModel.clear();
                try {
                    manhuaList = jsonReader.read();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                ArrayList<Manhua> maList = manhuaList.getManhuaList();
                for (Manhua manhua : maList) {
                    String manhuaFormatted = manhua.toFormat();
                    listModel.addElement(manhuaFormatted);
                }
            }
        });
    }

    public static void main(String[] args) {
        new ManhuaReadingListGUI();
    }
}
