package be.digitalcity.java.exo.oo.zoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionZooGUI {
  private Zoo zoo;
  private JFrame frame;
  private JTextArea textArea;
  private JTextField nomEnclosField, capaciteField, nomAnimalField, especeField, nomEnclosDepartField, nomEnclosArriveeField;
  private JComboBox<Environnement> typeEnclosComboBox, typeAnimalComboBox;
  private JPanel panel;

  public GestionZooGUI() {
    zoo = new Zoo("Mon Zoo");
    initializeGUI();
  }

  private void initializeGUI() {
    frame = new JFrame("Gestion du Zoo");
    frame.setSize(600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel();
    panel.setLayout(new BorderLayout());

    textArea = new JTextArea();
    textArea.setEditable(false);
    panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(6, 1));

    JButton btnAjouterEnclos = new JButton("Ajouter un enclos");
    JButton btnAjouterAnimal = new JButton("Ajouter un animal");
    JButton btnDeplacerAnimal = new JButton("Déplacer un animal");
    JButton btnDeplacerAnimaux = new JButton("Déplacer les animaux d'un enclos");
    JButton btnAfficherEtat = new JButton("Afficher l'état du zoo");
    JButton btnQuitter = new JButton("Quitter");

    buttonPanel.add(btnAjouterEnclos);
    buttonPanel.add(btnAjouterAnimal);
    buttonPanel.add(btnDeplacerAnimal);
    buttonPanel.add(btnDeplacerAnimaux);
    buttonPanel.add(btnAfficherEtat);
    buttonPanel.add(btnQuitter);

    panel.add(buttonPanel, BorderLayout.WEST);

    frame.add(panel);
    frame.setVisible(true);

    btnAjouterEnclos.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ajouterEnclos();
      }
    });

    btnAjouterAnimal.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ajouterAnimal();
      }
    });

    btnDeplacerAnimal.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        deplacerAnimal();
      }
    });

    btnDeplacerAnimaux.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        deplacerAnimaux();
      }
    });

    btnAfficherEtat.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        afficherEtatZoo();
      }
    });

    btnQuitter.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
  }

  private void ajouterEnclos() {
    JPanel panelEnclos = new JPanel(new GridLayout(4, 2));
    panelEnclos.add(new JLabel("Nom de l'enclos:"));
    nomEnclosField = new JTextField();
    panelEnclos.add(nomEnclosField);

    panelEnclos.add(new JLabel("Type d'environnement:"));
    typeEnclosComboBox = new JComboBox<>(Environnement.values());
    panelEnclos.add(typeEnclosComboBox);

    panelEnclos.add(new JLabel("Capacité (laisser vide pour défaut):"));
    capaciteField = new JTextField();
    panelEnclos.add(capaciteField);

    int result = JOptionPane.showConfirmDialog(frame, panelEnclos, "Ajouter un enclos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
      String nom = nomEnclosField.getText();
      Environnement type = (Environnement) typeEnclosComboBox.getSelectedItem();
      String capaciteInput = capaciteField.getText();
      int capacite = capaciteInput.isEmpty() ? Enclos.CAPACITE_DEFAULT : Integer.parseInt(capaciteInput);

      Enclos enclos = capaciteInput.isEmpty() ? new Enclos(nom, type) : new Enclos(nom, type, capacite);
      zoo.ajouterEnclos(enclos);
      textArea.append("Enclos ajouté avec succès.\n");
    }
  }

  private void ajouterAnimal() {
    JPanel panelAnimal = new JPanel(new GridLayout(4, 2));
    panelAnimal.add(new JLabel("Nom de l'animal:"));
    nomAnimalField = new JTextField();
    panelAnimal.add(nomAnimalField);

    panelAnimal.add(new JLabel("Espèce de l'animal:"));
    especeField = new JTextField();
    panelAnimal.add(especeField);

    panelAnimal.add(new JLabel("Type de l'animal:"));
    typeAnimalComboBox = new JComboBox<>(Environnement.values());
    panelAnimal.add(typeAnimalComboBox);

    JPanel panelEnclos = new JPanel(new GridLayout(1, 2));
    panelEnclos.add(new JLabel("Nom de l'enclos:"));
    JTextField nomEnclosField = new JTextField();
    panelEnclos.add(nomEnclosField);

    int result = JOptionPane.showConfirmDialog(frame, new Object[]{panelAnimal, panelEnclos}, "Ajouter un animal", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
      String nom = nomAnimalField.getText();
      String espece = especeField.getText();
      Environnement type = (Environnement) typeAnimalComboBox.getSelectedItem();

      Animal animal = new Animal(nom, espece, type);
      String nomEnclos = nomEnclosField.getText();

      for (Enclos enclos : zoo.enclosSet) {
        if (enclos.nom.equals(nomEnclos)) {
          if (enclos.ajouterAnimal(animal)) {
            textArea.append(animal.nom + " ajouté à l'enclos " + enclos.nom + " avec succès.\n");
          } else {
            textArea.append("Impossible d'ajouter " + animal.nom + " (" + animal.type + ") à l'enclos " + enclos.nom + " (" + enclos.type + ").\n");
          }
          return;
        }
      }
      textArea.append("Enclos non trouvé.\n");
    }
  }

  private void deplacerAnimal() {
    JPanel panelDeplacementAnimal = new JPanel(new GridLayout(3, 2));
    panelDeplacementAnimal.add(new JLabel("Nom de l'animal à déplacer:"));
    JTextField nomAnimalField = new JTextField();
    panelDeplacementAnimal.add(nomAnimalField);

    panelDeplacementAnimal.add(new JLabel("Nom de l'enclos de départ:"));
    JTextField nomEnclosDepartField = new JTextField();
    panelDeplacementAnimal.add(nomEnclosDepartField);

    panelDeplacementAnimal.add(new JLabel("Nom de l'enclos d'arrivée:"));
    JTextField nomEnclosArriveeField = new JTextField();
    panelDeplacementAnimal.add(nomEnclosArriveeField);

    int result = JOptionPane.showConfirmDialog(frame, panelDeplacementAnimal, "Déplacer un animal", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
      String nomAnimal = nomAnimalField.getText();
      String nomEnclosDepart = nomEnclosDepartField.getText();
      String nomEnclosArrivee = nomEnclosArriveeField.getText();

      Enclos enclosDepart = null;
      Enclos enclosArrivee = null;

      for (Enclos enclos : zoo.enclosSet) {
        if (enclos.nom.equals(nomEnclosDepart)) {
          enclosDepart = enclos;
        }
        if (enclos.nom.equals(nomEnclosArrivee)) {
          enclosArrivee = enclos;
        }
      }

      if (enclosDepart == null || enclosArrivee == null) {
        textArea.append("Un ou plusieurs enclos non trouvés.\n");
        return;
      }

      for (Animal animal : enclosDepart.animaux) {
        if (animal.nom.equals(nomAnimal)) {
          if (enclosDepart.deplacerAnimal(animal, enclosArrivee)) {
            textArea.append(animal.nom + " déplacé avec succès vers " + enclosArrivee.nom + ".\n");
          } else {
            textArea.append("Impossible de déplacer " + animal.nom + ".\n");
          }
          return;
        }
      }
      textArea.append("Animal non trouvé dans l'enclos de départ.\n");
    }
  }

  private void deplacerAnimaux() {
    JPanel panelDeplacementAnimaux = new JPanel(new GridLayout(2, 2));
    panelDeplacementAnimaux.add(new JLabel("Nom de l'enclos de départ:"));
    nomEnclosDepartField = new JTextField();
    panelDeplacementAnimaux.add(nomEnclosDepartField);

    panelDeplacementAnimaux.add(new JLabel("Nom de l'enclos d'arrivée:"));
    nomEnclosArriveeField = new JTextField();
    panelDeplacementAnimaux.add(nomEnclosArriveeField);

    int result = JOptionPane.showConfirmDialog(frame, panelDeplacementAnimaux, "Déplacer les animaux", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
      String nomEnclosDepart = nomEnclosDepartField.getText();
      String nomEnclosArrivee = nomEnclosArriveeField.getText();

      Enclos enclosDepart = null;
      Enclos enclosArrivee = null;

      for (Enclos enclos : zoo.enclosSet) {
        if (enclos.nom.equals(nomEnclosDepart)) {
          enclosDepart = enclos;
        }
        if (enclos.nom.equals(nomEnclosArrivee)) {
          enclosArrivee = enclos;
        }
      }

      if (enclosDepart == null || enclosArrivee == null) {
        textArea.append("Un ou plusieurs enclos non trouvés.\n");
        return;
      }

      if (zoo.deplacerAnimaux(enclosDepart, enclosArrivee)) {
        textArea.append("Déplacement des animaux de l'enclos " + enclosDepart.nom + " ---> l'enclos " + enclosArrivee.nom + " réussi !\n");
      } else {
        textArea.append("Déplacement des animaux de l'enclos " + enclosDepart.nom + " ---> l'enclos " + enclosArrivee.nom + " impossible !\n");
      }
    }
  }

  private void afficherEtatZoo() {
    StringBuilder sb = new StringBuilder();
    sb.append("\nÉtat du Zoo:\n");
    sb.append("Zoo: ").append(zoo.nom).append("\n");

    for (Enclos enclos : zoo.enclosSet) {
      sb.append("\nEnclos: ").append(enclos.nom).append(" (").append(enclos.type.getValeur()).append(")\n");
      sb.append("Capacité: ").append(enclos.capacite).append("\n");
      sb.append("Animaux:\n");
      for (Animal animal : enclos.animaux) {
        sb.append("  - ").append(animal.nom).append(" (").append(animal.espece).append(")\n");
      }
    }

    textArea.setText(sb.toString());
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new GestionZooGUI());
  }
}

