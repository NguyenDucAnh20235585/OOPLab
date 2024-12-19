package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddItemToStoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    private JTextField title;
    private JTextField category;
    private JTextField cost;
    private ControllerScreen controller;

    public AddItemToStoreScreen(Store store, Cart cart, ControllerScreen controller) {
        this.store = store;
        this.cart = cart;
        this.controller = controller;

        setTitle("Add Item to Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Option");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookMenu = new JMenuItem("Add Book");
        addBookMenu.addActionListener(e -> controller.showAddBookScreen());
        smUpdateStore.add(addBookMenu);

        JMenuItem addCDMenu = new JMenuItem("Add CD");
        addCDMenu.addActionListener(e -> controller.showAddCDScreen());
        smUpdateStore.add(addCDMenu);

        JMenuItem addDVDMenu = new JMenuItem("Add DVD");
        addDVDMenu.addActionListener(e -> controller.showAddDVDScreen());
        smUpdateStore.add(addDVDMenu);

        menu.add(smUpdateStore);

        JMenuItem viewStoreMenu = new JMenuItem("View Store");
        viewStoreMenu.addActionListener(e -> controller.showStoreScreen());
        menu.add(viewStoreMenu);

        JMenuItem viewCartMenu = new JMenuItem("View Cart");
        viewCartMenu.addActionListener(e -> controller.showCartScreen());
        menu.add(viewCartMenu);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel titleLabel = new JLabel("AIMS");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 50));
        titleLabel.setForeground(Color.CYAN);

        JButton btnCart = new JButton("View Cart");
        btnCart.setPreferredSize(new Dimension(100, 50));
        btnCart.addActionListener(e -> controller.showCartScreen());

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(titleLabel);
        header.add(Box.createHorizontalGlue());
        header.add(btnCart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 2, 10, 10)); // 4 hàng, 2 cột

        JLabel titleLabel = new JLabel("Title:");
        title = new JTextField(15);
        center.add(titleLabel);
        center.add(title);

        JLabel categoryLabel = new JLabel("Category:");
        category = new JTextField(15);
        center.add(categoryLabel);
        center.add(category);

        JLabel costLabel = new JLabel("Cost:");
        cost = new JTextField(15);
        center.add(costLabel);
        center.add(cost);

        JButton addBtn = new JButton("Add Item");
        addBtn.addActionListener(e -> addMedia());
        center.add(new JLabel()); // Placeholder for alignment
        center.add(addBtn);

        return center;
    }

    private void addMedia() {
        String titleText = title.getText().trim();
        String categoryText = category.getText().trim();
        String costText = cost.getText().trim();

        if (titleText.isEmpty() || categoryText.isEmpty() || costText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            float costValue = Float.parseFloat(costText);
            DigitalVideoDisc newDVD = new DigitalVideoDisc(titleText, categoryText, costValue);
            store.addMedia(newDVD);
            JOptionPane.showMessageDialog(this, "Item added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid cost value!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        title.setText("");
        category.setText("");
        cost.setText("");
    }
}
