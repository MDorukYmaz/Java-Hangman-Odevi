package com.mycompany.prog2odev2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class NewJFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NewJFrame.class.getName());

    // GLOBAL TANIMLAMA
    String resDizin = "C:\\P2Oyun\\Resimler";
    String txtDizin = "C:\\P2Oyun\\TXTDosyalar";
    String kelimeDosya = txtDizin + "\\kelimeler.txt";
    String sifreDosya = txtDizin + "\\sifre.txt";
    String logDosya = txtDizin + "\\log.txt";
    String oyunDosya = txtDizin + "\\oyunlar.txt";

    Random rnd = new Random();
    java.text.SimpleDateFormat tarihFmt = new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    javax.swing.JPanel panel1;
    javax.swing.JLabel label1;
    javax.swing.JLabel label2;
    javax.swing.JLabel label3;
    javax.swing.JTextField textfield1;
    javax.swing.JTextField textfield2;
    javax.swing.JButton button1;
    javax.swing.JButton button2;
    javax.swing.JButton button3;

    DefaultTableModel skorMdl;
    javax.swing.JTable table1;
    javax.swing.JButton button4;

    DefaultTableModel logMdl;
    javax.swing.JTable table2;
    javax.swing.JButton button5;

    List<String> kelimeler;
    List<javax.swing.JLabel> harfLbls;
    String secKelime = "";
    int yanlisAdet = 0;
    int gecSure = 0;
    boolean oyunBitti = false;
    Timer timer1;

    public NewJFrame() {
        initComponents();
        klasorvedosyalarihazirla();
        if (!sifrekontrolakisi()) {
            dispose();
            System.exit(0);
        }
        arayuzkur();
        kelimeyukle();
        skoryukle();
        logyukle();
        oyunbslt();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Oyun Oynama", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Eski Skorlar", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Loglar", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void arayuzkur() {
        setTitle("Adam Asmaca");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 550);
        setLocationRelativeTo(null);
        jTabbedPane1.removeAll();
        menuyuolustur();
        tablariolustur();
    }

    private void menuyuolustur() {
        javax.swing.JMenuBar menubar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu menu1 = new javax.swing.JMenu("Oyun");
        javax.swing.JMenuItem menuitem1 = new javax.swing.JMenuItem("Oyuna Basla");
        javax.swing.JMenuItem menuitem2 = new javax.swing.JMenuItem("Oyunu Yeniden Baslat");
        javax.swing.JMenuItem menuitem3 = new javax.swing.JMenuItem("Cikis");

        menuitem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                oyunbslt();
            }
        });
        menuitem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                oyunbslt();
            }
        });
        menuitem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        menu1.add(menuitem1);
        menu1.add(menuitem2);
        menu1.add(menuitem3);
        menubar1.add(menu1);
        setJMenuBar(menubar1);
    }

    private void tablariolustur() {
        panel1 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        label1 = new javax.swing.JLabel("Sure: 0 sn");
        label2 = new javax.swing.JLabel("Oyun hazir.");
        label3 = new javax.swing.JLabel();
        label3.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        textfield1 = new javax.swing.JTextField(5);
        textfield2 = new javax.swing.JTextField(15);
        button1 = new javax.swing.JButton("Harf Tahmin");
        button2 = new javax.swing.JButton("Kelime Tahmin");
        button3 = new javax.swing.JButton("Yeni Oyun");

        skorMdl = new DefaultTableModel(new Object[]{"Tarih", "Sure(sn)", "Sonuc"}, 0);
        table1 = new javax.swing.JTable(skorMdl);
        button4 = new javax.swing.JButton("Temizle");

        logMdl = new DefaultTableModel(new Object[]{"Tarih", "Etiket"}, 0);
        table2 = new javax.swing.JTable(logMdl);
        button5 = new javax.swing.JButton("Temizle");

        javax.swing.JPanel panel2 = new javax.swing.JPanel(new java.awt.BorderLayout());
        javax.swing.JPanel panel3 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel3.add(label1);
        panel3.add(label3);
        panel3.add(label2);
        panel2.add(panel3, java.awt.BorderLayout.NORTH);

        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Kelime"));
        panel2.add(panel1, java.awt.BorderLayout.CENTER);

        javax.swing.JPanel panel4 = new javax.swing.JPanel(new java.awt.GridLayout(3, 1));
        javax.swing.JPanel panel5 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel5.add(new javax.swing.JLabel("Harf Tahmini:"));
        panel5.add(textfield1);
        panel5.add(button1);

        javax.swing.JPanel panel6 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel6.add(new javax.swing.JLabel("Kelime Tahmini:"));
        panel6.add(textfield2);
        panel6.add(button2);

        javax.swing.JPanel panel7 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panel7.add(button3);

        panel4.add(panel5);
        panel4.add(panel6);
        panel4.add(panel7);
        panel2.add(panel4, java.awt.BorderLayout.SOUTH);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                harftahminiyap();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                kelimetahminiyap();
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                oyunbslt();
            }
        });

        javax.swing.JPanel panel8 = new javax.swing.JPanel(new java.awt.BorderLayout());
        panel8.add(new javax.swing.JScrollPane(table1), java.awt.BorderLayout.CENTER);
        javax.swing.JPanel panel9 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        panel9.add(button4);
        panel8.add(panel9, java.awt.BorderLayout.SOUTH);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                skortemizle();
            }
        });

        javax.swing.JPanel panel10 = new javax.swing.JPanel(new java.awt.BorderLayout());
        panel10.add(new javax.swing.JScrollPane(table2), java.awt.BorderLayout.CENTER);
        javax.swing.JPanel panel11 = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        panel11.add(button5);
        panel10.add(panel11, java.awt.BorderLayout.SOUTH);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                logtemizle();
            }
        });

        jTabbedPane1.addTab("Oyun Oynama", panel2);
        jTabbedPane1.addTab("Eski Skorlari Goruntuleme", panel8);
        jTabbedPane1.addTab("Loglari Goruntuleme", panel10);
    }

    private void klasorvedosyalarihazirla() {
        try {
            File txtKlas = new File(txtDizin);
            File resKlas = new File(resDizin);
            if (!txtKlas.exists()) {
                txtKlas.mkdirs();
            }
            if (!resKlas.exists()) {
                resKlas.mkdirs();
            }
            File logDos = new File(logDosya);
            if (!logDos.exists()) {
                logDos.createNewFile();
            }
            File oyunDos = new File(oyunDosya);
            if (!oyunDos.exists()) {
                oyunDos.createNewFile();
            }
            kelimelerdosyasinihazirla();
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void kelimelerdosyasinihazirla() throws Exception {
        File kelDos = new File(kelimeDosya);
        if (!kelDos.exists()) {
            kelDos.createNewFile();
            List<String> hazirKelimeler = new ArrayList<>();
            hazirKelimeler.add("domates");
            hazirKelimeler.add("patates");
            hazirKelimeler.add("ispanak");
            hazirKelimeler.add("pirasa");
            hazirKelimeler.add("lahana");
            hazirKelimeler.add("kereviz");
            hazirKelimeler.add("enginar");
            hazirKelimeler.add("bezelye");
            hazirKelimeler.add("patlican");
            hazirKelimeler.add("salatalik");
            hazirKelimeler.add("fasulye");
            hazirKelimeler.add("sarimsak");
            hazirKelimeler.add("karnabahar");
            hazirKelimeler.add("seftali");
            hazirKelimeler.add("kayisi");
            hazirKelimeler.add("karpuz");
            hazirKelimeler.add("portakal");
            hazirKelimeler.add("mandalina");
            hazirKelimeler.add("greyfurt");
            hazirKelimeler.add("kestane");
            hazirKelimeler.add("avokado");
            hazirKelimeler.add("ananas");
            hazirKelimeler.add("ahududu");
            hazirKelimeler.add("bogurtlen");
            hazirKelimeler.add("brokoli");
            hazirKelimeler.add("kuskonmaz");
            hazirKelimeler.add("barbunya");
            hazirKelimeler.add("semizotu");
            hazirKelimeler.add("dereotu");
            hazirKelimeler.add("maydanoz");
            Files.write(kelDos.toPath(), hazirKelimeler, Charset.defaultCharset());
        }
    }

    private boolean sifrekontrolakisi() {
        try {
            File sifDos = new File(sifreDosya);
            boolean sifreDosyasiBos = false;
            if (!sifDos.exists()) {
                sifreDosyasiBos = true;
            } else {
                Path sifYol = sifDos.toPath();
                List<String> kontrolSatirlar = Files.readAllLines(sifYol, Charset.defaultCharset());
                if (kontrolSatirlar.isEmpty()) {
                    sifreDosyasiBos = true;
                }
            }
            if (sifreDosyasiBos) {
                String yeniSifre = JOptionPane.showInputDialog(this, "Ilk sifreyi belirleyin:");
                if (yeniSifre == null) {
                    return false;
                }
                yeniSifre = yeniSifre.trim();
                if (yeniSifre.isEmpty()) {
                    return false;
                }
                List<String> sifSatirlar = new ArrayList<>();
                sifSatirlar.add(yeniSifre);
                Path sifYol = sifDos.toPath();
                Files.write(sifYol, sifSatirlar, Charset.defaultCharset());
                logyaz("Sifre olusturuldu");
                return true;
            }

            Path sifYol = sifDos.toPath();
            List<String> sifSatirlar = Files.readAllLines(sifYol, Charset.defaultCharset());
            String kaySifre = sifSatirlar.get(0);
            kaySifre = kaySifre.trim();

            int denSay = 0;
            while (denSay < 3) {
                String girSifre = JOptionPane.showInputDialog(this, "Sifreyi giriniz:");
                if (girSifre != null && girSifre.equals(kaySifre)) {
                    logyaz("Basarili giris");
                    return true;
                }
                denSay++;
                logyaz("Hatali sifre denemesi");
                JOptionPane.showMessageDialog(this, "Hatali sifre. Kalan hak: " + (3 - denSay));
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;
    }

    private void kelimeyukle() {
        try {
            Path kelYol = new File(kelimeDosya).toPath();
            kelimeler = Files.readAllLines(kelYol, Charset.defaultCharset());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
            kelimeler = new ArrayList<>();
        }
    }

    private void oyunbslt() {
        if (kelimeler.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Kelimeler dosyasi bos.");
            return;
        }

        int kelimeSira = rnd.nextInt(kelimeler.size());
        secKelime = kelimeler.get(kelimeSira);
        secKelime = secKelime.trim();
        secKelime = secKelime.toLowerCase();
        yanlisAdet = 0;
        gecSure = 0;
        oyunBitti = false;
        label1.setText("Sure: 0 sn");
        label2.setText("Tahmine baslayin.");
        gorselgncl();

        panel1.removeAll();
        harfLbls = new ArrayList<>();
        for (int i = 0; i < secKelime.length(); i++) {
            javax.swing.JLabel harfLbl = new javax.swing.JLabel("*");
            harfLbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5));
            harfLbls.add(harfLbl);
            panel1.add(harfLbl);
        }
        panel1.revalidate();
        panel1.repaint();

        textfield1.setText("");
        textfield2.setText("");

        if (timer1 != null) {
            timer1.stop();
        }
        timer1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                sureguncelle();
            }
        });
        timer1.start();
    }

    private void sureguncelle() {
        if (!oyunBitti) {
            gecSure++;
            label1.setText("Sure: " + gecSure + " sn");
        }
    }

    private void harftahminiyap() {
        if (oyunBitti) {
            return;
        }
        String harfTahmin = textfield1.getText();
        harfTahmin = harfTahmin.trim();
        harfTahmin = harfTahmin.toLowerCase();
        if (harfTahmin.length() != 1) {
            JOptionPane.showMessageDialog(this, "Tek harf giriniz.");
            return;
        }
        char harf = harfTahmin.charAt(0);
        boolean harfVar = false;
        for (int i = 0; i < secKelime.length(); i++) {
            if (secKelime.charAt(i) == harf) {
                harfLbls.get(i).setText(String.valueOf(harf));
                harfVar = true;
            }
        }
        if (!harfVar) {
            yanlisarttir();
        } else if (kelimetamamm()) {
            oyunubitir(true);
        }
        textfield1.setText("");
    }

    private void kelimetahminiyap() {
        if (oyunBitti) {
            return;
        }
        String kelTahmin = textfield2.getText();
        kelTahmin = kelTahmin.trim();
        kelTahmin = kelTahmin.toLowerCase();
        if (kelTahmin.isEmpty()) {
            return;
        }
        if (kelTahmin.equals(secKelime)) {
            for (int i = 0; i < secKelime.length(); i++) {
                harfLbls.get(i).setText(String.valueOf(secKelime.charAt(i)));
            }
            oyunubitir(true);
        } else {
            yanlisarttir();
        }
        textfield2.setText("");
    }

    private void yanlisarttir() {
        yanlisAdet++;
        gorselgncl();
        if (yanlisAdet >= 11) {
            oyunubitir(false);
        }
    }

    private void gorselgncl() {
        int resimNo = yanlisAdet + 1;
        if (resimNo > 11) {
            resimNo = 11;
        }
        String resimYol = resDizin + "\\" + resimNo + ".jpg";
        File resimDos = new File(resimYol);
        if (resimDos.exists()) {
            label3.setIcon(new ImageIcon(resimYol));
            label3.setText("");
        } else {
            label3.setIcon(null);
            label3.setText("Resim bulunamadi: " + resimNo + ".jpg");
        }
    }

    private boolean kelimetamamm() {
        for (javax.swing.JLabel harfLbl : harfLbls) {
            if ("*".equals(harfLbl.getText())) {
                return false;
            }
        }
        return true;
    }

    private void oyunubitir(boolean kazandi) {
        oyunBitti = true;
        if (timer1 != null) {
            timer1.stop();
        }
        String oyunSonuc;
        if (kazandi) {
            oyunSonuc = "Kazandi";
            label2.setText("Tebrikler!");
        } else {
            oyunSonuc = "Kaybetti";
            label2.setText("Oyun bitti. Kelime: " + secKelime);
        }
        oyunukaydet(oyunSonuc);
        skoryukle();
        JOptionPane.showMessageDialog(this, "Oyun Sonucu: " + oyunSonuc);
    }

    private void oyunukaydet(String oyunSonuc) {
        try {
            File oyunDos = new File(oyunDosya);
            Path oyunYol = oyunDos.toPath();
            List<String> oyunSatirlar = Files.readAllLines(oyunYol, Charset.defaultCharset());
            String tarih = tarihFmt.format(new java.util.Date());
            String kayitSatir = tarih + ";" + gecSure + ";" + oyunSonuc;
            oyunSatirlar.add(kayitSatir);
            Files.write(oyunYol, oyunSatirlar, Charset.defaultCharset());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void logyaz(String etiket) {
        try {
            File logDos = new File(logDosya);
            if (!logDos.exists()) {
                logDos.createNewFile();
            }
            Path logYol = logDos.toPath();
            List<String> logSatirlar = Files.readAllLines(logYol, Charset.defaultCharset());
            String tarih = tarihFmt.format(new java.util.Date());
            String kayitSatir = tarih + ";" + etiket;
            logSatirlar.add(kayitSatir);
            Files.write(logYol, logSatirlar, Charset.defaultCharset());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void skoryukle() {
        try {
            skorMdl.setRowCount(0);
            File oyunDos = new File(oyunDosya);
            Path oyunYol = oyunDos.toPath();
            List<String> skorSatirlar = Files.readAllLines(oyunYol, Charset.defaultCharset());
            for (String skorSatir : skorSatirlar) {
                String[] skorBolum = skorSatir.split(";");
                if (skorBolum.length >= 3) {
                    skorMdl.addRow(new Object[]{skorBolum[0], skorBolum[1], skorBolum[2]});
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void logyukle() {
        try {
            logMdl.setRowCount(0);
            File logDos = new File(logDosya);
            Path logYol = logDos.toPath();
            List<String> logSatirlar = Files.readAllLines(logYol, Charset.defaultCharset());
            for (String logSatir : logSatirlar) {
                String[] logBolum = logSatir.split(";");
                if (logBolum.length >= 2) {
                    logMdl.addRow(new Object[]{logBolum[0], logBolum[1]});
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void skortemizle() {
        if (sifredogrula()) {
            try {
                File oyunDos = new File(oyunDosya);
                Path oyunYol = oyunDos.toPath();
                List<String> bosListe = new ArrayList<>();
                Files.write(oyunYol, bosListe, Charset.defaultCharset());
                skoryukle();
            } catch (Exception ex) {
                logger.log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }

    private void logtemizle() {
        if (sifredogrula()) {
            try {
                File logDos = new File(logDosya);
                Path logYol = logDos.toPath();
                List<String> bosListe = new ArrayList<>();
                Files.write(logYol, bosListe, Charset.defaultCharset());
                logyukle();
            } catch (Exception ex) {
                logger.log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }

    private boolean sifredogrula() {
        try {
            File sifDos = new File(sifreDosya);
            Path sifYol = sifDos.toPath();
            List<String> sifSatirlar = Files.readAllLines(sifYol, Charset.defaultCharset());
            if (sifSatirlar.isEmpty()) {
                return false;
            }
            String girSifre = JOptionPane.showInputDialog(this, "Sifreyi giriniz:");
            if (girSifre == null) {
                return false;
            }
            String kaySifre = sifSatirlar.get(0);
            kaySifre = kaySifre.trim();
            if (girSifre.equals(kaySifre)) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                NewJFrame oyun = new NewJFrame();
                oyun.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
