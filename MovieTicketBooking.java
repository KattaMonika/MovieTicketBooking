import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

class MovieTicketBooking{

    // DatePicker class <--Start-->
    class DatePicker extends JComboBox<LocalDate> {
        public DatePicker() {
            // Populate the combo box with dates from today to one year from now
            LocalDate today = LocalDate.now();
            LocalDate oneYearFromNow = today.plusYears(1);
            while (!today.isAfter(oneYearFromNow)) {
                addItem(today);
                today = today.plusDays(1);
            }
            // Set the selected date to today
            setSelectedItem(LocalDate.now());
        }

        public LocalDate getDate() {
            return (LocalDate) getSelectedItem();
        }
    }
    // DatePicker class <--End-->

    MovieTicketBooking() {
        ArrayList<String> mov = new ArrayList<>();
        mov.add("RRR");
        mov.add("Bahubali");
        mov.add("Gamechanger");
        mov.add("Adipurush");
        Frame f = new Frame();
        ImageIcon image = new ImageIcon("Icon.png");// create an image icon
        f.setTitle("Movie Ticket Booking");
        f.setIconImage(image.getImage());
        f.setSize(350, 300);
        f.setVisible(true);
        f.setLayout(null);
        f.setBackground(Color.CYAN);
        Label l1 = new Label("Welcome!!");
        l1.setFont(new Font("Calibri", Font.BOLD, 20));
        l1.setBounds(120, 80, 100, 30);

        Label l2 = new Label("Sign in as : ");
        l2.setFont(new Font("Calibri", Font.BOLD, 13));
        l2.setBounds(130, 125, 100, 30);

        Button b1 = new Button("Admin");
        b1.setBounds(50, 180, 50, 30);
        b1.setFont(new Font("Calibri", Font.BOLD, 10));

        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.black);
        b1.setFocusable(false);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame f1 = new Frame();
                f1.setTitle("Admin");
                f1.setFont(new Font("Calibri", Font.BOLD, 10));
                f1.setIconImage(image.getImage());// change icon of this
                f1.setSize(400, 470);
                f1.setVisible(true);
                f1.setLayout(null);
                f1.setBackground(Color.CYAN);
                Label login = new Label("LOGIN");
                login.setFont(new Font("Calibri", Font.BOLD, 15));
                login.setBounds(160, 90, 80, 40);

                Label msg = new Label("Please enter your username and password");
                msg.setBounds(55, 130, 250, 30);

                Label user = new Label("Username");
                user.setBounds(60, 170, 70, 30);
                TextField t1 = new TextField();
                t1.setBounds(150, 170, 150, 30);

                Label pass = new Label("Password");
                pass.setBounds(60, 210, 70, 30);
                TextField t2 = new TextField();
                t2.setBounds(150, 210, 150, 30);
                t2.setEchoChar('*');

                Label forgot = new Label("forgot password?");
                forgot.setBounds(110, 250, 100, 30);

                Button Login = new Button("Login");
                Login.setBackground(Color.white);
                Login.setForeground(Color.black);
                Login.setFocusable(false);
                Login.setFont(new Font("Calibri", Font.BOLD, 10));
                Login.setBounds(130, 290, 60, 30);

                Label valid = new Label();
                valid.setBounds(80, 330, 300, 30);

