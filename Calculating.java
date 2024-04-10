package calculatingfx;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Calculating extends Application {
    // initializes buttons
    private Label outputLabel;
    private Button clearButton;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button zeroButton;
    private Button timesButton;
    private Button divideButton;
    private Button plusButton;
    private Button plusMinusButton;
    private Button subtractButton;
    private Button equalsButton;
    private Button inverseButton;
    private Button percentButton;
    private Button squareButton;
    private Button cubeButton;
    private Button modButton;
    private Button sqrtButton;
    private Button sinButton;
    private Button cosButton;
    private Button tanButton;
    private Button lnButton;
    private Button logButton;
    private Button asinButton;
    private Button acosButton;
    private Button atanButton;
    private Button sinhButton;
    private Button coshButton;
    private Button tanhButton;
    private Button absButton;
    private Button power10Button;
    private Button exitButton;
    private Button decimalButton;

    // initializes two numbers that will have an operation performed on them
    private double num1 = 0.0;
    private double num2 = 0.0;

    // initialized String number that'll display the current number typed or equated on the screen
    private String number = "";

    // initialized operator that's a char that tells the current operator
    private char operator = ' ';

    // initialized post equals which tells the calculator what state the calculator is in
    private boolean postEquals = false;

    // initiazlies buttons and arraylist of buttons
    private ArrayList<Button> buttons = new ArrayList<Button>();

    @Override
    public void start(Stage applicationStage) {
        Scene scene = null;                     // Scene contains all content
        GridPane gridPane = null;               // Positions components within scene

        gridPane = new GridPane();              // creates new grid pane
        scene = new Scene(gridPane);            // creates new scene
        gridPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY))); // sets the scene background to black

        outputLabel = new Label();                                              // creates label for current number and equated value
        outputLabel.setText("0");                                               // initializes the label to have 0
        outputLabel.setFont(Font.font("Helvetica", FontWeight.THIN, 50));       // changes the label font to helvectica, thin font weight, and size of 50
        outputLabel.setPadding(new Insets(0, 10, 0, 0));                        // changes the padding to 10px on the right side
        outputLabel.setMaxWidth(Double.MAX_VALUE);                              // makes the width of the label extend the whole length of the calculator
        outputLabel.setAlignment(Pos.CENTER_RIGHT);                             // sets the aligment to the right
        outputLabel.setTextFill(Color.WHITE);                                   // sets the text to white
        outputLabel.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY))); // changes the background to black

        // creation of buttons
        // add button to list of buttons
        oneButton = new Button("1");
        buttons.add(oneButton);

        twoButton = new Button("2");
        buttons.add(twoButton);

        threeButton = new Button("3");
        buttons.add(threeButton);

        fourButton = new Button("4");
        buttons.add(fourButton);

        fiveButton = new Button("5");
        buttons.add(fiveButton);

        sixButton = new Button("6");
        buttons.add(sixButton);

        sevenButton = new Button("7");
        buttons.add(sevenButton);

        eightButton = new Button("8");
        buttons.add(eightButton);

        nineButton = new Button("9");
        buttons.add(nineButton);

        zeroButton = new Button("0");
        buttons.add(zeroButton);

        clearButton = new Button("C");
        buttons.add(clearButton);

        plusMinusButton = new Button("+/-");
        buttons.add(plusMinusButton);

        percentButton = new Button("%");
        buttons.add(percentButton);

        divideButton = new Button("÷");
        buttons.add(divideButton);

        timesButton = new Button("x");
        buttons.add(timesButton);

        subtractButton = new Button("-");
        buttons.add(subtractButton);

        plusButton = new Button("+");
        buttons.add(plusButton);

        equalsButton = new Button("=");
        buttons.add(equalsButton);

        sinButton = new Button("sin");
        buttons.add(sinButton);

        cosButton = new Button("cos");
        buttons.add(cosButton);

        tanButton = new Button("tan");
        buttons.add(tanButton);

        asinButton = new Button("asin");
        buttons.add(asinButton);

        acosButton = new Button("acos");
        buttons.add(acosButton);

        atanButton = new Button("atan");
        buttons.add(atanButton);

        sinhButton = new Button("sinh");
        buttons.add(sinhButton);

        coshButton = new Button("cosh");
        buttons.add(coshButton);

        tanhButton = new Button("tanh");
        buttons.add(tanhButton);

        lnButton = new Button("ln");
        buttons.add(lnButton);

        logButton = new Button("log");
        buttons.add(logButton);

        sqrtButton = new Button("√");
        buttons.add(sqrtButton);

        squareButton = new Button("x²");
        buttons.add(squareButton);

        cubeButton = new Button("x³");
        buttons.add(cubeButton);

        absButton = new Button("abs");
        buttons.add(absButton);

        modButton = new Button("mod");
        buttons.add(modButton);

        inverseButton = new Button("1/n");
        buttons.add(inverseButton);

        power10Button = new Button("10^x");
        buttons.add(power10Button);

        decimalButton = new Button(".");
        buttons.add(decimalButton);

        exitButton = new Button("exit");
        buttons.add(exitButton);

        // for-loop that sets each buttons size, dimensions, color, font, and padding
        for (int i = 0; i < buttons.size(); i++) {  // iterates through each button in list of buttons
            Button btn = buttons.get(i);            // sets btn to the current button
            Rectangle rectangle;                    // initalizes new rectangle that'll be used for button's shape

            final double BUTTON_WIDTH = 60;               // var BUTTON_WIDTH which is the desired width/radius for the button

            // if statement that checks if the button is the zero button or equals button
            // zero button and equals button are pill shaped while the rest are circles
            if (btn.equals(exitButton) || btn.equals(zeroButton)) {
                rectangle = new Rectangle(BUTTON_WIDTH * 2 + 10, BUTTON_WIDTH);     // creates new rectangle that have length of BUTTON_WIDTH * 2 + 10 (for padding) and width BUTTON_WIDTH
                rectangle.setArcWidth(BUTTON_WIDTH);                                // changes arc width to get desired pill form
                rectangle.setArcHeight(BUTTON_WIDTH);                               // changes arc length to get desired pill form
                
                btn.setShape(rectangle);                                            // sets the shape of the button to the pill shaped
                btn.setPrefSize(BUTTON_WIDTH * 2 + 10, BUTTON_WIDTH);               // sets button to desired size 
                
            } else {                    
                btn.setShape(new Circle(BUTTON_WIDTH));                             // sets button to circle shape
                btn.setPrefSize(BUTTON_WIDTH, BUTTON_WIDTH);                        // sets button to desired size
            }

            // if statement that changes the desired buttons' color:
                // clear, +/-, %    have light gray buttons
                // /, *, -, +       have orange buttons
                // digits           have medium gray buttons
                // everything else  have dark gray buttons

            if (btn.equals(clearButton) || btn.equals(plusMinusButton) || btn.equals(percentButton)) {
                btn.setBackground(new Background(new BackgroundFill(Color.rgb(165, 165, 165), CornerRadii.EMPTY, Insets.EMPTY)));   // changes buttons to light gray
                btn.setTextFill(Color.BLACK);                                                                                       // sets text to black
            } else if (btn.equals(divideButton) || btn.equals(timesButton) || btn.equals(subtractButton) || btn.equals(plusButton) || btn.equals(equalsButton)) {
                btn.setBackground(new Background(new BackgroundFill(Color.rgb(255, 159, 10), CornerRadii.EMPTY, Insets.EMPTY)));    // changes buttons to orange
                btn.setTextFill(Color.WHITE);                                                                                       // sets text to white
            } else {
                if (i <= 9 || btn.equals(decimalButton)) {
                    btn.setBackground(new Background(new BackgroundFill(Color.rgb(51, 51, 51), CornerRadii.EMPTY, Insets.EMPTY))); // changes buttons to medium gray
                } else {
                    btn.setBackground(new Background(new BackgroundFill(Color.rgb(33, 33, 33), CornerRadii.EMPTY, Insets.EMPTY))); // changes buttons to dark gray
                }
                btn.setTextFill(Color.WHITE);                                                                                      // sets text to white
            }


            btn.setFont(Font.font("San Francisco", 20));    // sets font to San Francisco and size to 20
            btn.setPadding(new Insets(0));                  // sets padding to 0
        }


        // Grid Pane Layout Specification

        // grid spacing code
        gridPane.setPadding(new Insets(10));            // sets padding to 10
        gridPane.setHgap(10);                           // sets horizontal space between elements to 10px
        gridPane.setVgap(10);                           // sets vertical space between elements to 10px
        gridPane.setAlignment(Pos.CENTER);              // aligns elements to center

        // adding elements to grid (col, row, columns span, row span)
        // row 1
        gridPane.add(outputLabel, 0, 0, 8, 1);  
        gridPane.add(sinButton, 0, 1);
        gridPane.add(cosButton, 1, 1);
        gridPane.add(tanButton, 2, 1);
        gridPane.add(lnButton, 3, 1);
        gridPane.add(clearButton, 4, 1);
        gridPane.add(plusMinusButton, 5, 1);
        gridPane.add(percentButton, 6, 1);
        gridPane.add(divideButton, 7, 1);

        // row 2
        gridPane.add(asinButton, 0, 2);
        gridPane.add(acosButton, 1, 2);
        gridPane.add(atanButton, 2, 2);
        gridPane.add(logButton, 3, 2);
        gridPane.add(sevenButton, 4, 2);
        gridPane.add(eightButton, 5, 2);
        gridPane.add(nineButton, 6, 2);
        gridPane.add(timesButton, 7, 2);

        // row 3
        gridPane.add(sinhButton, 0, 3);
        gridPane.add(coshButton, 1, 3);
        gridPane.add(tanhButton, 2, 3);
        gridPane.add(sqrtButton, 3, 3);
        gridPane.add(fourButton, 4, 3);
        gridPane.add(fiveButton, 5, 3);
        gridPane.add(sixButton, 6, 3);
        gridPane.add(subtractButton, 7, 3);

        // row 4
        gridPane.add(absButton, 0, 4);
        gridPane.add(modButton, 1, 4);
        gridPane.add(power10Button, 2, 4);
        gridPane.add(squareButton, 3, 4);
        gridPane.add(oneButton, 4, 4);
        gridPane.add(twoButton, 5, 4);
        gridPane.add(threeButton, 6, 4);
        gridPane.add(plusButton, 7, 4);

        // row 5
        gridPane.add(exitButton, 0, 5, 2, 1);
        gridPane.add(inverseButton, 2, 5);
        gridPane.add(cubeButton, 3, 5);
        gridPane.add(zeroButton, 4, 5, 2, 1);
        gridPane.add(decimalButton, 6, 5);
        gridPane.add(equalsButton, 7, 5);
        
        
        // Button setOnAction Event Handlers
        // each button proceeds with an action once pressed

            // if postEquals is true, the user starts a new number with the digit pressed
            // else the number will add the digit pressed to the end

        // digit buttons
        oneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (postEquals) {
                    number = "1";
                    postEquals = false;
                } else {
                    number += "1";
                }
                outputLabel.setText(number);
            }
        });

        twoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (postEquals) {
                    number = "2";
                    postEquals = false;
                } else {
                    number += "2";
                }
                outputLabel.setText(number);
            }
        });

        threeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (postEquals) {
                    number = "3";
                    postEquals = false;
                } else {
                    number += "3";
                }
                outputLabel.setText(number);
            }
        });

        fourButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (postEquals) {
                    number = "4";
                    postEquals = false;
                } else {
                    number += "4";
                }
                outputLabel.setText(number);
            }
        });

        fiveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (postEquals) {
                    number = "5";
                    postEquals = false;
                } else {
                    number += "5";
                }
                outputLabel.setText(number);
            }
        });

        sixButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (postEquals) {
                    number = "6";
                    postEquals = false;
                } else {
                    number += "6";
                }
                outputLabel.setText(number);
            }
        });

        sevenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (postEquals) {
                    number = "7";
                    postEquals = false;
                } else {
                    number += "7";
                }
                outputLabel.setText(number);
            }
        });

        eightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (postEquals) {
                    number = "8";
                    postEquals = false;
                } else {
                    number += "8";
                }
                
                outputLabel.setText(number);
            }
        });

        nineButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (postEquals) {
                    number = "9";
                    postEquals = false;
                } else {
                    number += "9";
                }
                outputLabel.setText(number);
            }
        });

        zeroButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (postEquals) {
                    number = "0";
                    postEquals = false;
                } else {
                    number += "0";
                }
                outputLabel.setText(number);
            }
        });

        // other buttons
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                number = "";
                num1 = 0;
                num2 = 0;
                outputLabel.setText("0");
            }
        });

        plusMinusButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                number = "-" + number;
                outputLabel.setText(number);
            }
        });

        decimalButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (postEquals) {
                    number = "0.";
                    postEquals = false;
                    outputLabel.setText(number + "0");
                } else {
                    number += ".";
                    outputLabel.setText(number);
                }
            }
        });

        // operation buttons
        // sets var operation to current opperation selected
        // saves num1 as the number the player entered before hitting the operation button

        plusButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator = '+';
                num1 = Double.parseDouble(number);
                number = "";
            }
        });

        subtractButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator = '-';
                num1 = Double.parseDouble(number);
                number = "";
            }
        });

        timesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator = '*';
                num1 = Double.parseDouble(number);
                number = "";
            }
        });

        divideButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator = '/';
                num1 = Double.parseDouble(number);
                number = "";
            }
        });

        modButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator = '%';
                num1 = Double.parseDouble(number);
                number = "";
            }
        });

        // equals button
        equalsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // saves num2 as the number the user entered after hitting the equals button
                num2 = Double.parseDouble(number);

                // checks division by 0 error
                if (num2 == 0) {
                    outputLabel.setText("undefined");
                    return;
                }

                // if statement that performs the correct operation for each operator the user selected (+, -, /, *, %)
                if (operator == '+') {

                    if ((num1 + num2) % 1 == 0) {
                        number = "" + (int)(num1 + num2);
                    } else {
                        number = "" + (num1 + num2);
                    }

                } else if (operator == '-') {

                    if ((num1 - num2) % 1 == 0) {
                        number = "" + (int)(num1 - num2);
                    } else {
                        number = "" + (num1 - num2);
                    }

                } else if (operator == '*') {

                    if ((num1 * num2) % 1 == 0) {
                        number = "" + (int)(num1 * num2);
                    } else {
                        number = "" + (num1 * num2);
                    }

                } else if (operator == '/') {

                    if ((num1 / num2) % 1 == 0) {
                        number = "" + (int)(num1 / num2);
                    } else {
                        number = "" + (num1 / num2);
                    }

                } else if (operator == '%') {
                    
                    if ((num1 % num2) % 1 == 0) {
                        number = "" + (int)(num1 % num2);
                    } else {
                        number = "" + (num1 % num2);
                    }

                }

                outputLabel.setText(number);        // sets label to resulted number
                operator = ' ';                     // sets operator to blank
                postEquals = true;                  // sets post equals to true
            }
        });

        // trig functions
            // if trig function resulted in integer, displays integer, else display floating-point number
            // sets the label to the resulted number
            // sets post equals to true
        sinButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if (Math.sin(Double.parseDouble(number)) % 1 == 0) {
                    number = "" + (int)Math.sin(Double.parseDouble(number));
                } else {
                    number = "" + Math.sin(Double.parseDouble(number));
                }

                outputLabel.setText(number);

                postEquals = true;
            }
        });

        cosButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Math.cos(Double.parseDouble(number)) % 1 == 0) {
                    number = "" + (int)Math.cos(Double.parseDouble(number));
                } else {
                    number = "" + Math.cos(Double.parseDouble(number));
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        tanButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Math.tan(Double.parseDouble(number)) % 1 == 0) {
                    number = "" + (int)Math.tan(Double.parseDouble(number));
                } else {
                    number = "" + Math.tan(Double.parseDouble(number));
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        sinhButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Math.sinh(Double.parseDouble(number)) % 1 == 0) {
                    number = "" + (int)Math.sinh(Double.parseDouble(number));
                } else {
                    number = "" + Math.sinh(Double.parseDouble(number));
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        coshButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Math.cosh(Double.parseDouble(number)) % 1 == 0) {
                    number = "" + (int)Math.cosh(Double.parseDouble(number));
                } else {
                    number = "" + Math.cosh(Double.parseDouble(number));
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        tanhButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Math.tanh(Double.parseDouble(number)) % 1 == 0) {
                    number = "" + (int)Math.tanh(Double.parseDouble(number));
                } else {
                    number = "" + Math.tanh(Double.parseDouble(number));
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        asinButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Math.asin(Double.parseDouble(number)) % 1 == 0) {
                    number = "" + (int)Math.asin(Double.parseDouble(number));
                } else {
                    number = "" + Math.asin(Double.parseDouble(number));
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        acosButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Math.acos(Double.parseDouble(number)) % 1 == 0) {
                    number = "" + (int)Math.acos(Double.parseDouble(number));
                } else {
                    number = "" + Math.acos(Double.parseDouble(number));
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        atanButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Math.atan(Double.parseDouble(number)) % 1 == 0) {
                    number = "" + (int)Math.atan(Double.parseDouble(number));
                } else {
                    number = "" + Math.atan(Double.parseDouble(number));
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        // absolute value functions (work the same way as trig functions)

        absButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Double.parseDouble(number) % 1 == 0) {
                    number = "" + Math.abs(Integer.parseInt(number));
                } else {
                    number = "" + Math.abs(Double.parseDouble(number));
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        // log functions (work the same way as trig functions)

        lnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Double.parseDouble(number) == 0.0) {
                    outputLabel.setText("undefined");
                    return;
                }

                number = "" + Math.log(Double.parseDouble(number));
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        logButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Double.parseDouble(number) % 1 == 0) {
                    number = "" + Math.log(Integer.parseInt(number));
                } else {
                    number = "" + Math.log(Double.parseDouble(number));
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        // sqrt, x^2, x^3, 10^x, 1/n, % buttons (works the same as trig funcs)

        sqrtButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Double.parseDouble(number) % 1 == 0) {
                    number = "" + (int)Math.sqrt(Integer.parseInt(number));
                } else {
                    number = "" + Math.sqrt(Double.parseDouble(number));
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        squareButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Double.parseDouble(number) % 1 == 0) {
                    number = "" + (int) Math.pow(Integer.parseInt(number), 2);
                } else {
                    number = "" + Math.pow(Double.parseDouble(number), 2);
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        cubeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Double.parseDouble(number) % 1 == 0) {
                    number = "" + (int) Math.pow(Integer.parseInt(number), 3);
                } else {
                    number = "" + Math.pow(Double.parseDouble(number), 3);
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        power10Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Double.parseDouble(number) % 1 == 0) {
                    number = "" + (int) Math.pow(10, Integer.parseInt(number));
                } else {
                    number = "" + Math.pow(10, Double.parseDouble(number));
                }
                outputLabel.setText(number);

                postEquals = true;
            }
        });

        inverseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if ((1.0 / Double.parseDouble(number)) % 1 == 0) {
                    number = "" + (1.0 / Integer.parseInt(number));
                } else {
                    number = "" + (1.0 / Double.parseDouble(number));
                }

                outputLabel.setText(number);
                postEquals = true;
            }
        });

        percentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if ((Double.parseDouble(number) / 100.0) % 1 == 0) {
                    number = "" + (Integer.parseInt(number) / 100.0);
                } else {
                    number = "" + (Double.parseDouble(number) / 100.0);
                }

                outputLabel.setText(number);

                postEquals = true;
            }
        });

        // exit buttons
        // stops the program
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });



        
        applicationStage.setScene(scene);           // Set window's scene
        applicationStage.setTitle("Calculator");    // Set window's title
        applicationStage.setResizable(false);       // makes window non resizeable
        applicationStage.show();                    // Displays window

    }

    public static void main(String[] args) {
        launch(args);                               // launches calculator
    }
}