                Login.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (t1.getText().equals("admin") && t2.getText().equals("583848687")) {
                            valid.setText("Login Successful!");
                            Button update = new Button("Update Details");
                            update.setBounds(140, 380, 100, 30);
                            update.setBackground(Color.WHITE);
                            update.setForeground(Color.black);
                            update.setFocusable(false);
                            update.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    f1.setSize(500, 600);
                                    Label admsg = new Label();
                                    admsg.setBounds(100, 520, 300, 30);
                                    Label ad = new Label("AddMovieRecords");
                                    ad.setBounds(30, 430, 110, 30);
                                    TextField adt = new TextField();
                                    adt.setBounds(150, 430, 120, 30);
                                    Button arb = new Button("Add");
                                    arb.setBackground(Color.white);
                                    arb.setForeground(Color.black);
                                    arb.setFocusable(false);
                                    arb.setBounds(310, 430, 50, 30);
                                    arb.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            String admv = adt.getText();
                                            mov.add(admv);
                                            admsg.setText(admv + " movie added");
                                        }
                                    });

                                    Label delete = new Label("DeleteMovieRecords");
                                    delete.setBounds(30, 470, 110, 30);
                                    Choice cr = new Choice();
                                    cr.setBounds(150, 470, 120, 30);
                                    for (int j = 0; j < mov.size(); j++) {
                                        cr.add(mov.get(j));
                                    }
                                    f1.add(cr);
                                    Button arb1 = new Button("Delete");
                                    arb1.setBackground(Color.white);
                                    arb1.setForeground(Color.black);
                                    arb1.setFocusable(false);
                                    arb1.setBounds(310, 470, 50, 30);
                                    arb1.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            mov.remove(cr.getSelectedItem());
                                            admsg.setText(cr.getSelectedItem() + " movie removed");
                                        }
                                    });
                                    f1.add(ad);
                                    f1.add(adt);
                                    f1.add(arb);
                                    f1.add(delete);
                                    f1.add(cr);
                                    f1.add(arb1);
                                    f1.add(admsg);
                                }
                            });
                            f1.add(update);
                        } else {
                            valid.setForeground(Color.red);
                            valid.setText("Invalid Username or Password.Please try again !");
                        }
                    }
                });
                f1.add(login);
                f1.add(msg);
                f1.add(user);
                f1.add(t1);
                f1.add(pass);
                f1.add(t2);
                f1.add(forgot);
                f1.add(Login);
                f1.add(valid);
                f1.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        f1.dispose();
                    }
                });
            }
        });

        Button b2 = new Button("Visitor");
        b2.setBounds(140, 180, 50, 30);
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("Calibri", Font.BOLD, 10));
        b2.setForeground(Color.black);
        b2.setFocusable(false);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame f2 = new Frame();
                f2.setIconImage(image.getImage());
                f2.setTitle("Visitor");
                f2.setFont(new Font("Calibri", Font.BOLD, 10));
                f2.setSize(350, 300);
                f2.setVisible(true);
                f2.setLayout(null);
                f2.setBackground(Color.CYAN);

                Button reg = new Button("Get Registered");
                reg.setBounds(120, 110, 100, 30);
                reg.setBackground(Color.WHITE);
                reg.setForeground(Color.black);
                reg.setFocusable(false);
                Button mov1 = new Button("View Movies");
                mov1.setForeground(Color.black);
                mov1.setFocusable(false);
                mov1.setBounds(120, 150, 100, 30);
                mov1.setBackground(Color.WHITE);
                f2.add(reg);
                f2.add(mov1);

                reg.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Frame rf = new Frame();
                        rf.setIconImage(image.getImage());
                        rf.setTitle("Registration Form");
                        rf.setFont(new Font("Calibri", Font.BOLD, 10));
                        rf.setSize(500, 450);
                        rf.setVisible(true);
                        rf.setLayout(null);
                        rf.setBackground(Color.CYAN);
                        Label rl1 = new Label("Email Address ");
                        rl1.setBounds(50, 50, 100, 30);
                        TextField rt1 = new TextField();
                        rt1.setBounds(150, 50, 250, 30);

                        Label rl2 = new Label("First Name ");
                        rl2.setBounds(50, 100, 100, 30);
                        TextField rt2 = new TextField();
                        rt2.setBounds(150, 100, 250, 30);

                        Label rl3 = new Label("Last Name ");
                        rl3.setBounds(50, 150, 100, 30);
                        TextField rt3 = new TextField();
                        rt3.setBounds(150, 150, 250, 30);

                        Label rl4 = new Label("Phone No.");
                        rl4.setBounds(50, 200, 100, 30);
                        TextField rt4 = new TextField();
                        rt4.setBounds(150, 200, 250, 30);

                        Label rl5 = new Label("Username ");
                        rl5.setBounds(50, 250, 100, 30);
                        TextField rt5 = new TextField();
                        rt5.setBounds(150, 250, 250, 30);

                        Label rl6 = new Label("Password");
                        rl6.setBounds(50, 300, 100, 30);
                        TextField rt6 = new TextField();
                        rt6.setBounds(150, 300, 250, 30);

                        JFrame f = new JFrame();

                        Label rl7 = new Label();

                        Button rb1 = new Button("Submit");
                        rb1.setBounds(180, 350, 100, 30);
                        rb1.setBackground(Color.WHITE);
                        rb1.setForeground(Color.black);
                        rb1.setFocusable(false);
                        rb1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                rl7.setBounds(135, 390, 150, 30);
                                
                                try (FileWriter write = new FileWriter("Register.txt", true)) {
                                    write.write(
                                            rt5.getText() + "\t" + rt6.getText() + "\t" + rt1.getText() + "\t"
                                                    + rt4.getText()
                                                    + "\t" + rt2.getText() + "\t" + rt3.getText()
                                                    + "\n");
                                    FileWriter write2 = new FileWriter("Credentials.txt", true);
                                    write2.write(rt5.getText() + "\t" + rt6.getText() + "\n");
                                    write.close();
                                    write2.close();
                                } catch (IOException e1) {
                                }
                                rl7.setText("You have been registered.");
                                if(rt1.getText().equals("")||rt2.getText().equals("")||
                                   rt3.getText().equals("")||rt4.getText().equals("")||
                                   rt5.getText().equals("")||rt6.getText().equals("")){
                                    rl7.setBounds(120, 390, 200, 30);
                                    rl7.setText("Please fill all the fields to Register");
                                }
                            }
                        });

                        rf.add(rl1);
                        rf.add(rt1);
                        rf.add(rl2);
                        rf.add(rt2);
                        rf.add(rl3);
                        rf.add(rt3);
                        rf.add(rl4);
                        rf.add(rt4);
                        rf.add(rl5);
                        rf.add(rt5);
                        rf.add(rl6);
                        rf.add(rt6);
                        rf.add(rb1);
                        rf.add(rl7);
                        rf.addWindowListener(new WindowAdapter() {
                            public void windowClosing(WindowEvent e) {
                                rf.dispose();
                            }
                        });
                    }
                });

                mov1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        f2.setSize(350, 500);
                        Label ml = new Label("Available Movies");
                        ml.setBounds(100, 200, 100, 30);
                        TextArea ta = new TextArea();
                        ta.setBounds(80, 240, 130, 120);
                        for (int k = 0; k < mov.size(); k++) {
                            ta.append(mov.get(k));
                            ta.append("\n");
                        }
                        f2.add(ml);
                        f2.add(ta);
                    }
                });
                f2.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        f2.dispose();
                    }
                });
            }
        });

        Button b3 = new Button("User");
        b3.setBounds(230, 180, 50, 30);
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.black);
        b3.setFocusable(false);
        b3.setFont(new Font("Calibri", Font.BOLD, 10));
        b3.addActionListener(new ActionListener() {
            Button out;
            boolean isLogin;

            public void actionPerformed(ActionEvent e) {
                Frame f3 = new Frame();
                f3.setIconImage(image.getImage());
                f3.setTitle("Registered User");
                f3.setSize(380, 400);
                f3.setVisible(true);
                f3.setLayout(null);
                f3.setBackground(Color.CYAN);

                Label msgl = new Label();
                msgl.setBounds(95, 280, 180, 30);
                Label usermsg = new Label("What would you like to do ?");

                usermsg.setFont(new Font("Calibri", Font.BOLD, 15));
                usermsg.setBounds(85, 40, 210, 30);
                Button in = new Button("Login");
                in.setBounds(100, 80, 150, 30);
                in.setBackground(Color.WHITE);
                in.setForeground(Color.black);
                in.setFocusable(false);
                in.setFont(new Font("Calibri", Font.BOLD, 10));
                in.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        f3.setVisible(false);
                        Frame lf1 = new Frame();
                        lf1.setIconImage(image.getImage());
                        lf1.setTitle("User Login");
                        lf1.setSize(400, 470);
                        lf1.setVisible(true);
                        lf1.setLayout(null);
                        lf1.setBackground(Color.CYAN);
                        Label llogin = new Label("LOGIN");
                        llogin.setBounds(160, 90, 70, 40);
                        llogin.setFont(new Font("Calibri", Font.BOLD, 20));

                        Label lmsg = new Label("Please Enter your Username & Password");
                        lmsg.setFont(new Font("Calibri", Font.BOLD, 13));
                        lmsg.setBounds(60, 130, 260, 30);

                        Label luser = new Label("Username");
                        luser.setFont(new Font("Calibri", Font.BOLD, 13));
                        luser.setBounds(60, 170, 70, 30);
                        TextField lt1 = new TextField();
                        lt1.setBounds(150, 170, 150, 20);

                        Label lpass = new Label("Password");
                        lpass.setFont(new Font("Calibri", Font.BOLD, 13));
                        lpass.setBounds(60, 210, 70, 30);
                        TextField lt2 = new TextField();
                        lt2.setBounds(150, 210, 150, 20);
                        lt2.setEchoChar('*');

                        Label lforgot = new Label("forgot password?");
                        lforgot.setFont(new Font("Calibri", Font.BOLD, 13));
                        lforgot.setForeground(Color.RED);
                        lforgot.setBounds(110, 250, 140, 30);

                        Button lLogin = new Button("Login");
                        lLogin.setFont(new Font("Calibri", Font.BOLD, 13));
                        lLogin.setBackground(Color.white);
                        lLogin.setForeground(Color.darkGray);
                        lLogin.setFocusable(false);
                        lLogin.setBounds(140, 290, 60, 30);

                        Label lvalid = new Label();
                        lvalid.setBounds(50, 330, 300, 30);
                        lvalid.setFont(new Font("Calibri", Font.BOLD, 13));
                        lvalid.setForeground(Color.red);
                        lLogin.addActionListener(new ActionListener() {
                            Boolean match = false;

                            public void actionPerformed(ActionEvent e) {
                                String UserName = lt1.getText().toString();
                                String PassWord = lt2.getText().toString();
                                try {
                                    FileReader fileRead = new FileReader("Credentials.txt");
                                    BufferedReader bufferRead = new BufferedReader(fileRead);
                                    String str;
                                    while ((str = bufferRead.readLine()) != null) {
                                        if (str.equals(UserName + "\t" + PassWord)) {
                                            match = true;
                                            in.setEnabled(false);
                                            out.setEnabled(true);
                                            isLogin = true;
                                            break;
                                        }
                                    }
                                    fileRead.close();
                                } catch (Exception e2) {
                                }

                                if (match) {
                                    lvalid.setText("Login Successful!");
                                    msgl.setText(lt1.getText() + ", Login Successful!");
                                    msgl.setFont(new Font("Calibri", Font.BOLD, 13));
                                    msgl.setForeground(Color.gray);
                                    f3.setVisible(true);
                                    lf1.setVisible(false);
                                } else {
                                    lvalid.setText("Invalid Username or Password.Please try again !");
                                }
                            }
                        });
                        lf1.add(llogin);
                        lf1.add(lmsg);
                        lf1.add(luser);
                        lf1.add(lt1);
                        lf1.add(lpass);
                        lf1.add(lt2);
                        lf1.add(lforgot);
                        lf1.add(lLogin);
                        lf1.add(lvalid);
                        lf1.addWindowListener(new WindowAdapter() {
                            public void windowClosing(WindowEvent e) {
                                lf1.dispose();
                            }
                        });
                    }
                });

                Button view = new Button("View Movies");

                view.setBounds(100, 120, 150, 30);
                view.setBackground(Color.WHITE);
                view.setForeground(Color.black);
                view.setFocusable(false);
                view.setFont(new Font("Calibri", Font.BOLD, 10));
                Label vm = new Label("Available Movies");
                vm.setFont(new Font("Calibri", Font.BOLD, 13));
                TextArea vt = new TextArea();
                view.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        f3.setSize(400, 600);
                        vm.setBounds(110, 320, 110, 30);
                        vt.setBounds(100, 350, 130, 120);
                        vm.setVisible(true);
                        vt.setVisible(true);
                        for (int l = 0; l < mov.size(); l++) {
                            vt.append(mov.get(l));
                            vt.append("\n");
                        }
                        f3.add(vm);
                        f3.add(vt);
                    }
                });
                Button book = new Button("Book Ticket");
                book.setBounds(100, 160, 150, 30);
                book.setBackground(Color.WHITE);
                book.setForeground(Color.black);
                book.setFocusable(false);
                book.setFont(new Font("Calibri", Font.BOLD, 10));
                book.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (isLogin) {
                            Frame bf = new Frame("Ticket Booking");
                            bf.setIconImage(image.getImage());
                            bf.setSize(400, 500);
                            bf.setVisible(true);
                            bf.setLayout(null);
                            bf.setBackground(Color.CYAN);

                            Label bl1 = new Label("Select Movie");
                            bl1.setFont(new Font("Calibri", Font.BOLD, 13));
                            bl1.setBounds(70, 80, 80, 30);
                            Choice c = new Choice();
                            c.setBounds(180, 80, 120, 120);
                            for (int i = 0; i < mov.size(); i++) {
                                c.add(mov.get(i));
                            }

                            Label bl2 = new Label("Select Theatre");
                            bl2.setFont(new Font("Calibri", Font.BOLD, 13));
                            bl2.setBounds(70, 120, 90, 30);
                            Choice c2 = new Choice();
                            c2.setBounds(180, 120, 120, 120);
                            c2.add("NCS");
                            c2.add("SVC");
                            c2.add("AMB");
                            c2.add("Sangam");

                            Label bl3 = new Label("Select Date");
                            bl3.setFont(new Font("Calibri", Font.BOLD, 13));
                            bl3.setBounds(70, 160, 70, 30);

                            DatePicker datePicker = new DatePicker();
                            // Add an action listener to the date picker
                            datePicker.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    LocalDate date = datePicker.getDate();
                                }
                            });

                            datePicker.setBounds(180, 160, 100, 20);
                            bf.add(datePicker);

                            Label bl4 = new Label("Select Show");
                            bl4.setFont(new Font("Calibri", Font.BOLD, 13));
                            bl4.setBounds(70, 200, 100, 30);
                            Choice c1 = new Choice();
                            c1.setBounds(180, 200, 120, 120);
                            c1.add("Morning - 11:00AM");
                            c1.add("Matinee - 02:00PM");
                            c1.add("Evening - 06:00PM");
                            c1.add("Second - 09:00PM");

                            Label bl5 = new Label("Number of Tickets");
                            bl5.setFont(new Font("Calibri", Font.BOLD, 13));
                            bl5.setBounds(70, 240, 120, 30);
                            TextField bt1 = new TextField();
                            bt1.setBounds(200, 240, 50, 25);

                            Button bb = new Button("Book");
                            bb.setBackground(Color.WHITE);
                            bb.setFont(new Font("Calibri", Font.BOLD, 15));
                            bb.setBounds(130, 280, 70, 30);

                            bb.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    Label bl6 = new Label("Proceed to Payment?");
                                    bl6.setFont(new Font("Calibri", Font.BOLD, 13));
                                    bl6.setBounds(100, 320, 140, 30);

                                    Button bb1 = new Button("Yes");
                                    bb1.setFont(new Font("Calibri", Font.BOLD, 10));
                                    bb1.setBackground(Color.white);
                                    bb1.setForeground(Color.black);
                                    bb1.setFocusable(false);
                                    Button bb2 = new Button("No");
                                    bb2.setFont(new Font("Calibri", Font.BOLD, 10));
                                    bb2.setBackground(Color.white);
                                    bb2.setForeground(Color.black);
                                    bb2.setFocusable(false);
                                    bb1.setBounds(100, 360, 50, 30);
                                    bb1.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            Frame f4 = new Frame();
                                            f4.setIconImage(image.getImage());
                                            f4.setTitle("Make Payment");
                                            f4.setSize(350, 300);
                                            f4.setVisible(true);
                                            f4.setLayout(null);
                                            f4.setBackground(Color.CYAN);

                                            Double amt = 120.00;
                                            String s = bt1.getText();
                                            int tck = Integer.parseInt(s);
                                            Double tamt = amt * tck;
                                            String str = Double.toString(tamt);

                                            Label id = new Label("User id ");
                                            id.setFont(new Font("Calibri", Font.BOLD, 10));
                                            id.setBounds(50, 60, 100, 30);
                                            TextField pt1 = new TextField();
                                            pt1.setBounds(150, 60, 150, 30);

                                            Label trans = new Label("Transaction id ");
                                            trans.setFont(new Font("Calibri", Font.BOLD, 10));
                                            trans.setBounds(50, 100, 100, 30);
                                            TextField pt2 = new TextField();
                                            pt2.setBounds(150, 100, 150, 30);

                                            Label amount = new Label("Amount");
                                            amount.setFont(new Font("Calibri", Font.BOLD, 10));
                                            amount.setBounds(50, 140, 100, 30);
                                            TextField pt3 = new TextField();
                                            pt3.setBounds(150, 140, 150, 30);
                                            pt3.setText(str);
                                            pt3.setEditable(false);

                                            Button confirm = new Button("Confirm");
                                            confirm.setFont(new Font("Calibri", Font.BOLD, 10));
                                            confirm.setBounds(50, 200, 60, 30);
                                            confirm.setBackground(Color.WHITE);
                                            confirm.setForeground(Color.black);
                                            confirm.setFocusable(false);
                                            confirm.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    String alnu = pt2.getText();
                                                    if(alnu.matches("[a-zA-Z0-9]+")){

                                                        Frame cbook = new Frame();
                                                        cbook.setIconImage(image.getImage());
                                                        cbook.setTitle("Confirm Booking");
                                                        cbook.setFont(new Font("Calibri", Font.ITALIC, 10));
                                                        cbook.setSize(350, 300);
                                                        cbook.setVisible(true);
                                                        cbook.setLayout(null);
                                                        cbook.setBackground(Color.CYAN);

                                                        Label tic = new Label();
                                                        tic.setBounds(50, 50, 200, 30);
                                                        tic.setText("No. of Tickets : " + bt1.getText());

                                                        Label mve = new Label();
                                                        mve.setBounds(50, 90, 200, 30);
                                                        mve.setText("Movie : " + c.getSelectedItem());

                                                        Label Theatre = new Label();
                                                        Theatre.setBounds(50, 130, 200, 30);
                                                        Theatre.setText("Theatre : " + c2.getSelectedItem());

                                                        Label fare = new Label();
                                                        fare.setBounds(50, 170, 200, 30);
                                                        fare.setText("Fare : " + pt3.getText());

                                                        Label dat = new Label();
                                                        dat.setBounds(50, 210, 200, 30);
                                                        dat.setText("Date : " + datePicker.getDate());

                                                        Label time = new Label();
                                                        time.setBounds(50, 250, 200, 30);
                                                        time.setText("Time : " + c1.getSelectedItem());

                                                        cbook.add(tic);
                                                        cbook.add(mve);
                                                        cbook.add(Theatre);
                                                        cbook.add(fare);
                                                        cbook.add(dat);
                                                        cbook.add(time);
                                                        cbook.addWindowListener(new WindowAdapter() {
                                                            public void windowClosing(WindowEvent e) {
                                                                cbook.dispose();
                                                            }
                                                        });
                                                    }else{
                                                        Label imsg = new Label();
                                                        imsg.setBounds(30,240,230,30);
                                                        imsg.setText("Invalid Transaction Id!Enter correct id");
                                                        f4.add(imsg);
                                                       }
                                                }
                                            });
                                            Button cancel = new Button("Cancel Tickets");
                                            cancel.setFont(new Font("Calibri", Font.BOLD, 10));
                                            cancel.setBounds(200, 200, 100, 30);
                                            cancel.setBackground(Color.WHITE);
                                            cancel.setForeground(Color.black);
                                            cancel.setFocusable(false);
                                            cancel.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    f4.setVisible(false);
                                                    bl6.setVisible(false);
                                                    bb1.setVisible(false);
                                                    bb2.setVisible(false);
                                                }
                                            });
                                            f4.add(id);
                                            f4.add(pt1);
                                            f4.add(trans);
                                            f4.add(pt2);
                                            f4.add(amount);
                                            f4.add(pt3);
                                            f4.add(confirm);
                                            f4.add(cancel);
                                            f4.addWindowListener(new WindowAdapter() {
                                                public void windowClosing(WindowEvent e) {
                                                    f4.dispose();
                                                }
                                            });

                                        }
                                    });

                                    bb2.setBounds(180, 360, 50, 30);
                                    bb2.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            bl6.setVisible(false);
                                            bb1.setVisible(false);
                                            bb2.setVisible(false);
                                        }
                                    });
                                    bf.add(bl6);
                                    bf.add(bb1);
                                    bf.add(bb2);
                                }
                            });
                            bf.add(bl1);
                            bf.add(bl2);
                            bf.add(bl3);
                            bf.add(bl4);
                            bf.add(bl5);
                            bf.add(c);
                            bf.add(c2);
                            bf.add(bt1);
                            bf.add(c1);
                            bf.add(bb);

                            bf.addWindowListener(new WindowAdapter() {
                                public void windowClosing(WindowEvent e) {
                                    bf.dispose();
                                }
                            });
                        } else {
                            msgl.setText("You Haven't logged in!!");
                        }
                    }
                });

                Button cancel = new Button("Cancel Tickets");
                cancel.setBounds(100, 200, 150, 30);
                cancel.setBackground(Color.WHITE);
                cancel.setForeground(Color.black);
                cancel.setFocusable(false);
                cancel.setFont(new Font("Calibri", Font.BOLD, 10));
                Label cmsg = new Label();
                Label cmsg1 = new Label();
                cancel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (isLogin) {
                            vm.setVisible(false);
                            vt.setVisible(false);
                            f3.setSize(380, 400);
                            cmsg.setBounds(40, 310, 250, 20);
                            cmsg1.setBounds(10, 325, 350, 25);
                            cmsg.setText("Your Booking has been cancelled ");
                            cmsg1.setText("Refund will be credited in 2-3 working days");
                            cmsg.setFont(new Font("monospaced", Font.BOLD, 13));
                            cmsg1.setFont(new Font("monospaced", Font.BOLD, 13));
                        } else {
                            msgl.setText("You Haven't logged in!!");
                        }
                    }
                });

                out = new Button("Logout");
                out.setBounds(100, 240, 150, 30);
                out.setBackground(Color.WHITE);
                out.setForeground(Color.black);
                out.setFocusable(false);
                out.setFont(new Font("Calibri", Font.BOLD, 10));
                out.setEnabled(false);
                out.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        msgl.setText(" Logout Successful!");
                        isLogin = false;
                        f3.setSize(380, 400);
                        vm.setVisible(false);
                        vt.setVisible(false);
                        cmsg.setVisible(false);
                        cmsg1.setVisible(false);
                        in.setEnabled(true);
                        out.setEnabled(false);
                    }
                });
                f3.add(usermsg);
                f3.add(in);
                f3.add(out);
                f3.add(view);
                f3.add(book);
                f3.add(cancel);
                f3.add(msgl);
                f3.add(cmsg);
                f3.add(cmsg1);
                f3.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        f3.dispose();
                    }
                });
            }
        });
        f.add(l1);
        f.add(l2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }

    public static void main(String[] args) {
        MovieTicketBooking obj = new MovieTicketBooking();
    }
}
